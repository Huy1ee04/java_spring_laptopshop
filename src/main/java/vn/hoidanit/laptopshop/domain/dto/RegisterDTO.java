package vn.hoidanit.laptopshop.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import vn.hoidanit.laptopshop.service.validator.RegisterChecked;

//Class DTO này tạo ra để lấy những dữ liệu cần dùng.
//VD: khi ta đăng nhập, thông tin user cần thiết đó là tên, mật khẩu, email
//Việc sử dụng class user là thừa , và đôi khi nó cũng thiếu (VD: nó ko có trường firstname và lastname)
//Cho nên ta sẽ tạo ra class UserDTO để lấy những thông tin đủ dùng tuỳ mục đích từ class user
//Quá trình biến đổi từ class bình thường sang class DTO gọi là mapper
@RegisterChecked
public class RegisterDTO {

    @Size(min = 3, message = "firstName phải có tối thiểu 3 ký tự")
    private String firstName;
    private String lastName;
    @Email(message = "Email không hợp lệ", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    private String password;
    @Size(min = 3, message = "confirmPassword phải có tối thiểu 3 ký tự")
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}