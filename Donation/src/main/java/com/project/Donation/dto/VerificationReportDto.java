package com.project.Donation.dto;

import com.project.Donation.entity.Enum.VerificationStatus;
import lombok.Data;

@Data
public class VerificationReportDto {
    private Long id;
    private VerificationStatus status;
    private String comments;
}
