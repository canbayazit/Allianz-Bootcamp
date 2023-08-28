package com.example.erpapi.database.repository;

import com.example.erpapi.database.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BillEntityRepository extends JpaRepository<BillEntity,Long> {
    Optional<BillEntity> findByUuid(UUID uuid);
}
