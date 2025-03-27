package com.project.Donation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

//    private final DonationService donationService;
//    private final UserService userService;
//    private final DonationRequestService donationRequestService;
//
//    @GetMapping
//    public ResponseEntity<List<DonationDto>> getAllDonations(){
//        return ResponseEntity.ok(donationService.getAllDonations());
//    }
//
//    @GetMapping("/getAllVolunteer")
//    public ResponseEntity<List<UserDto>> getAllVolunteer(){
//        return ResponseEntity.ok(userService.getAllVolunteer());
//    }
//
//    @PutMapping("/donation-requests/{donationRequestId}/volunteers/{volunteerId}")
//    public ResponseEntity<Void> assignVolunteerToDonationRequest(@PathVariable(name = "donationRequestId") Long donationRequestId,
//                                                                 @PathVariable(name = "volunteerId") Long volunteerId){
//
//        donationRequestService.assignVolunteerToDonationRequest(donationRequestId,volunteerId);
//        return ResponseEntity.notFound().build();
//    }
}
