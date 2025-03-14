package com.project.Donation.service.impl;

import com.project.Donation.dto.DonationRequestDto;
import com.project.Donation.entity.DonationRequest;
import com.project.Donation.entity.Enum.VerificationStatus;
import com.project.Donation.entity.User;
import com.project.Donation.entity.VerificationRepost;
import com.project.Donation.repository.DonationRequestRepository;
import com.project.Donation.repository.VerificationRepostRepository;
import com.project.Donation.service.DonationRequestService;
import com.project.Donation.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.project.Donation.util.AppUtil.getCurrentUser;

@Service
@Slf4j
@RequiredArgsConstructor
public class DonationRequestServiceImpl implements DonationRequestService {

    private final DonationRequestRepository donationRequestRepository;
    private final VerificationRepostRepository verificationRepostRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public DonationRequestDto createDonationRequest(DonationRequestDto donationRequestDto) {
        User user=getCurrentUser();

        DonationRequest donationRequest=modelMapper.map(donationRequestDto,DonationRequest.class);

        User volunteer=userService.getVolunteer(donationRequest.getCity());
        VerificationRepost verificationRepost=VerificationRepost.builder()
                        .status(VerificationStatus.PENDING)
                        .assignedVolunteer(volunteer)
                        .build();

        VerificationRepost savedVerificationRepost=verificationRepostRepository.save(verificationRepost);

        donationRequest.setVerificationRepost(savedVerificationRepost);
        donationRequest.setRequester(user);

        donationRequest.setAmountCollected(0D);
        donationRequest.setAssignedVolunteer(volunteer);
        DonationRequest savedDonationRequest=donationRequestRepository.save(donationRequest);

        return modelMapper.map(savedDonationRequest,DonationRequestDto.class);
    }
}
