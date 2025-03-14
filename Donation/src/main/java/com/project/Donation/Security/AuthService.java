package com.project.Donation.Security;

import com.project.Donation.dto.LoginDto;
import com.project.Donation.dto.SignUpRequestDto;
import com.project.Donation.dto.SignUpResponseDto;
import com.project.Donation.entity.Enum.ROLE;
import com.project.Donation.entity.User;
import com.project.Donation.exception.ResourceNotFoundException;
import com.project.Donation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public SignUpResponseDto signUp(SignUpRequestDto requestDto){
        User user=userRepository.findByEmail(requestDto.getEmail()).orElse(null);
        if(user!=null){
            throw  new RuntimeException("User is already present with same email id:"+requestDto.getEmail());
        }
        User newUser=modelMapper.map(requestDto,User.class);
        newUser.setRole(Set.of(ROLE.USER,ROLE.VOLUNTEER,ROLE.ADMIN));
        newUser.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        userRepository.save(newUser);
        return modelMapper.map(newUser,SignUpResponseDto.class);
    }

    public String[] login(LoginDto loginDto){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword())
        );

        User user=(User) authentication.getPrincipal();

        String[] token = new String[2];
        token[0]= jwtService.generateAccessToken(user);
        token[1]= jwtService.generateRefreshToken(user);

        return token;
    }

    public String refreshToken(String refreshToken){

        Long id=jwtService.getUserIdFromToken(refreshToken);

        User user=userRepository.findById(id).orElseThrow( ()->
                new ResourceNotFoundException("User not found with Id:"+id));

        return jwtService.generateAccessToken(user);
    }

}
