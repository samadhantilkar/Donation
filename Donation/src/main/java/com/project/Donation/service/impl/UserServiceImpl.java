package com.project.Donation.service.impl;

import com.project.Donation.dto.DonationRequestDto;
import com.project.Donation.dto.UserDto;
import com.project.Donation.entity.Enum.ROLE;
import com.project.Donation.entity.User;
import com.project.Donation.exception.AuthenticationException;
import com.project.Donation.exception.ResourceNotFoundException;
import com.project.Donation.repository.DonationRepository;
import com.project.Donation.repository.UserRepository;
import com.project.Donation.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.Donation.util.AppUtil.getCurrentUser;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService , UserDetailsService {

    private final UserRepository userRepository;
    private final DonationRepository donationRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow( ()->
                new ResourceNotFoundException("User not found with Id:"+id));
    }

    @Override
    public UserDto getProfile(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User not found with user Id:"+userId));

        User currentUser=getCurrentUser();

        if(!user.equals(currentUser)){
            throw new AuthenticationException("You are trying to access other user profile");
        }

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User getVolunteer(String city) {
        List<User> users=userRepository.findByCityAndRole(city, ROLE.VOLUNTEER);

        users.sort((user1,user2) -> Integer.compare(user2.getVerificationReports().size(),user1.getVerificationReports().size()));

        return users.getFirst();
    }

    @Override
    public List<DonationRequestDto> getAllMyDonations() {
        User user=getCurrentUser();

        return donationRepository.findByDonor(user).stream()
                .map(donation -> modelMapper.map(donation,DonationRequestDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getAllVolunteer() {
        User user=getCurrentUser();

        List<User> allVolunteerInCity=userRepository.findByRoleAndCity(ROLE.VOLUNTEER,user.getCity());

        return allVolunteerInCity
                .stream()
                .map((element) -> modelMapper.map(element, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElse(null);
    }
}
