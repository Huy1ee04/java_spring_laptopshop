package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class OrderController {
    @GetMapping("/admin/order")
    public String getDashboard() {
        return "admin/order/show";
    }

}