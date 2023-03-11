package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.User;
import brs.AI_Shop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/register")
    public String register() {
        return "register.html";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String full_name, @RequestParam String password, @RequestParam String email, @RequestParam String username) {

        User user = new User();
        user.setFull_name(full_name);
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);

        userRepository.save(user);

        return "redirect:/";
    }
}
