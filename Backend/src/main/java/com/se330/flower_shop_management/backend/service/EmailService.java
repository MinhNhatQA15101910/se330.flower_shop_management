package com.se330.flower_shop_management.backend.service;

import com.se330.flower_shop_management.backend.dto.UserDto;
import jakarta.mail.MessagingException;

public interface EmailService {
    void sendEmail(String email) throws MessagingException;
}
