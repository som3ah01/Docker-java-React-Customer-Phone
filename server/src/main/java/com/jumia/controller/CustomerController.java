package com.jumia.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.api.CustomerAPI;
import com.jumia.dto.CustomerDTO;
import com.jumia.mapper.CustomerMapper;
import com.jumia.service.CustomerService;

@RestController
public class CustomerController implements CustomerAPI {

	private @Autowired CustomerService customerServiceImpl;
	private @Autowired CustomerMapper customerMapper;

	@Override
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Working...Fine", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Page<CustomerDTO>> findAllPhonespaging(Pageable page,
			@RequestBody(required = false) Map<String, Object> filters) {
		return new ResponseEntity<>(customerServiceImpl.findAllPageing(page, filters).map(customerMapper::convertToDTO),
				HttpStatus.OK);
	}

}
