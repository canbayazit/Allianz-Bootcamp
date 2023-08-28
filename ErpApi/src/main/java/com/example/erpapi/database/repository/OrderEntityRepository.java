package com.example.erpapi.database.repository;

import com.example.erpapi.database.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity,Long> {
    Optional<OrderEntity> findByUuid(UUID uuid);
}
