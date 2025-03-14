package com.project.Donation.service;

import com.project.Donation.dto.DonationDto;

import java.util.List;

public interface DonationService {
    List<DonationDto> getAllDonations();
}
