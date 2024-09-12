package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    //lấy thông tin qua email
    public List<User> getAllUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
    //lấy thông tin qua id
    public User getUserByID(Long id) { return this.userRepository.findById(id).orElse(null); }
    //xoá người dùng thông qua id
    public void deleteUserByID(Long id) { this.userRepository.deleteById(id); }



}