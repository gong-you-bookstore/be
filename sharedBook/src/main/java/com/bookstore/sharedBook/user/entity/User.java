package com.bookstore.sharedBook.user.entity;

import com.bookstore.sharedBook.config.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
public class User extends BaseEntity {
    private String name;
    private String nickname;
    private String email;
    private String password;
    @ElementCollection(fetch= FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();
    private Integer yearOfBirth;
    private String gender;
    @ColumnDefault("3")
    private Integer token;

}
