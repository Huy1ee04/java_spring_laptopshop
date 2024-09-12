package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.service.UserService;

import java.util.List;


//code theo mô hình MVC
@Controller
public class UserController {
//dependence injection
    private final UserService userService;
    private final UserRepository userRepository;
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
       // List<User> arrUsers = this.userService.getAllUsersByEmail(huy@gmail.com);
      //  System.out.println(arrUsers);
        String test = this.userService.handleHello();
        model.addAttribute("hung", test);
        return "hello";    // ở đây ko cần thêm .jsp ở hậu tố do đã có file config cho rồi
    }

    //Video 53: Nhận dữ liệu từ phía user (view) và hiển thị trang tạo mới người dùng
    @RequestMapping("/admin/user/create") //Mặc định nếu ko khai báo method thì máy sẽ hiểu là dùng method GET
//                                             // cho nên nó k bị xung đột với đoạn code dùng method POST ở dưới
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";   // admin/user thêm vào là do đây là đường dẫn đến file create.jsp
    }


    //phương thức xử lý yêu cầu tạo mới người dùng và lưu dữ liệu (phân biệt với phương thức bên trên)
    //Phương thức này chính là nút submit, còn phương thức ngay bên tren giúp hiển thị trang tạo mới người dùng
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    //@RequestMapping: Đây là annotation được sử dụng để định nghĩa các URL mà phương thức controller này sẽ xử lý.
    // Ở đây, phương thức này sẽ xử lý các yêu cầu HTTP có URL là /admin/user/create
    // và sử dụng phương thức HTTP POST.
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) {
    //Khi một yêu cầu POST tới URL /admin/user/create, dữ liệu của người dùng sẽ được ánh xạ vào đối tượng User
    // (thông qua @ModelAttribute).
        System.out.println("run here " + user);
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user"; //sau khi lưu thành công,phương thức này
                                       //sẽ điều hướng người dùng tới trang mới (/admin/user)
    }

    // Hiển thị tất cả các người dùng
    @RequestMapping("admin/user")
    public String getUserList(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

    @RequestMapping("admin/user/{id}")
    public String getUserDetail(Model model, @PathVariable Long id) {
        User user = this.userService.getUserByID(id);
        model.addAttribute("id", id);
        model.addAttribute("name", user.getFullName());
        model.addAttribute("email", user.getEmail());
        return "admin/user/detail-user";
    }

    //Mở ra trang giao diện update
    @RequestMapping("admin/user/update/{id}")
    public String updateUserDetail(Model model, @PathVariable Long id) {  // Cách 1 để lấy thong tin: dùng @pathvariable
        User user = this.userService.getUserByID(id);
        model.addAttribute("newUser", user);
        return "admin/user/update-user";
    }

    // đây là nút submit cho phần update
    @PostMapping("admin/user/update")
    // đây là annotation khác , tương đương với việc dùng annotation: @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String updateUser(Model model, @ModelAttribute("newUser") User user) {
        User currentUser = this.userService.getUserByID(user.getId());
        if(currentUser != null) {
            currentUser.setFullName(user.getFullName());
            currentUser.setPhone(user.getPhone());
            currentUser.setAddress(user.getAddress());
            this.userService.handleSaveUser(currentUser); //Tham số ở đây phải là currentuser chứ không phải là user
        }
        return "redirect:/admin/user";
    }

    //Giao diện cho delete
    @GetMapping("admin/user/delete/{id}")
    public String deleteUserPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("id", id);
        User user = this.userService.getUserByID(id);
        model.addAttribute("User", user);
        return "admin/user/delete";
    }
    //Nút submit cho delete
    @PostMapping("admin/user/delete")
    public String deleteUser(Model model, @ModelAttribute("User") User user) {
        this.userService.deleteUserByID(user.getId());
        return "redirect:/admin/user";
    }




}


//Code theo mô hinh restful
//@RestController
//public class UserController {

//Dependence ijection
//    private UserService userService;
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//    @GetMapping("/")
//    public String getHomePage() {
//        return this.userService.handleHello();
//    }
//}


