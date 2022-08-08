package algorithm.java.reviewio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class 입출력스트림 {

	public static void main(String[] args) {
		
		//05강 : InputStreamReader, OutputStreamWriter
		//06강 : Scanner클래스
		
		
		/*

		Stream : 데이터를 입출력하기위한 방법 (장치와 무관하게 동일한 방법으로 입출력)
	  			 FIFO(선입선출)구조 : 순차적 접근만 허용한다 -> 데이터의 순서가 바뀌지않는다    +) 단방향
	  	
	  	
	  	바이트스트림(1byte) : 한글(2byte) 못 읽어온다.
	  	1. InputStream -> System.in에서 in
	  	2. OuputStream -> System.out에서 out 
		
		문자스트림(2byte) 
		1. InputStreamReader
		2. OutputStreamWriter
		*/
		
		
		FileReader     fr = null; //시스템에 있는 문자파일을 읽을 수 있는 기능 제공
		BufferedReader br = null;
		
		
		try {
			
			fr = new FileReader("C:\\Work\\text.txt"); //읽어올 파일경로  
			br = new BufferedReader(fr); //파일을 한 줄 단위로 읽어오겠다
			
			//br = new BufferedReader(new FileReader("읽어올 파일 경로"))

			String msg;
			
			//readLine(); == 파일의 끝에 도달할 때까지, 한 줄단위로 버퍼에 저장
			
			try {
				while( (msg = br.readLine()) != null) { //한 줄 단위로 읽어온 msg가 존재한다면
					System.out.println(msg);            //화면에 출력해라
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) { //해당경로에 파일이 존재하지않을경우 예외처리
			e.printStackTrace();
			
		}finally { //예외와 상관없이 무조건 실행 -> 주로 열려있는 파일 닫을 때 사용 
			
			try {
				if(fr != null) fr.close(); //FileReader가     열려있으면 닫아라
				if(br != null) br.close(); //BufferedReader가 열려있으면 닫아라
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}