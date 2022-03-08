package com.jumia.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jumia.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	public Page<Customer> findAllByPhoneStartsWith(String phone , Pageable page);
	
	@Query(
			value = "select c.id ,c.name , c.phone from customer c where c.phone ~ :phonePatterns ", 
			  countQuery = "SELECT count(c.*) FROM  customer c where c.phone ~ :phonePatterns", 
			  nativeQuery = true)
	public Page<Customer> searchByPhonePatern(String phonePatterns , Pageable page);

}
