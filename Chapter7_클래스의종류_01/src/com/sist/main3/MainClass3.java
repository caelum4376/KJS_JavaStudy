package com.sist.main3;
class AA {
	public AA() {
		System.out.println("A() Call...");
	}
}

class BB extends AA {
	public BB() {
		System.out.println("B() Call...");
	}
}
public class MainClass3 {
	public static void main(String[] args) {
		BB b = new BB();
		AA a = new AA();
		
		// 강제형변환을 할 때에는 생성자랑 형변환이 같아야한다
		// AA aa = (BB)new AA();
		
		AA aa = new BB(); // 인터페이스나 추상클래스에서 주로 나오는 형식
		BB bb = (BB)aa;
	}
}
