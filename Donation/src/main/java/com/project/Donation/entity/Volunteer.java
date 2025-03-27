package com.project.Donation.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Volunteer extends BaseEntity{
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String  address;
    private LocalDateTime DateOfBirth;
    private LocalDateTime lastDeliveryDate;
    private String password;
}
