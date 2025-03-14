package com.project.Donation.service.impl;

import com.project.Donation.dto.VerificationReportDto;
import com.project.Donation.entity.Enum.ROLE;
import com.project.Donation.entity.User;
import com.project.Donation.entity.VerificationReport;
import com.project.Donation.exception.AuthenticationException;
import com.project.Donation.exception.ResourceNotFoundException;
import com.project.Donation.repository.VerificationRepostRepository;
import com.project.Donation.service.VerificationReportService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.project.Donation.util.AppUtil.getCurrentUser;

@Service
@RequiredArgsConstructor
public class VerificationReportServiceImpl implements VerificationReportService {

    private final VerificationRepostRepository verificationRepostRepository;
    private final ModelMapper modelMapper;

    @Override
    public VerificationReportDto updateVerificationRepost(VerificationReportDto reportDto,Long reportId) {

        User user=getCurrentUser();

        VerificationReport verificationReport=verificationRepostRepository.findById(reportId).orElseThrow(()->
                new ResourceNotFoundException("Report not found with id:"+reportId));

        if(!verificationReport.getAssignedVolunteer().equals(user)){
            throw new AuthenticationException("you are not the volunteer for report with id"+reportId);
        }

        verificationReport.setStatus(reportDto.getStatus());

        return  modelMapper.map(verificationRepostRepository.save(verificationReport),VerificationReportDto.class);
    }
}
