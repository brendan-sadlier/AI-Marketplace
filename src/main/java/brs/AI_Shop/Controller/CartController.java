package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.Product;
import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
@Controller
public class CartController {
    private HashMap<Product, Integer> cart = new HashMap<>();
    private int count = 1;

    @GetMapping("/addtocart")
    public String cart(Model model) {
        model.addAttribute("products", cart.values());
        return "cart.html";
    }


    @PostMapping("/addtocart")
    public @ResponseBody void addToCart(Product product){
        cart.put(product, count);
        count++;
    }
}
