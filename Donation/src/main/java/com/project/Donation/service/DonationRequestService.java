package com.project.Donation.service;

import com.project.Donation.dto.DonationRequestDto;
import com.project.Donation.entity.DonationRequest;

public interface DonationRequestService {
    DonationRequestDto createDonationRequest(DonationRequestDto donationRequestDto);
}
