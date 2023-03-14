package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.Product;
import brs.AI_Shop.Repository.OrderRepository;
import brs.AI_Shop.Repository.ProductRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class OwnerController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/dashboard")
    public String ownerDashboard() {
        return "owner.html";
    }
    @GetMapping("/add")
    public String addModel() {
        return "addModel.html";
    }

    @GetMapping("/viewOrders")
    public String viewOrders() {
        return "viewOrders.html";
    }

    @PostMapping("/add")
    public void addModel(HttpServletResponse response, @RequestParam int sku, @RequestParam String product_name, @RequestParam String description, @RequestParam double price, @RequestParam Boolean trained, @RequestParam double trained_price, @RequestParam String product_image) {
        Product product = new Product();
        product.setSku(sku);
        product.setProduct_name(product_name);
        product.setDescription(description);
        product.setPrice(price);
        product.setTrained(trained);
        product.setTrained_price(trained_price);
        product.setProduct_image(product_image);
        productRepository.save(product);

        try {
            response.sendRedirect("/add");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}