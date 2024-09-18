package vn.hoidanit.laptopshop.controller.client;

import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.hoidanit.laptopshop.domain.User;
// import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class HomePageController {
//    private final UserService userService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    public HomePageController(UserService userService) {
//        this.userService = userService;
//        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
//    }
    @GetMapping("/")
    public String getHomePage(Model model) {
        return "client/homepage/show";
    }

//    @GetMapping("/register")
//    public String getRegisterPage(Model model) {
//        model.addAttribute("registerUser", new RegisterDTO());
//        return "client/auth/register";
//    }
//    @PostMapping("/register")
//    public String handleRegister(
//            @ModelAttribute("registerUser") @Valid RegisterDTO registerDTO,
//            BindingResult bindingResult) {
//
//        // validate
//        if (bindingResult.hasErrors()) {
//            return "client/auth/register";
//        }
//
//        User user = this.userService.registerDTOtoUser(registerDTO);
//
//        String hashPassword = this.bCryptPasswordEncoder.encode(user.getPassword());
//
//        user.setPassword(hashPassword);
//        user.setRole(this.userService.getRoleByName("USER"));
//        // save
//        this.userService.handleSaveUser(user);
//        return "redirect:/login";
//    }
//
//    @GetMapping("/login")
//    public String getLoginPage(Model model) {
//        return "client/auth/login";
//    }
//
//    @GetMapping("/access-deny")
//    public String getAccessDeniedPage(Model model) {
//        return "client/auth/access-denied";
//    }
}
