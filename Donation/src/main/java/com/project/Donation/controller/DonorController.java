package com.project.Donation.controller;

import com.project.Donation.dto.DonorDto;
import com.project.Donation.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donor")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUpDonor(@RequestBody DonorDto dto){
        donorService.signUpDonor(dto);
    }



}
