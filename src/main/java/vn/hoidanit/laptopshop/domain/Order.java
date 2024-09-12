package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double totalPrice;

    //Quan hệ 1-N:Bên N sẽ phải thêm 1 cột là khoá chính bên 1
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // user id

    //Bên 1 chỉ cần ánh xạ sang bên N
    // order detail
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", totalPrice=" + totalPrice + "]";
    }

}
