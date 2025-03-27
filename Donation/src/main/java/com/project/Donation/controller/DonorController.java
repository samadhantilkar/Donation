package com.project.Donation.controller;

import com.project.Donation.dto.DonorDto;
import com.project.Donation.service.DonorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donor")
@CrossOrigin(origins = "http://localhost:5500")
@Slf4j
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUpDonor(@RequestBody DonorDto dto){
        log.info("Request Come");
        donorService.signUpDonor(dto);
        return ResponseEntity.ok().build();
    }
}