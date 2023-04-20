package com.sist.main3;
class Parent{
	public String name;
	public Parent() {}
	public Parent(String name){
		this.name = name;
	}
}

class Child extends Parent{
	public int studentNo;

	public Child(String name, int studentNo){
		this.name = name;
		this.studentNo = studentNo;
	}
}
public class MainClass2 {

	public static void main(String[] args) {
		Child c = new Child("",1);
		
	}

}
