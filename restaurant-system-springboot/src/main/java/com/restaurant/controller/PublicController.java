
package com.restaurant.controller;

import com.restaurant.model.Order;
import com.restaurant.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublicController {
    private final OrderService orderService;
    public PublicController(OrderService orderService){ this.orderService = orderService; }

    @GetMapping({"/", "/index"})
    public String index(){ return "index"; }

    @GetMapping("/menu")
    public String menu(){ return "menu"; }

    @GetMapping("/order")
    public String orderForm(){ return "order"; }

    @PostMapping("/order")
    public String placeOrder(@RequestParam String itemName, @RequestParam int quantity, @RequestParam String customerName, Model model){
        Order o = new Order(itemName, quantity, customerName);
        orderService.save(o);
        model.addAttribute("order", o);
        return "order_status";
    }
}
