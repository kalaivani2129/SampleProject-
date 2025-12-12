package com.NewMaven.MavenProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.NewMaven.MavenProject.Service.JwtService;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/generate")
    public String generateToken(
            @RequestParam String username,
            @RequestParam String password) {

        // Simple hardcoded validation (you can change)
        if ("kalai".equals(username) && "12345".equals(password)) {
            return jwtService.generateToken(username);
        }

        return "Invalid Credentials";
    }
}
