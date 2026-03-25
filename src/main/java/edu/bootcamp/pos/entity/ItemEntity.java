package edu.bootcamp.pos.entity;

import edu.bootcamp.pos.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class ItemEntity {

    @Id
    @Column(name = "Item_Id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Item_name", length = 100, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type", length = 100, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_Qty", length = 100, nullable = false)
    private double balanceQty;

    @Column(name = "Supplier_price", length = 100, nullable = false)
    private double supplierPrice;

    @Column(name = "Selling_price", length = 100, nullable = false)
    private double sellingPrice;

    @Column(name = "active_status", columnDefinition = "TINYINT default 0")
    private boolean active;
}
