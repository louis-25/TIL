package io;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		System.out.println("정수 1 입력");		
		int first = key.nextInt();
		System.out.println("정수 2 입력");		
		int second = key.nextInt();		
		System.out.println(first + second);
		key.nextLine(); //이전의 엔터값 정리용도
		
		System.out.println("한글 문자열 입력");
		String word = key.nextLine();
		System.out.println(word);
	}

}
