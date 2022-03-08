package com.jumia.repo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jumia.entity.Customer;

@DataJpaTest
public class CustomerRepoTestIT {
	
	private @Autowired CustomerRepo customerRepo;
	/*
	 * We use H2 DB for Inegration test
	 * we inserted one Customer in import.sql file 
	 */
	
	private static final String PATTERN ="^\\(212\\)*";
	private static final Integer CUSTOMER_ID= 1;
	
	@Test
	void should_ReturnCustomerPage_When_ProvidePagable() {
		// Given
		Pageable page = PageRequest.of(0, 1);
		// When
		Page<Customer> customerPage = customerRepo.searchByPhonePatern(PATTERN, page);
		//Then
		Assertions.assertThat(customerPage.getSize()).isEqualTo(1);
		Assertions.assertThat(customerPage.getContent().get(0).getId()).isEqualTo(CUSTOMER_ID);
		
	}

}
