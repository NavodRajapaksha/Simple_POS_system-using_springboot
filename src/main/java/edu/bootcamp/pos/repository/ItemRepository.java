package edu.bootcamp.pos.repository;

import edu.bootcamp.pos.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<ItemEntity,Integer> {

    List<ItemEntity> findAllByNameEqualsAndActive(String Name, boolean active);
}
