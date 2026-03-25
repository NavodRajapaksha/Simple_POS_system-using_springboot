package edu.bootcamp.pos.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", length = 45)
    private Integer id;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String name;

    @Column(name = "customer_address", length = 200)
    private String address;

    @Column(name = "contact_number", columnDefinition = "json", length = 225)
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> contactNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_status", columnDefinition = "TINYINT default 0")
    private boolean active;
}
