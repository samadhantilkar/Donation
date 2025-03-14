package com.project.Donation.dto;

import com.project.Donation.entity.User;
import com.project.Donation.entity.VerificationRepost;
import lombok.Data;

@Data
public class DonationRequestDto {
    private String title;

    private String description;

    private Double amountNeeded;

    private Double amountCollected;

    private String city;

    private String location;

    private UserDto requester;  //USER who created the request

    private UserDto assignedVolunteer;  //  VOLUNTEER assigned to verify

    private VerificationReportDto verificationRepost;
}
