package com.jumia.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {
	
	private static final long serialVersionUID = -7857204080399096989L;
	
	private  Integer id;
	private String name;
	private String phone;
	private String country;

}
