package day9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest2 {
	public static void main(String[] args) {
		// 명령행 매개변수 입력
		// a.txt b.txt -> a.txt 파일 존재x
		// src/FileCopyTest.java b.txt -> b.txt파일이 존재X -> b.txt 자동생성
		// src/FileClassTest.java b.txt -> b.txt 출력파일 존재o -> 기존내용삭제 - 출력
		FileReader fi = null;
		FileWriter fo = null;
		try {
			fi = new FileReader(args[0]);
			fo = new FileWriter(args[1], true); // 두번째 매개변수에 true -> 이전내용 삭제X 이전내용 + 새로운내용
			File f = new File(args[0]);
//			if(f.exists()) {
//				FileInputStream fi new FileInputStream(f);
//			}
			while(true) {
				int result = fi.read(); // 1바이트씩 읽기
				fo.write(result);
				if(result == -1) break;				
			}			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fi.close();
				fo.close();
			}catch (IOException e) { }
		}		
	}
}
