package com.java.accessModifier;

public class Class_01 {
	
	//Fields / Variable
	
	//private field
	private String name = "Automation FC";
	String address = "58 Le Lai"; 
	protected String city = "Ha Noi";
	public String phone = "0987761128";
	//Method / Function
	
	//private method
	private String getName() {
		return name;
	}
	
	private void setName (String name) {
		this.name = name;
	}
	
	String getAddress() {
		return address;
	}
	
	void setAddress(String address) {
		this.address = address;
	}
	
	protected String getCity() {
		return city;
	}

	protected void setCity(String city) {
		this.city = city;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public static void main (String[] args) {
		Class_01 class1 = new Class_01();
		System.out.println(class1.getName());
		class1.setName("Automation testing");
		System.out.println(class1.getName());
	}
	public class InnerClass01{
		public void printName() {
			System.out.println(getName());
		}
	}
}
