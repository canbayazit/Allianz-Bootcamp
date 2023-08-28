package com.example.erpapi.service;

import com.example.erpapi.database.entity.ProductEntity;
import com.example.erpapi.database.repository.ProductEntityRepository;
import com.example.erpapi.mapper.ProductMapper;
import com.example.erpapi.model.requestDTO.ProductRequestDTO;
import com.example.erpapi.model.responseDTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductEntityRepository productRepository;
    @Autowired
    ProductMapper productMapper;
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productMapper.entityListToDTOList(productEntities);
    }

    public ProductDTO getProductByUUID(UUID uuid) {
        ProductEntity productEntity = productRepository.findByUuid(uuid).orElse(null);
        if (productEntity != null) {
            return productMapper.entityToDTO(productEntity);
        }
        return null;
    }


    public ProductDTO createProduct(ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = productMapper.requestDTOToEntity(productRequestDTO);
        productEntity = productRepository.save(productEntity);
        return productMapper.entityToDTO(productEntity);
    }

    @Transactional
    public ProductDTO updateProduct(UUID uuid, ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = productRepository.findByUuid(uuid).orElse(null);
        if (productEntity != null) {
            // Ürün stok kontrolü yapılabilir
            if (isStockAvailable(productEntity, productRequestDTO.getQuantity())) {
                productEntity.setName(productRequestDTO.getName());
                productEntity.setPrice(productRequestDTO.getPrice());
                productEntity.setQuantity(productRequestDTO.getQuantity());
                // Diğer güncelleme işlemleri

                productEntity = productRepository.save(productEntity);
                return productMapper.entityToDTO(productEntity);
            } else {
                throw new RuntimeException("Ürün stokta yetersiz.");
            }
        }
        return null;
    }
    @Transactional
    public void deleteProduct(UUID uuid) {
        ProductEntity productEntity = productRepository.findByUuid(uuid).orElse(null);
        if (productEntity != null) {
            productRepository.delete(productEntity);
        }
    }

    private boolean isStockAvailable(ProductEntity productEntity, int quantityToOrder) {
        return productEntity.getQuantity() >= quantityToOrder;
    }
}
