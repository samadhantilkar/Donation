package com.project.Donation.dto;

import lombok.Data;

@Data
public class DonorDto {
    private String fnName;
    private String lName;
    private String email;
    private String username;
    private String password;
    private Long contact;
    private String address;
}
