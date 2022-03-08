package com.jumia.api;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jumia.dto.CustomerDTO;
import com.jumia.entity.Customer;
import com.jumia.mapper.CustomerMapper;
import com.jumia.service.CustomerService;

@WebMvcTest(controllers= {CustomerAPI.class})
public class CustomerAPITestIT {
	
	private static final String URL="/v1/customer/find-all-page";
	
	private @Autowired MockMvc mockMvc;
	
	private @MockBean CustomerService customerService;
	private @MockBean CustomerMapper customerMapper;
	
	@Test
	void testSuccsessGetAllCustomerIfPageProvided() throws Exception {
		
		// Given
		Customer customer = new Customer(1, "Ismail", "(212) 6007989253");
		
		Map<String, Object> filtters = new HashMap<String, Object>();
		List<Customer> list = Arrays.asList(customer);
		Pageable page =  PageRequest.of(0, list.size());
		Page<Customer> customersPage = new PageImpl(list, page, list.size());
		CustomerDTO customerDto = new CustomerDTO(1, "Ismail", "(212) 6007989253", "Moroco");
		
		// When
		Mockito.when(customerService.findAllPageing(Mockito.any(), Mockito.any())).thenReturn(customersPage);
		Mockito.when(customerMapper.convertToDTO(Mockito.any())).thenReturn(customerDto);
		
		// Then
		mockMvc.perform(MockMvcRequestBuilders.post(URL)
				.param("page", "0")
				.param("size", "10")
				.param("sort", "id,desc"))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.content[*].id", CoreMatchers.hasItem(1)))
				;
		
	}

}
