package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.Product;
import brs.AI_Shop.Repository.ProductRepository;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {
    private HashMap<Integer, Product> cart = new HashMap<>();
    @Autowired
    private ProductRepository productRepository;
    private int count = 1;

    @GetMapping("/cart")
    public String cart(Model model) {
        //model.addAttribute("keys", cart.keySet());
//        model.addAttribute("products", cart.entrySet());
        model.addAttribute("hashmap", cart);
        return "cart.html";
    }

    @GetMapping("/addtocart")
    public String addtocart(){return "products.html";}

    @PostMapping("/products")
    public void addToCart(@RequestParam("product") int sku, HttpServletResponse response) {
        // Retrieve the corresponding product object from your database or wherever your products are stored
        Product product = productRepository.findBySku(sku);
        cart.put(count, product);
        count++;
        try{
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/remove")
    public void removeFromCart(@RequestParam("key") int key, HttpServletResponse response) {
        cart.remove(key);
        try{
            response.sendRedirect("/cart");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}





