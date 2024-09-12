package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoidanit.laptopshop.domain.User;

import java.util.List;

// Lý giải vì sao code ở phần repository không cần khởi tạo đối tượng
//là bởi @Repository cũng là 1 bean, spring sẽ tự động tạo đối tượng và lưu để
//sử dụng ở các nơi khác theo cơ chế DI (tiêm phụ thuộc)
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);
    void deleteById(Long id);
    List<User> findByEmail(String email);
    List<User> findAll();
    User findById(long id);
}
