package com.sist.util;
import java.util.*;
public class 라이브러리_Random_02 {

	public static void main(String[] args) {
		char[] alpha = new char[10];
		Random r = new Random();
		
		for (int i=0; i<alpha.length; i++) {
			alpha[i] = (char)(r.nextInt(5)+65);
		}
		
		System.out.println("================ 정렬전 =================");
		System.out.println(Arrays.toString(alpha));
		
		System.out.println("================ 정렬후 =================");
		Arrays.sort(alpha);
		System.out.println(Arrays.toString(alpha));
		
		System.out.println("================ 정렬후(DESC) =================");
		for (int i=alpha.length-1; i>=0; i--) {
			System.out.print(alpha[i]+" ");
		}
		
	}

}
