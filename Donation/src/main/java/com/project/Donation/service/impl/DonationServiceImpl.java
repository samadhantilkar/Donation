package com.project.Donation.service.impl;

import com.project.Donation.dto.DonationDto;
import com.project.Donation.entity.Donation;
import com.project.Donation.entity.User;
import com.project.Donation.repository.DonationRepository;
import com.project.Donation.service.DonationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.Donation.util.AppUtil.getCurrentUser;

@Service
@RequiredArgsConstructor
@Slf4j
public class DonationServiceImpl implements DonationService {
    private final ModelMapper modelMapper;

    private final DonationRepository donationRepository;

    @Override
    public List<DonationDto> getAllDonations() {
        User user=getCurrentUser();

        List<Donation> donations=donationRepository.findByCity(user.getCity());

        return donations.stream()
                .map((element) -> modelMapper.map(element, DonationDto.class))
                .collect(Collectors.toList());
    }
}
