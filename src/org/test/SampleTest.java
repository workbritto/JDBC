package org.test;

import java.util.ArrayList;

public class SampleTest {
	
	public static void main(String[] args) {
		Test t = new Test();
		ArrayList<Employee> emp = t.getEmployeeInfo();
		for (Employee x : emp) {
			System.out.println(x.getEmpid());
			System.out.println(x.getName());
			System.out.println(x.getPassword());
			System.out.println(x.getEmail());
		}
	}
}
