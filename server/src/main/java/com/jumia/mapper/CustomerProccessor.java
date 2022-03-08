package com.jumia.mapper;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.jumia.dto.CustomerDTO;
import com.jumia.entity.Customer;
import com.jumia.utils.CountryUtils;

@Mapper(componentModel = "spring")
public abstract class CustomerProccessor {
	
	@AfterMapping
	public void convertToDTO(Customer customer, @MappingTarget CustomerDTO dto) {
		dto.setCountry(CountryUtils.convertNumberToCountry(dto.getPhone()));
	}
	

}
