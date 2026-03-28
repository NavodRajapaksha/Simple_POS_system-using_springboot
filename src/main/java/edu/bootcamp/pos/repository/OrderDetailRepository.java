package edu.bootcamp.pos.repository;

import edu.bootcamp.pos.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderDetailRepository extends JpaRepository<OrderDetailsEntity,Integer> {
}
