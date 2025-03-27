package com.project.Donation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationReportServiceImpl  {

//    private final VerificationRepostRepository verificationRepostRepository;
//    private final ModelMapper modelMapper;
//
//    @Override
//    public VerificationReportDto updateVerificationRepost(VerificationReportDto reportDto,Long reportId) {
//
//        User user=getCurrentUser();
//
//        VerificationReport verificationReport=verificationRepostRepository.findById(reportId).orElseThrow(()->
//                new ResourceNotFoundException("Report not found with id:"+reportId));
//
//        if(!verificationReport.getAssignedVolunteer().equals(user)){
//            throw new AuthenticationException("you are not the volunteer for report with id"+reportId);
//        }
//
//        verificationReport.setStatus(reportDto.getStatus());
//
//        return  modelMapper.map(verificationRepostRepository.save(verificationReport),VerificationReportDto.class);
//    }
}
