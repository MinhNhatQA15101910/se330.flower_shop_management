package com.se330.flower_shop_management.backend.service;

import com.se330.flower_shop_management.backend.dto.UserDto;
import com.se330.flower_shop_management.backend.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
