package com.project.Donation.dto;

import com.project.Donation.entity.Enum.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private String name;

    private String email;

    private Long phoneNumber;

    private String city;

    private Long pinCode;

    private LocalDate dob;

    private Gender gender;
}
