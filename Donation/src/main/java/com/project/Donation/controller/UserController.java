package com.project.Donation.controller;

import com.project.Donation.dto.DonationRequestDto;
import com.project.Donation.dto.UserDto;
import com.project.Donation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getProfile(@PathVariable(name = "userId") Long userId){
        return ResponseEntity.ok(userService.getProfile(userId));
    }

    @GetMapping("/my-donations")
    public ResponseEntity<List<DonationRequestDto>> getAllMyDonations(){
        return ResponseEntity.ok(userService.getAllMyDonations());
    }



}
