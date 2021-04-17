package day9;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileClassTest {

	public static void main(String[] args) {
		File f = new File(args[0]);
		if(f.exists()) { // 파일이 존재하는경우
			try {
				System.out.println("기준경로= "+f.getCanonicalPath());
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(f.isFile()) { //파일명인지				
				System.out.println(" 읽기여부=" + f.canRead());
				System.out.println(" 쓰기여부=" + f.canWrite());
				System.out.println(" 총길이(byte)=" + f.length());
				System.out.println("최종수정시각=" + f.lastModified());
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도 MM월 dd일 HH:mm:ss");
				String dateString = sdf.format(new java.util.Date(f.lastModified()));
				System.out.println(dateString);
			}
			else { //디렉토리인지
				String[] details = f.list();
				for(String one : details) {
					System.out.println(one);
					// 이름 ": file / dir 표시"
					File ff = new File(args[0]+"/"+one);
					String result = "";					
					if(ff.isFile()) {
						result = " : file";
					}else {
						result = " : dir";
					}
					System.out.println(one + " : " + ff.exists()+result);
					
				}
			}
		}
		else { // 파일이 존재하지 않는경우
			System.out.println(args[0] + " 이름의 파일이나 디렉토리는 존재하지 않습니다");
		}
		
	}
}
