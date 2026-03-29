package edu.bootcamp.pos.repository;

import edu.bootcamp.pos.dto.query.OrderDetails;
import edu.bootcamp.pos.dto.respones.ResponseOrderDetailsDto;
import edu.bootcamp.pos.entity.OrderEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Query(
            value = "select c.customer_name as CustomerName , c.customer_address as customerAddress , c.contact_number as contactNumber, o.order_date as date , o.total as total from customer c, order o where o.active_state =?1 and c.customer_id = o.customer_id",
            nativeQuery = true)
    List<OrderDetails> getAllOrderDetails(boolean status, PageRequest of);

    @Query(
            value = "select count(*) from customer c, orders o where o.avtive_state= ?1 and c.customer_id = o.customer_id",
            nativeQuery = true
    )
    long countAllOrderDetails(boolean status);
}
