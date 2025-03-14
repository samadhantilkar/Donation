package com.project.Donation.service.impl;

import com.project.Donation.dto.SignUpRequestDto;
import com.project.Donation.dto.SignUpResponseDto;
import com.project.Donation.dto.UserDto;
import com.project.Donation.entity.Enum.ROLE;
import com.project.Donation.entity.User;
import com.project.Donation.exception.AuthenticationException;
import com.project.Donation.exception.ResourceNotFoundException;
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
import java.util.Optional;

import static com.project.Donation.util.AppUtil.getCurrentUser;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService , UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpResponseDto signUp(SignUpRequestDto requestDto) {
        Optional<User> user=userRepository.findByEmail(requestDto.getEmail());

        if(user.isPresent()){
                    throw new AuthenticationException("User is already present with email:"+requestDto.getEmail());
        }
        User createToUser=modelMapper.map(requestDto,User.class);
//        createToUser.setRole(ROLE.USER);
        userRepository.save(createToUser);
        return new SignUpResponseDto();
    }

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

        UserDto userDto=modelMapper.map(user, UserDto.class);

        return  userDto;
    }

    @Override
    public User getVolunteer(String city) {
        List<User> users=userRepository.findByCityAndRole(city, ROLE.VOLUNTEER);

        users.sort((user1,user2) -> Integer.compare(user2.getVerificationReposts().size(),user1.getVerificationReposts().size()));

        return !users.isEmpty()?users.getFirst():null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElse(null);
    }
}
