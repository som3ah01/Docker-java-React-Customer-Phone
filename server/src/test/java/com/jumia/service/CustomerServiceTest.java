package com.jumia.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jumia.dto.CustomerDTO;
import com.jumia.entity.Customer;
import com.jumia.repo.CustomerRepo;
import com.jumia.service.impl.CustomerServiceImpl;

@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {
	
	private @InjectMocks CustomerServiceImpl customerService;
	private @Mock CustomerRepo customerRepo;
	
	@Test
	void should_ReturnCustomerPage_When_ProvidePageable() {
		
		// Gevin
		Customer expectedCustomer = new Customer(1,"Ismail","(212) 6007989253");
		List<Customer> list = Arrays.asList(expectedCustomer);
		Pageable page = PageRequest.of(0, 1);
		Page<Customer> customersPage = new PageImpl(list, page,list.size());
		Map<String, Object> filters = new HashMap<>();
		
		//When
		Mockito.when(customerRepo.searchByPhonePatern(Mockito.any(), Mockito.any())).thenReturn(customersPage);
		
		// Then
		Page<Customer> customersPageing = customerService.findAllPageing(page, filters);
		
		// And
		Assertions.assertThat(customersPageing.getSize()).isEqualByComparingTo(1);
		Assertions.assertThat(customersPageing.getContent().get(0).getId()).isEqualByComparingTo(expectedCustomer.getId());
		
	}

}
