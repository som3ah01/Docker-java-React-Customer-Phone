package com.jumia.utils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import com.jumia.pojo.CountryPatternPojo;

public class CountryUtils {

	public static Map<String, CountryPatternPojo> countriesValidationPatern = new LinkedHashMap<String, CountryPatternPojo>();

	static {

		countriesValidationPatern.put("Moroco",
				new CountryPatternPojo("\\(212\\).?[5-9]\\d{8}$", Pattern.compile("^\\(212\\)*")));
		countriesValidationPatern.put("Cameroon",
				new CountryPatternPojo("\\(237\\).?[2368]\\d{7,8}$", Pattern.compile("^\\(237\\)*")));
		countriesValidationPatern.put("Uganda",
				new CountryPatternPojo("\\(256\\).?\\d{9}$", Pattern.compile("^\\(256\\)*")));
		countriesValidationPatern.put("Mozambique",
				new CountryPatternPojo("\\(258\\).?[28]\\d{7,8}$", Pattern.compile("^\\(258\\)*")));
		countriesValidationPatern.put("Ethiopia",
				new CountryPatternPojo("\\(251\\).?[1-59]\\d{8}$", Pattern.compile("^\\(251\\)*")));

	}

	public static String convertNumberToCountry(String number) {
		for (Map.Entry<String, CountryPatternPojo> entry : countriesValidationPatern.entrySet()) {
			String countryName = entry.getKey();
			Pattern pattern = entry.getValue().getCountryPattern();
			if (pattern.matcher(number).find()) {
				return countryName;
			}
		}
		return "Other";
	}

	public static String getCountryPattern(List<String> countrylist, boolean valid) {
		StringBuilder phonesBulder = new StringBuilder();
		for (int i = 0; i < countrylist.size(); i++) {
			if (valid) {
				phonesBulder.append(countriesValidationPatern.get(countrylist.get(i)).getCountryValidation());
				if (i < countrylist.size() - 1) {
					phonesBulder.append("|");
				}
			} else {
				phonesBulder.append(countriesValidationPatern.get(countrylist.get(i)).getCountryPattern());
				if (i < countrylist.size() - 1) {
					phonesBulder.append("|");
				}
			}
		}
		return phonesBulder.toString();
	}
	
	public static List<String> getAllCountryNames() {
		return countriesValidationPatern.keySet().stream().map(key -> key).toList();
	}
	

}
