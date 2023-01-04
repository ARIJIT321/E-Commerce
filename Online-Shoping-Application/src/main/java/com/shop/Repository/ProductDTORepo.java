package com.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Model.ProductDTO;

@Repository
public interface ProductDTORepo extends JpaRepository<ProductDTO, Integer>{

}
