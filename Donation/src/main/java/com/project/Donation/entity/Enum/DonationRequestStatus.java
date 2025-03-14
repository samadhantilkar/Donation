package com.project.Donation.entity.Enum;

public enum DonationRequestStatus {
    PENDING,      // Waiting for volunteer assignment
    UNDER_REVIEW, // Volunteer is verifying
    APPROVED,     // Admin approved after verification
    DENIED
}
