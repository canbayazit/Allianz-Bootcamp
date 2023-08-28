package com.example.erpapi.database.repository;

import com.example.erpapi.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductEntityRepository extends JpaRepository<ProductEntity,Long> {

    Optional<ProductEntity> findByUuid(UUID uuid);
}