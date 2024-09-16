package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class DashboardController {
    @GetMapping("/admin")
    public String getDashboard() {
        return "admin/dashboard/show";
    }

}