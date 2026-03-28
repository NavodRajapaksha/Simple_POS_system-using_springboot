package edu.bootcamp.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_details")
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsEntity {

    @Id
    @Column(name = "order_detail_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Column(name = "QTY", length = 100, nullable = false)
    private  double Qty;

    @Column(name = "amount",nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "Item_Id", nullable = false)
    private ItemEntity itemEntity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity orderEntity;
}
