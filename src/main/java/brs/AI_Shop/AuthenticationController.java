package brs.AI_Shop;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AuthenticationController {

    @Autowired UserRepository userRepository;

    @GetMapping("/login")
    public String login () {
        return "login.html";
    }


    @PostMapping("/login")
    public void getlogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model, HttpServletResponse response) {

        if (userRepository.exists(Example.of(user(username, password)))) {
            try {
                response.sendRedirect("/");
            } catch (IOException e) {e.printStackTrace();}
        }

    }

    private User user(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
