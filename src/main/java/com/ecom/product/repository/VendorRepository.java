package com.ecom.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ecom.product.model.Vendor;




@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long>{

}
