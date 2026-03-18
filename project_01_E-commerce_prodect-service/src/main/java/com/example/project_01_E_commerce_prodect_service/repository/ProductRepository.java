package com.example.project_01_E_commerce_prodect_service.repository;

import com.example.project_01_E_commerce_prodect_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
