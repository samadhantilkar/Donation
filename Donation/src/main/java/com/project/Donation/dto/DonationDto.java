package com.project.Donation.dto;

import com.project.Donation.entity.Enum.PaymentStatus;
import lombok.Data;

@Data
public class DonationDto {

    private Double amount;

    private PaymentStatus paymentStatus;

    private String transactionId;

    private UserDto donor;

    private DonationRequestDto donationRequest;
}
