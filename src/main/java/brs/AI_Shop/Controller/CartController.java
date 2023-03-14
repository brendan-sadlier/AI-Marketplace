package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.Product;
import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
public class CartController {
    private HashMap<Integer, Product> cart = new HashMap<>();
    private int count = 1;

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("products", cart.values());
        return "cart.html";
    }

    @GetMapping("/addtocart")
    public String returnItem(){return "item.html";}

    @PostMapping("/addtocart")
    public void addToCart(@RequestParam("product") Product product) {
        cart.put(count, product);
        count++;
    }

    @PostMapping("/myhashmap")
    public void addMyHashMapEntry(@RequestBody Product product) {
        cart.put(count, product);
        count++;
    }
}
