package com.example.erpapi.database.repository;

import com.example.erpapi.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity,Long> {
    Optional<CustomerEntity> findByUuid(UUID uuid);
}
