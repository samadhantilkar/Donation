package com.project.Donation.service;

import com.project.Donation.dto.DonationRequestDto;
import com.project.Donation.dto.SignUpRequestDto;
import com.project.Donation.dto.SignUpResponseDto;
import com.project.Donation.dto.UserDto;
import com.project.Donation.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    UserDto getProfile(Long userId);
    User getVolunteer(String city);

    List<DonationRequestDto> getAllMyDonations();

    List<UserDto> getAllVolunteer();
}
