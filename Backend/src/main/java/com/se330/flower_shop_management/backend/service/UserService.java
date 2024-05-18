package com.se330.flower_shop_management.backend.service;

import com.se330.flower_shop_management.backend.dto.*;
import com.se330.flower_shop_management.backend.entity.User;
import com.se330.flower_shop_management.backend.exception.UserEmailExistsException;
import com.se330.flower_shop_management.backend.exception.UserEmailNotExistsException;
import com.se330.flower_shop_management.backend.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    @Lazy
    private JwtService jwtService;
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String fromEmail;

    public User signup(SignupRequestDto signupRequestDto) {
        if (userRepository.findByEmail(signupRequestDto.getEmail()).isPresent()) {
            throw new UserEmailExistsException("User with the same email already exists!");
        }

        User user = new User();
        user.setUsername(signupRequestDto.getUsername());
        user.setEmail(signupRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));

        return userRepository.save(user);
    }

    public UserResponseDto login(LoginRequestDto loginRequestDto) throws Exception {
        User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow();

        if (user.getPassword().equals(passwordEncoder.encode(loginRequestDto.getPassword()))) {
            throw new Exception("Password does not correct.");
        }

        String jwt = jwtService.generateToken(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setToken(jwt);
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setImageUrl(user.getImageUrl());
        userResponseDto.setRole(user.getRole());
        userResponseDto.setSex(user.getSex());

        return userResponseDto;
    }

    public UserResponseDto loginGoogle(LoginGoogleRequestDto loginGoogleRequestDto) throws Exception {
        User user = userRepository.findByEmail(loginGoogleRequestDto.getEmail()).orElseThrow();

        if (user.getPassword().equals(passwordEncoder.encode(loginGoogleRequestDto.getPassword()))) {
            throw new Exception("Password does not correct.");
        }

        String jwt = jwtService.generateToken(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setToken(jwt);
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setImageUrl(user.getImageUrl());
        userResponseDto.setRole(user.getRole());
        userResponseDto.setSex(user.getSex());

        return userResponseDto;
    }

    public boolean checkExistsEmail(String email) throws Exception {
        return userRepository.findByEmail(email).isPresent();
    }

    public void sendEmail(String to, String pincode) throws RuntimeException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject("FlowerFly account verify code");

        String htmlContent = String.format(
                "<h2>FlowerFly account</h2>" +
                        "<h1 style=\"color:#23C16B;\">Verify code</h1>" +
                        "<p>Please use the following verify code for the FlowerFly account: %s</p>" +
                        "<p>Security code: <b>%s</b></p>" +
                        "<p>If you didn't request this code, you can safely ignore this email. Someone else might have typed your email address by mistake.</p>" +
                        "<br />" +
                        "<p>Thanks,</p>" +
                        "<p>The FlowerFly development team.</p>", hideEmailCharacters(to), pincode);

        helper.setText(htmlContent, true);

        mailSender.send(message);
    }

    public User changePassword(ChangePasswordDto changePasswordDto) {
        User user = userRepository.findByEmail(changePasswordDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String encodedNewPassword = passwordEncoder.encode(changePasswordDto.getNewPassword());
        user.setPassword(encodedNewPassword);

        userRepository.save(user);

        return user;
    }

    public User loadUserByEmail(String email) {
        if (userRepository.findByEmail(email).isEmpty()) {
            throw new UserEmailNotExistsException("User with this email does not exist!");
        }
        return userRepository.findByEmail(email).get();
    }

    private String hideEmailCharacters(String email) {
        int atPosition = email.indexOf("@");
        if (atPosition <= 1) {
            return email;
        }
        StringBuilder hiddenEmail = new StringBuilder(email);
        for (int i = 1; i < atPosition - 1; i++) {
            hiddenEmail.setCharAt(i, '*');
        }
        return hiddenEmail.toString();
    }
}
