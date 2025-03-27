package com.project.Donation.controller;


import com.project.Donation.dto.DonationRequestDto;
import com.project.Donation.service.DonationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/donationRequest")
public class DonationRequestController {
//
//    private final DonationRequestService donationRequestService;
//
//    @PostMapping
//    private ResponseEntity<DonationRequestDto> donationRequest(@RequestBody DonationRequestDto donationRequestDto){
//        return new ResponseEntity<>(donationRequestService.createDonationRequest(donationRequestDto), HttpStatus.CREATED);
//    }
//
//    @GetMapping("my-donation-request")
//    private ResponseEntity<List<DonationRequestDto>> getMyDonationRequest(){
//        return ResponseEntity.ok(donationRequestService.getMyDonationRequest());
//    }
//
//    @GetMapping("/{requestId}")
//    public ResponseEntity<DonationRequestDto> getDonationRequestById(@PathVariable(name = "requestId")  Long requestId){
//        return ResponseEntity.ok(donationRequestService.getDonationRequestById(requestId));
//    }

}
