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

@Controller
public class CartController {
    private HashMap<Integer, Product> cart = new HashMap<>();
    @Autowired
    private ProductRepository productRepository;
    private int count = 1;

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("products", cart.values());
        return "cart.html";
    }

    @GetMapping("/addtocart")
    public String addtocart(){return "products.html";}

    @PostMapping("/products")
    public void addToCart(@RequestParam("product") int sku,
                          @RequestParam("quantity") int quantity,
                          HttpServletResponse response) {
        // Retrieve the corresponding product object from your database or wherever your products are stored
        if(quantity > 0) {
            for (int i = 0; i < quantity; i++) {
                Product product = productRepository.findBySku(sku);
                cart.put(count, product);
                count++;
            }
        }
        try{
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}





