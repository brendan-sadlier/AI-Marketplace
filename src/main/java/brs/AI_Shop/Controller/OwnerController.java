package brs.AI_Shop.Controller;

import brs.AI_Shop.Model.Order;
import brs.AI_Shop.Model.Product;
import brs.AI_Shop.Repository.OrderRepository;
import brs.AI_Shop.Repository.ProductRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class OwnerController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/dashboard")
    public String ownerDashboard(Model model) {
        Boolean existsUnfulfilled = orderRepository.existsByFulfilledFalse();
        //List<Order> orders = orderRepository.findAll();
        model.addAttribute("existsUnfulfilled", existsUnfulfilled);

        long count = orderRepository.countByFulfilledFalse();
        //long count = orderRepository.countByFulfilledTrue();
        model.addAttribute("count", count);
        return "owner.html";
    }
    @GetMapping("/add")
    public String addModel() {
        return "addModel.html";
    }

    @GetMapping("/viewOrders")
    public String viewOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "viewOrders.html";
    }

    @GetMapping("/viewModels")
    public String viewModels(Model model){
        List<Product> models = productRepository.findAll();
        model.addAttribute("models", models);
        return "viewModels.html";
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

    @GetMapping("/editmodel/{sku}")
    public String editModel(@PathVariable int sku, Model model){
        Optional<Product> product = productRepository.findById(sku);
        model.addAttribute("product", product.orElse(null));
        return "editmodel.html";
    }

    @PostMapping("/editmodel/{sku}")
    public void updateModel(HttpServletResponse response, @RequestParam int sku, @RequestParam String product_name, @RequestParam String description, @RequestParam double price, @RequestParam Boolean trained, @RequestParam double trained_price, @RequestParam String product_image){
        Optional<Product> optionalProduct = productRepository.findById(sku);
        if(optionalProduct.isPresent()){
            Product newProduct = optionalProduct.get();
            productRepository.deleteById(sku);

            newProduct.setProduct_name(product_name);
            newProduct.setDescription(description);
            newProduct.setPrice(price);
            newProduct.setTrained(trained);
            newProduct.setTrained_price(trained_price);
            newProduct.setProduct_image(product_image);
            productRepository.save(newProduct);
            try{
                response.sendRedirect("/viewModels");
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            try{
                response.sendRedirect("/viewModels");
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @PostMapping("/viewOrders")
    public void fulfillOrder(HttpServletResponse response, @RequestParam("order_number") int order_number){
        Optional<Order> optionalOrder = orderRepository.findById(order_number);
        if(optionalOrder.isPresent()){
            Order currentOrder = optionalOrder.get();
            currentOrder.setFulfilled(true);
            orderRepository.save(currentOrder);
        }

        try{
            response.sendRedirect("/viewOrders");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/viewModels")
    @Transactional
    public void removeModel(HttpServletResponse response, @RequestParam("sku")int sku){
        productRepository.deleteProductBySku(sku);

        try{
            response.sendRedirect("/viewModels");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}