package com.project.Donation.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends BaseEntity{
    private String adminId;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
}
