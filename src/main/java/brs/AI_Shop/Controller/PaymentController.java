package brs.AI_Shop.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller

public class PaymentController {
    @GetMapping("/payment")
    public String payment() {
        return "payment.html";
    }

    @PostMapping("/payment")
    public void paymentComplete(HttpServletResponse response){
        try{
            response.sendRedirect("/payment");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
