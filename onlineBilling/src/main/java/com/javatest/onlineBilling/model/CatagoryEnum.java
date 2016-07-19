package com.javatest.onlineBilling.model;

public enum CatagoryEnum {
	CATAGERY_A(1L,"Categary A"),
	CATAGERY_B(2L,"Categary B"),
	CATAGERY_C(3L,"Categary C");
	
	private String name;
	private Long id;
	
	CatagoryEnum(Long id, String name){
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}
}
