package org.example.Labs.h7_webshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Getter
    @Setter
    private LocalDate orderDate;
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @OneToMany
    private List<Product> items;
    @Getter
    @Setter
    @Transient
    private BigDecimal totalPrice;
    @ManyToOne
    private Customer customer = new Customer();

    public Order() {
        orderDate = LocalDate.now();
        items = new ArrayList<>();
        totalPrice = new BigDecimal(String.valueOf(BigDecimal.ZERO));
    }

    public Order(List<Product> p, Customer customer) {
        orderDate = LocalDate.now();
        items = p;
        totalPrice = calcTotalPrice();
        this.customer = customer;
    }

    public BigDecimal calcTotalPrice() {
        return items.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addProductToOrder(Product p) {
        this.setTotalPrice(this.calcTotalPrice());
        this.items.add(p);
    }

    public void removeProductFromOrder(Product p) {
        this.setTotalPrice(this.calcTotalPrice());
        this.items.remove(p);
    }

}
