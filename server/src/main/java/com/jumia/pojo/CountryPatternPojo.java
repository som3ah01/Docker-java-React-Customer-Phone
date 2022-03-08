package com.jumia.pojo;

import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryPatternPojo {

	private String CountryValidation;
	private Pattern CountryPattern;

}
