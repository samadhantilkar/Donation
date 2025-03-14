package com.project.Donation.entity;

import com.project.Donation.entity.Enum.Gender;
import com.project.Donation.entity.Enum.ROLE;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "userEntity")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
public class User extends BaseEntity implements UserDetails {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Long phoneNumber;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Long pinCode;

    private LocalDate dob;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    private Set<ROLE> role;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "requester", cascade = CascadeType.ALL)
    private List<DonationRequest> donationRequests;  // Requests created by this user

    @OneToMany(mappedBy = "assignedVolunteer",cascade = CascadeType.ALL)
    private List<VerificationReport> verificationReports;    // Volunteer's verification tasks


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.stream()
                .map(role1 -> new SimpleGrantedAuthority("ROLE_"+role1.name()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getUsername() {
        return email;
    }
}