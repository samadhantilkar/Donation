package com.project.Donation.entity;

import com.project.Donation.entity.Enum.VerificationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class VerificationReport extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VerificationStatus status;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @ElementCollection
    private List<String> images;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private User assignedVolunteer;  // VOLUNTEER who verified

    @OneToOne
    @JoinColumn(name = "donation_request_id")
    private DonationRequest donationRequest;  // Request being verified
}
