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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    private HashMap<Integer, Product> cart = new HashMap<>();
    @Autowired
    private ProductRepository productRepository;
    private int count = 1;
    public static boolean isLoggedInt = false;

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("keys", cart.keySet());
        model.addAttribute("products", cart.entrySet());
        model.addAttribute("hashmap", cart);
        return "cart.html";
    }

    public String payment() {
        return "payment.html";
    }


    @PostMapping("/products")
    public void addToCart(@RequestParam("product") int sku, HttpServletResponse response) throws IOException {
        // Retrieve the corresponding product object from your database or wherever your products are stored
        if (isLoggedInt) {
            Product product = productRepository.findBySku(sku);
            cart.put(count, product);
            count++;
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please log in before adding items to cart');");
            out.println("window.location.href = '/login';");
            out.println("</script>");
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

    @GetMapping("/cartCount")
    @ResponseBody
    public Map<String, Integer> getCount() {
        Map<String, Integer> response = new HashMap<>();
        response.put("count", cart.size());
        return response;
    }

    @GetMapping("/totalPrice")
    @ResponseBody
    public Map<String, Integer> getTotalPrice() {
        List<Integer> keys = new ArrayList<>(cart.keySet());    //Getting the keys of the current cart items
        int totalPrice = 0;
        for(int i=0; i<cart.size(); i++){   //For loop to go through all items
            int key = keys.get(i);  //Setting the key for each item
            Product product = cart.get(key);    //Getting the current product being checked
            int currentPrice = (int)product.getPrice();     //Setting the currentprice to be the price of that item
            totalPrice = totalPrice + currentPrice;     //Finding the price of all items
        }
        Map<String, Integer> response = new HashMap<>();
        response.put("totalPrice", totalPrice);
        return response;
    }


//    @PostMapping("/payment")
//    public void processPayment(HttpServletResponse response, @RequestParam("name") String name,
//                                 @RequestParam("email") String email,
//                                 @RequestParam("address") String address) {
//        // Process the payment information here
////        return "payment.html";
//        try{
//            response.sendRedirect("/payment");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}




