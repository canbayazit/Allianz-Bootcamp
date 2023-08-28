package com.example.erpapi.service;

import com.example.erpapi.database.entity.BillEntity;
import com.example.erpapi.database.repository.BillEntityRepository;
import com.example.erpapi.mapper.BillMapper;
import com.example.erpapi.model.requestDTO.BillRequestDTO;
import com.example.erpapi.model.responseDTO.BillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class BillService {
    @Autowired
    BillEntityRepository billRepository;
    @Autowired
    BillMapper billMapper;

    public List<BillDTO> getAllBills() {
        List<BillEntity> billEntities = billRepository.findAll();
        return billMapper.entityListToDTOList(billEntities);
    }

    public BillDTO getBillByUUID(UUID uuid) {
        BillEntity billEntity = billRepository.findByUuid(uuid).orElse(null);
        if (billEntity != null) {
            return billMapper.entityToDTO(billEntity);
        }
        return null;
    }

    public BillDTO createBill(BillRequestDTO billRequestDTO) {
        BigDecimal totalAmount = calculateTotalAmount(billRequestDTO);

        BillEntity billEntity = billMapper.requestDTOToEntity(billRequestDTO);
        billEntity = billRepository.save(billEntity);
        return billMapper.entityToDTO(billEntity);
    }

    public BillDTO updateBill(UUID uuid, BillRequestDTO billRequestDTO) {
        BillEntity billEntity = billRepository.findByUuid(uuid).orElse(null);
        if (billEntity != null) {
             BigDecimal totalAmount = calculateTotalAmount(billRequestDTO);

            billEntity.setTotalAmount(billRequestDTO.getTotalAmount());

            billEntity = billRepository.save(billEntity);
            return billMapper.entityToDTO(billEntity);
        }
        return null;
    }

    public void deleteBill(UUID uuid) {
        BillEntity billEntity = billRepository.findByUuid(uuid).orElse(null);
        if (billEntity != null) {
            billRepository.delete(billEntity);
        }
    }

    private BigDecimal calculateTotalAmount(BillRequestDTO billRequestDTO) {
        BigDecimal totalAmount = billRequestDTO.getTotalAmount();
        BigDecimal kdv = totalAmount.multiply(BigDecimal.valueOf(0.18)); // %18 KDV
        return totalAmount.add(kdv);
    }
}
