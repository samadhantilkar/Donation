package com.project.Donation.service;

import com.project.Donation.dto.DonationRequestDto;
import com.project.Donation.entity.DonationRequest;

import java.util.List;

public interface DonationRequestService {
    DonationRequestDto createDonationRequest(DonationRequestDto donationRequestDto);

    List<DonationRequestDto> getMyDonationRequest();

    DonationRequestDto getDonationRequestById(Long requestId);

    void assignVolunteerToDonationRequest(Long donationRequestId, Long volunteerId);
}
