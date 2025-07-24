package com.gauravsinghjalal.User.Activity.Notification.System.Controller;

import com.gauravsinghjalal.User.Activity.Notification.System.Model.LoginDto;
import com.gauravsinghjalal.User.Activity.Notification.System.Model.RegisterDto;
import com.gauravsinghjalal.User.Activity.Notification.System.Model.UserDto;
import com.gauravsinghjalal.User.Activity.Notification.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserBYId(@PathVariable Long id){
        return  ResponseEntity.ok(userService.getUser(id));
    }
    @GetMapping("/test")
    public String testEndpoint() {
        System.out.println("hello");
        return "Hello from server!";

    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUsers(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        return ResponseEntity.ok(userService.register(registerDto));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        return  ResponseEntity.ok(userService.login(loginDto));
    }
}
