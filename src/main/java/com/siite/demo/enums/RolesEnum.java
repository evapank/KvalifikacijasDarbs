package com.siite.demo.enums;

public enum RolesEnum {
	
	USER("USER"), ADMIN("ADMIN");
	
	private final String value;

	RolesEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
