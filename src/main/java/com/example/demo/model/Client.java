package com.example.demo.model;

public class Client {

	private int id;
	private String clientName;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", Name=" + clientName + ", age=" + age + "]";
	}

	public Client(int id, String clientName, int age) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.age = age;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
