package day9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyTest3 {
	public static void main(String[] args) {
		
		FileReader fi = null;
		FileWriter fo = null;
		try {
			//라인번호 왼쪽 라인 시작 추가
			fi = new FileReader("src/day9/FileCopyTest3.java");
			fo = new FileWriter("linecopy.txt");
			Scanner sc = new Scanner(fi);
			int linenum = 1;
			String line="";
			
			while(sc.hasNextLine()) { //읽을 라인이 있는가?
				line = sc.nextLine(); //한줄읽기
				fo.write(linenum++ +" : "+ line + "\n");
//				System.out.print(linenum++ +" : "+ line + "\n");
			}																						
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
				fo.close();
			}catch (IOException e) {}
		}		
	}
}
