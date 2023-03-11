package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.User;
import brs.AI_Shop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ShopController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }
}
