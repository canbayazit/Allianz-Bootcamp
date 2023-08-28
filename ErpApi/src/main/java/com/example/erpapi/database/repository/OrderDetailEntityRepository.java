package com.example.erpapi.database.repository;

import com.example.erpapi.database.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderDetailEntityRepository extends JpaRepository<OrderDetailEntity,Long> {
    List<OrderDetailEntity> findAllByOrderId(int orderId);

    @Transactional
    void deleteAllByOrderId(int orderId);
}
