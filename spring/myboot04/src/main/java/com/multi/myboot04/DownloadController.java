package com.multi.myboot04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {

		@RequestMapping("/filedownload")
		public ModelAndView downloadform(){
			//c:upload 폴더 저장 파일 리스트 모델로 생성 뷰로 전달
			ModelAndView mv = new ModelAndView();
			File path = new File("c:/upload");
			String [] filelist = path.list(); //c:/upload 안에 있는 파일명 배열로 리턴
			mv.addObject("details",filelist); //view에서는 표현식 = ${details}
			mv.setViewName("upload/downloadform");
			return mv;
		}
		
		@RequestMapping("/downloadresult")
		public void downloadreuslt(String file, HttpServletResponse response)
		throws IOException{//file 다운로드 해야될 파일 명
			//file 다운로드
			File f = new File("c:/upload", file); //c:/upload/파일명
			
			//파일 다운로드를 응답하겠다고 선언. 파일명, 길이포함
			response.setContentType("application/download");
			response.setContentLength((int)f.length());
			response.setHeader("Content-Disposition", "attachment;filename=\"" + file +"\"");
			
			//파일명에 해당하는 파일을 읽어서 클라이언트에게 복사 출력
			OutputStream out = response.getOutputStream(); //클라이언트에게 출력하려고 
			FileInputStream fin = new FileInputStream(f); //파일을 읽어서
			FileCopyUtils.copy(fin,out); //복사
			fin.close();
			out.close();
		}
}
