package com.sist.lib;
import java.util.*;

class A {
	public void execute() {
		System.out.println("A : execute() Call...");
	}
}

class B {
	public void execute() {
		System.out.println("B : execute() Call...");
	}
}

class C {
	public void execute() {
		System.out.println("C : execute() Call...");
	}
}

// Spring => 클래스 관리자
class Container {
	Map map = new HashMap();
	
	// 싱글턴 => 메모리 누수현상을 방지 (한 개의 객체로 재사용을 하는 프로그램)
	// Map => 클래스를 관리시에 주로 사용한다
	public Container() {
		map.put("a", new A());
		map.put("b", new B());
		map.put("c", new C());
	}
	public Object getBean(String key) {
		return map.get(key);
	}
}
public class 라이브러리_Map_02 {

	public static void main(String[] args) {
		Container c = new Container();
		A aa = (A)c.getBean("a");
		aa.execute();
		
		A bb = (A)c.getBean("a");
		bb.execute();
		
		System.out.println(aa);
		System.out.println(bb);
	}

}
