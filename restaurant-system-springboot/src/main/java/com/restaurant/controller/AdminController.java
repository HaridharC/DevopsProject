
package com.restaurant.controller;

import com.restaurant.model.Order;
import com.restaurant.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final OrderService orderService;
    public AdminController(OrderService orderService){ this.orderService = orderService; }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("orders", orderService.pending());
        return "admin_dashboard";
    }

    // Mark a single order as delivered
    @PostMapping("/orders/{id}/complete")
    @ResponseBody
    public ResponseEntity<?> completeOrder(@PathVariable Long id){
        return orderService.find(id).map(o -> {
            o.setDelivered(true);
            orderService.save(o);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
