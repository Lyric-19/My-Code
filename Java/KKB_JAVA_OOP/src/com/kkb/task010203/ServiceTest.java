package com.kkb.task010203;

import java.util.Scanner;

public class ServiceTest {

	public static void main(String[] args) {
		UserService u1 = new UserService();
		Scanner input = new Scanner(System.in);
		System.out.println("Please input your username:");
		String name = input.next();
		System.out.println("Please input your pin:");
		int pin = input.nextInt();
		boolean result = u1.login(name, pin);
		if(result) {
			System.out.println("Login!");
		}else {
		System.out.println("Fail!");
		}
	}

}
