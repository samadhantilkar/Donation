package com.project.Donation.dto;

import com.project.Donation.entity.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequestDto {
    private String email;
    private String name;
    private String password;
    private Long phoneNumber;
    private String city;
    private Long pinCode;
    private Gender gender;
}
