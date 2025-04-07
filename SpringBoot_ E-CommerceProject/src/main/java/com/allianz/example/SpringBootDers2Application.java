package com.allianz.example;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.model.enums.ColorEnum;
import com.allianz.example.service.CategoryService;
import com.allianz.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootDers2Application {

    @Autowired
    ProductService productService;


    @Autowired
    CategoryService categoryService;


    @Autowired
    ProductEntityRepository repository;


    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    public static void main(String[] args) {

        SpringApplication.run(SpringBootDers2Application.class, args);

    }


}
