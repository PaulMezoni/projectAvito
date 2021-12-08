package com.amr.project.webapp.rest_controller;

import com.amr.project.service.email.EmailVerificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class EmailVerificationController {

    private EmailVerificationService verificationService;

    @GetMapping("/registrationConfirm")
    public String verifyEmail(@RequestParam(name="email") String email, @RequestParam(name = "token") String token) {
        return verificationService.activateUser(email, token);
    }
}