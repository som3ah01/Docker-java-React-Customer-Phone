package com.jumia.api;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jumia.dto.CustomerDTO;

@RequestMapping("/v1/customer")
@CrossOrigin(origins = {"*"})
public interface CustomerAPI {

	@GetMapping("/test")
	ResponseEntity<String> test();

	@PostMapping("/find-all-page")
	ResponseEntity<Page<CustomerDTO>> findAllPhonespaging(Pageable page, Map<String, Object> filters);

}