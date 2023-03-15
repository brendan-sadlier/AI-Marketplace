package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.Product;
import brs.AI_Shop.Repository.ProductRepository;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class CartController {
    private HashMap<Integer, Product> cart = new HashMap<>();
    private ProductRepository productRepository;
    private int count = 1;

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("products", cart.values());
        return "cart.html";
    }

//    @GetMapping("/addtocart")
//    public String addtocart(){return "products.html";}

    @PostMapping("/addtocart")
    public void addToCart(@RequestParam("product") int productSKU, HttpServletResponse response) {
        // Retrieve the corresponding product object from your database or wherever your products are stored
        Product product = productRepository.findBySku(productSKU);
//        product.setSku(69420);
//        productRepository.save(product);
        cart.put(count, product);
        count++;

        try {
            response.sendRedirect("/products");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}





