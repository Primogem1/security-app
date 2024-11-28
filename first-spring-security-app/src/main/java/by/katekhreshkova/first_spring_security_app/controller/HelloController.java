package by.katekhreshkova.first_spring_security_app.controller;

import by.katekhreshkova.first_spring_security_app.models.Person;
import by.katekhreshkova.first_spring_security_app.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/showUserInfo")
    public Person showUserInfo() {
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails pd = (PersonDetails) authentication.getPrincipal();
        return pd.getPerson();
    }
}
