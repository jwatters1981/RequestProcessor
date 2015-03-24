package org.boynesoftware.requestprocessor;

public class Bean {

	private String name;

	private int age;

	public Bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bean(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Bean [name=" + name + ", age=" + age + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
