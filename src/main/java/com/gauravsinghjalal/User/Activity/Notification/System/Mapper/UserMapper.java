package com.gauravsinghjalal.User.Activity.Notification.System.Mapper;

import com.gauravsinghjalal.User.Activity.Notification.System.Entity.UserEntity;
import com.gauravsinghjalal.User.Activity.Notification.System.Model.UserDto;

public class UserMapper {
    public static UserDto userDto(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setRoles(userEntity.getRoles());
        userDto.setPassword(userEntity.getPassword());
        return userDto;
    }
    public static  UserEntity userEntity(UserDto userDto){
        UserEntity  userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setRoles(userDto.getRoles());
        userEntity.setPassword(userDto.getPassword());
        return userEntity;
    }
}
