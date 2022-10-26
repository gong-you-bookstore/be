package com.bookstore.sharedBook.user.controller;

import com.bookstore.sharedBook.common.ResponseService;
import com.bookstore.sharedBook.common.SingleResult;
import com.bookstore.sharedBook.user.dto.request.UserRequestDto;
import com.bookstore.sharedBook.user.dto.response.UserResponseDto;
import com.bookstore.sharedBook.user.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;
    private final ResponseService responseService;

    @PostMapping("/signup")
    public ResponseEntity<SingleResult<UserResponseDto>> signup(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(responseService.getSingleResult(userService.register(userRequestDto)), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<SingleResult<UserResponseDto>> signin(@RequestBody UserRequestDto userRequestDto){
        return null;
    }
}
