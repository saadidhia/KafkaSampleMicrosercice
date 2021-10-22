package com.kafka.KafkaSampleMicroservice;

public class MyModel {
	
	private String field1;
	private String filed2;
	
	
	public MyModel() {
	}
	public MyModel(String field1, String filed2) {
		super();
		this.field1 = field1;
		this.filed2 = filed2;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getFiled2() {
		return filed2;
	}
	public void setFiled2(String filed2) {
		this.filed2 = filed2;
	}
	
	

}
