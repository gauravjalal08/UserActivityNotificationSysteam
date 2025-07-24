package com.gauravsinghjalal.User.Activity.Notification.System.Service;

import com.gauravsinghjalal.User.Activity.Notification.System.Entity.UserEntity;
import com.gauravsinghjalal.User.Activity.Notification.System.Mapper.UserMapper;
import com.gauravsinghjalal.User.Activity.Notification.System.Model.LoginDto;
import com.gauravsinghjalal.User.Activity.Notification.System.Model.RegisterDto;
import com.gauravsinghjalal.User.Activity.Notification.System.Model.UserDto;
import com.gauravsinghjalal.User.Activity.Notification.System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(RegisterDto registerDto){
        if(userRepository.findByEmail(registerDto.getEmail()).isPresent()){
            throw new RuntimeException("Email already Registered");
        }
        UserEntity userEntity= new UserEntity();
        userEntity.setName(registerDto.getName());
        userEntity.setEmail(registerDto.getEmail());
        userEntity.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        userEntity.setRoles(registerDto.getRole());
        userRepository.save(userEntity);
        return "User registered successfully";
    }

    public String login(LoginDto loginDto){
        UserEntity userEntity = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));
        if (passwordEncoder.matches(loginDto.getPassword(), userEntity.getPassword())){
            return  "login Successfully";
        }
        else {
            throw new RuntimeException("Invalid password");
        }
    }

    public UserDto getUser(Long id){
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found "));
        return UserMapper.userDto(userEntity);
    }
    public UserDto createUsers(UserDto userDto){
        UserEntity userEntity= UserMapper.userEntity(userDto);
        UserEntity saved= userRepository.save(userEntity);
        return UserMapper.userDto(saved);
    }
}
