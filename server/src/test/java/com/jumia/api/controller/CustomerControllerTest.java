package com.jumia.api.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jumia.controller.CustomerController;
import com.jumia.dto.CustomerDTO;
import com.jumia.entity.Customer;
import com.jumia.mapper.CustomerMapper;
import com.jumia.service.CustomerService;

@ExtendWith(SpringExtension.class)
public class CustomerControllerTest {
	
	private @InjectMocks CustomerController customerController;
	private @Mock CustomerService customerService;
	private @Mock CustomerMapper customerMapper;
	
	@Test
	void should_returnCustomerDTO_when_ProvidePage() {
		
		// Given
		CustomerDTO expectedCustomerDTO = new CustomerDTO(1,"Ismail","(212) 6007989253","Egypt");
		Customer customer = new Customer(1,"Ismail","(212) 6007989253");
		List<Customer> list = Arrays.asList(customer);
		Pageable page = PageRequest.of(0, 1);
		Page<Customer> customersPage = new PageImpl(list, page,list.size());
		Map<String, Object> filters = new HashMap<>();
		// When
		Mockito.when(customerService.findAllPageing(Mockito.any(), Mockito.any())).thenReturn(customersPage);
		Mockito.when(customerMapper.convertToDTO(Mockito.any())).thenReturn(expectedCustomerDTO);
		// Then
		ResponseEntity<Page<CustomerDTO>> customerspaging = customerController.findAllPhonespaging(page, filters);
		Assertions.assertThat(customerspaging.getStatusCode()).isEqualTo(HttpStatus.OK);
		// And
		CustomerDTO resultDTO = customerspaging.getBody().getContent().get(0);
		Assertions.assertThat(expectedCustomerDTO.getId()).isEqualTo(resultDTO.getId());
	}

}
