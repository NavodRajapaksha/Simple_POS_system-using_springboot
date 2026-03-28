package edu.bootcamp.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class  OrderEntity {

    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private CustomerEntity customerEntity;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total", nullable = false)
    private Double total;

    @JsonIgnore
    @OneToMany(mappedBy = "orderEntity")
    private Set<OrderDetailsEntity> orderDetailsEntities;

    public OrderEntity(CustomerEntity customerEntity, Date date, Double total) {
        this.customerEntity = customerEntity;
        this.date = date;
        this.total = total;
    }
}
