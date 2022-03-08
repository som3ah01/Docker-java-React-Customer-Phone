package com.jumia.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jumia.entity.Customer;

public interface CustomerService {

	Page<Customer> findAllPageing(Pageable page, Map<String, Object> filters);

}