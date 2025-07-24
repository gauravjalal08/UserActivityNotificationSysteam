package com.gauravsinghjalal.User.Activity.Notification.System.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String password;
    private String email;
    private Set<Role> role;

    }

