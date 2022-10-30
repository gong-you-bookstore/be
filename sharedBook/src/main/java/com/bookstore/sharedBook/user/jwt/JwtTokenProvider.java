package com.bookstore.sharedBook.user.jwt;

import com.bookstore.sharedBook.user.repository.UserRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    @Value("${secret.access}")
    private String SECRET_KEY;
    private final long accessTokenValidTime = 60 * 60 * 24 * 1000L;
    private Key key;
    private UserRepository userRepository;

    @PostConstruct
    protected void init() {
        byte[] bytes = Decoders.BASE64.decode(SECRET_KEY);
        key = Keys.hmacShaKeyFor(bytes);
    }

    public String createAccessToken(String userId) {
        Claims claims = Jwts.claims().setSubject(userId);
        Date now = new Date();

        String accessToken =  Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + accessTokenValidTime))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return accessToken;
    }

    public boolean validateToken(HttpServletRequest request, String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            request.setAttribute("exception", -2);
        } catch (JwtException e) {
            request.setAttribute("exception", -4);
        }
        return false;
    }

    public Authentication getAuthentication(String accessToken){
        Claims claims = getClaims(accessToken);

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(
                                claims.get("roles").toString()
                                        .replaceAll("^\\[", "")
                                        .replaceAll("]$", "")
                                        .split(", ")
                        ).map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(
                new User(claims.getSubject(), "", authorities),
                "",
                authorities
        );

    }

    public String getUserIdFromToken(String accessToken){
        String userIdFromToken = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody().getSubject();
        return userIdFromToken;
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
