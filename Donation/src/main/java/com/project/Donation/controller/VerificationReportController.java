package com.project.Donation.controller;

import com.project.Donation.dto.VerificationReportDto;
import com.project.Donation.service.VerificationReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteer")
@RequiredArgsConstructor
public class VerificationReportController {


    private final VerificationReportService verificationReportService;


    @PutMapping("/verification-report/{reportId}")
    public ResponseEntity<VerificationReportDto> updateVerificationReport(@PathVariable Long reportId,
            @RequestBody VerificationReportDto reportDto){
        return ResponseEntity.ok(verificationReportService.updateVerificationRepost(reportDto,reportId));
    }

}
