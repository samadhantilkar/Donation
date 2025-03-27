package com.project.Donation.controller;


import com.project.Donation.dto.LoginDto;
import com.project.Donation.dto.LoginResponseDto;
import com.project.Donation.dto.SignUpRequestDto;
import com.project.Donation.dto.SignUpResponseDto;
import com.project.Donation.exception.AuthenticationException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class AuthController {

//    private final AuthService authService;
//
//    @PostMapping("/signUp")
//    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){
//
//        SignUpResponseDto responseDto=authService.signUp(requestDto);
//
//        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
//        String[] token=authService.login(loginDto);
//
//        Cookie cookie=new Cookie("refreshToken",token[1]);
//        cookie.setHttpOnly(true);
//
//        httpServletResponse.addCookie(cookie);
//
//        return ResponseEntity.ok(new LoginResponseDto(token[0]));
//    }
//
//    @PostMapping("/refresh")
//    public ResponseEntity<LoginResponseDto> refreshToken(HttpServletRequest httpServletRequest){
//        String refreshToken= Arrays.stream(httpServletRequest.getCookies())
//                .filter(cookie -> "refreshToken".equals(cookie.getName()))
//                .findFirst()
//                .map(Cookie::getValue)
//                .orElseThrow( ()-> new AuthenticationServiceException("Refresh Token not found inside the Cookies"));
//        String accessToken=authService.refreshToken(refreshToken);
//        return ResponseEntity.ok(new LoginResponseDto(accessToken));
//
//    }

}
