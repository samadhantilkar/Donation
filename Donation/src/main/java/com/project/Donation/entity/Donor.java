package com.project.Donation.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Donor extends BaseEntity{
    private String fnName;
    private String lName;
    private String email;
    private String username;
    private String password;
    private Long contact;
    private String address;
}
