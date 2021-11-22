package com.kkb.task010203;

public class Mylist {

	Object[] element;
	private int capacity;
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Mylist() {
		size = 0;
		capacity = 4;
		element = new Object[capacity];
	}

	public void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void add(Object a) {
		if (size == capacity) {
			Object[] newa = new Object[capacity * 2];
			for (int i = 0; i < element.length; i++) {
				newa[i] = element[i];
			}
			element = newa;
		}
		element[size] = a;
		size++;
	}

	public Object get(int index) {
		return element[index];
	}
	//delect element according to index
	public Object remove(int index) {
		Object ele=0;
		ele = element[index];
		for(int i=index;i<size;i++) {
			element[i]=element[i+1];
		}
		size--;
		return ele;
	}
	//delect element according to value
	public Object remove(Object a) {
		for(int i=0;i<size;i++) {
			if(element[i]!=null&&element[i]==a) {
				
				return remove(i);
			}
		}
		return null;
	}

}
