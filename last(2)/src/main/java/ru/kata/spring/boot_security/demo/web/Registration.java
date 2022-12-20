package ru.kata.spring.boot_security.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.user.UserService;

@Controller
@RequestMapping("/registration")
public class Registration {
        private UserService userService;

        public Registration(UserService userService) {
            this.userService = userService;
        }

        @ModelAttribute("user")
        public User user(){
            return new User();
        }

        @GetMapping
        public String registrationForm() {
            return "registration";
        }

        @PostMapping
        public String registrationUser(@ModelAttribute("user") User user) {
            userService.createNewUser(user);
            return "redirect:/registration?success";
        }
}
