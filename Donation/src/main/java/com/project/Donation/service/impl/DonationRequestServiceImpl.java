package com.project.Donation.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DonationRequestServiceImpl {
//    private final UserRepository userRepository;
//
//    private final DonationRequestRepository donationRequestRepository;
//    private final VerificationRepostRepository verificationRepostRepository;
//    private final UserService userService;
//    private final ModelMapper modelMapper;
//
//
//    @Override
//    @Transactional
//    public DonationRequestDto createDonationRequest(DonationRequestDto donationRequestDto) {
//        User user=getCurrentUser();
//
//        DonationRequest donationRequest=modelMapper.map(donationRequestDto,DonationRequest.class);
//
//        User volunteer=userService.getVolunteer(donationRequest.getCity());
//        VerificationReport verificationReport = VerificationReport.builder()
//                        .status(VerificationStatus.PENDING)
//                        .assignedVolunteer(volunteer)
//                        .build();
//
//        VerificationReport savedVerificationReport =verificationRepostRepository.save(verificationReport);
//
//        donationRequest.setVerificationReport(savedVerificationReport);
//        donationRequest.setRequester(user);
//
//        donationRequest.setAmountCollected(0D);
//        donationRequest.setAssignedVolunteer(volunteer);
//        DonationRequest savedDonationRequest=donationRequestRepository.save(donationRequest);
//
//        return modelMapper.map(savedDonationRequest,DonationRequestDto.class);
//    }
//
//    @Override
//    public List<DonationRequestDto> getMyDonationRequest() {
//        User user=getCurrentUser();
//
//        List<DonationRequest> donationRequests=donationRequestRepository.findByRequesterId(user.getId());
//
//        return donationRequests.stream()
//                .map(request -> modelMapper.map(request,DonationRequestDto.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public DonationRequestDto getDonationRequestById(Long requestId) {
//        DonationRequest donationRequest=donationRequestRepository.findById(requestId).orElseThrow(()->
//                new ResourceNotFoundException("Donation Request not found with Id"+requestId));
//
//        return modelMapper.map(donationRequest,DonationRequestDto.class);
//
//
//    }
//
//    @Override
//    public void assignVolunteerToDonationRequest(Long donationRequestId, Long volunteerId) {
//        User user=getCurrentUser();
//
//        DonationRequest donationRequest=donationRequestRepository.findById(donationRequestId)
//                .orElseThrow(()-> new ResourceNotFoundException("Donation Request Not Found For ID: "+donationRequestId));
//
//        if(donationRequest.getVerificationReport().getStatus().equals(VerificationStatus.VERIFIED)){
//            throw new IllegalStateException("Donation Request Is Status is Approve so you don't assign volunteer now");
//        }
//
//        User volunteer=userRepository.findById(volunteerId)
//                .orElseThrow( ()-> new ResourceNotFoundException("Volunteer Not found with id:"+volunteerId) );
//
//        donationRequest.getVerificationReport().setAssignedVolunteer(volunteer);
//
//        donationRequestRepository.save(donationRequest);
//
//    }
}
