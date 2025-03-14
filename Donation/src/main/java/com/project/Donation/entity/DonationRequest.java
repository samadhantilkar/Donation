package com.project.Donation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DonationRequest extends BaseEntity{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double amountNeeded;

    @Column(nullable = false)
    private Double amountCollected;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private User requester;  //USER who created the request

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private User assignedVolunteer;  //  VOLUNTEER assigned to verify

    @OneToOne(mappedBy = "donationRequest",cascade = CascadeType.ALL)
    private VerificationRepost verificationRepost;   //Volunteer's report
}
