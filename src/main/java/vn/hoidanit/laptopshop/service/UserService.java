package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.repository.RoleRepository;
import vn.hoidanit.laptopshop.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    //test
    public String handleHello() {
        return "Hello from service !";
    }

    // Phương thức xử lý lưu thông tin
    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }
    //Phương thức lay thong tin tat cả các người dùng
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    //lấy thông tin qua id
    public User getUserByID(Long id) { return this.userRepository.findById(id).orElse(null); }
    //xoá người dùng thông qua id
    public void deleteUserByID(Long id) { this.userRepository.deleteById(id); }
    //Lấy role cho tài khoản
    public Role getRoleByName(String name) { return this.roleRepository.findByName(name); }
    //Mapper: nhận tham số là 1 object DTO, qua phương thức này sẽ biến object DTO trở lại thành object bình thường.
    //đoạn code mapper này chạy bằng cơm (:v) , sau này ta sẽ sử dụng các hàm chuyên dụng được cung cấp sẵn
    public User registerDTOtoUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        return user;
    }
    //Check email này đã tồn tại trước đây hay chưa
    public boolean checkEmailExist(String email) {
        return this.userRepository.existsByEmail(email);
    }
    //Lấy 1 người dùng bằng Email
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
//    public List<User> getAllUsersByEmail(String email) {
//        return this.userRepository.findOneByEmail(email);
//    }

}
