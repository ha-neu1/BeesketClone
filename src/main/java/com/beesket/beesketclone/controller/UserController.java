package com.beesket.beesketclone.controller;

import com.beesket.beesketclone.dto.SignupRequestDto;
import com.beesket.beesketclone.exception.CustomException;
import com.beesket.beesketclone.exception.ErrorCode;
import com.beesket.beesketclone.model.User;
import com.beesket.beesketclone.security.UserDetailsImpl;
import com.beesket.beesketclone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
//@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserService userService;

    //회원가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@Valid @RequestBody SignupRequestDto requestDto) {
        String res = userService.registerUser(requestDto);
        if (res.equals("")) {
            return "회원가입 성공";
        } else {
            return res;
        }

    }

    //로그인 유저 정보
    @GetMapping("user/login/auth")
    public User userDetails(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.userInfo(userDetails);
    }


}
