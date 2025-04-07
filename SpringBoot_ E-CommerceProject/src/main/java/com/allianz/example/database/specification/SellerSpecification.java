package com.allianz.example.database.specification;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.util.BaseSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;

@Component
public class SellerSpecification extends BaseSpecification<SellerEntity> {

}
