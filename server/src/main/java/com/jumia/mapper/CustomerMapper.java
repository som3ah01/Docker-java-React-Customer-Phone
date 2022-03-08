package com.jumia.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jumia.dto.CustomerDTO;
import com.jumia.entity.Customer;

@Mapper(componentModel = "spring", uses = CustomerProccessor.class)
public interface CustomerMapper extends Serializable {
	
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	CustomerDTO convertToDTO (Customer customer);
	
	Customer convertFromDTO (CustomerDTO customerDTO);

}
