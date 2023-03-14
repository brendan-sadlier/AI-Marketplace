package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.Product;
import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@Controller
public class CartController {
    private HashMap<Integer, Product> cart = new HashMap<>();
    private int count = 1;



    @GetMapping("/addtocart")
    public String returnItem(){
        return "item.html";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart.html";
    }

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
