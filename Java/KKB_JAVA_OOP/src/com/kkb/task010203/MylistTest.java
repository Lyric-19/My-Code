package com.kkb.task010203;

public class MylistTest {

	public static void main(String[] args) {
		Mylist l1=new Mylist();
		for(int i=0;i<6;i++) {
			l1.add(i);
		}
		for (int i=0;i<l1.getSize();i++) {
			System.out.print(l1.get(i)+" ");
		}
		Object obj = l1.remove(2);
		System.out.println("delect:"+obj);
		String test="test";
		l1.add(test);
		for (int i=0;i<l1.getSize();i++) {
			System.out.print(l1.get(i)+" ");
		}
		Object j=l1.remove(test);
		System.out.println("delect:"+j);
		for (int i=0;i<l1.getSize();i++) {
			System.out.print(l1.get(i)+" ");
		}

	}

}
