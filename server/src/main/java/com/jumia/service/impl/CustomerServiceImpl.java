package com.jumia.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jumia.entity.Customer;
import com.jumia.repo.CustomerRepo;
import com.jumia.service.CustomerService;
import com.jumia.utils.CountryUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	private @Autowired CustomerRepo customerRepo;

	@Override
	public Page<Customer> findAllPageing(Pageable page, Map<String, Object> filters) {
		if (filters == null) {
			return customerRepo.findAll(page);
		} else {
			boolean valid = false;
			List<String> countrylist = null;

			if (filters.containsKey("phoneValid")) {
				valid = filters.get("phoneValid").equals("valid");
			}
			if (filters.containsKey("country")) {
				countrylist = (List<String>) filters.get("country");

			} else {
				countrylist = CountryUtils.getAllCountryNames();
			}
			String phonePatterns = CountryUtils.getCountryPattern(countrylist, valid);
			return customerRepo.searchByPhonePatern(phonePatterns, page);
		}

	}

}
