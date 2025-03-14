package com.project.Donation.controller;


import com.project.Donation.dto.DonationRequestDto;
import com.project.Donation.entity.DonationRequest;
import com.project.Donation.service.DonationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/donationRequest")
public class DonationController {

    private final DonationRequestService donationRequestService;

    @PostMapping
    private ResponseEntity<DonationRequestDto> donationRequest(@RequestBody DonationRequestDto donationRequestDto){
        return new ResponseEntity<>(donationRequestService.createDonationRequest(donationRequestDto), HttpStatus.CREATED);
    }
}
