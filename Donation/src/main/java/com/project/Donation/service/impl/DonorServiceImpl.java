package com.project.Donation.service.impl;

import com.project.Donation.dto.DonorDto;
import com.project.Donation.entity.Donor;
import com.project.Donation.repository.DonorRepository;
import com.project.Donation.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonorServiceImpl implements DonorService {


    private final DonorRepository donorRepository;
    private final ModelMapper modelMapper;

    public void signUpDonor(DonorDto dto){
        Donor donor=modelMapper.map(dto,Donor.class);
        donorRepository.save(donor);

    }

}
