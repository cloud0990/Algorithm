package algorithm.java.reviewio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JavaIO_Study {

	public static void main(String[] args) throws IOException {
		
		/*
		  1. 1byte단위로 읽어온다.
		     InputStream  : System.in의  in  = InputStream
		     OutputStream : System.out의 out = OutputStream 
			
		  2. 2byte단위로 읽어온다. (문자)
		     InputStreamReader
		     OutputStreamWriter -> 문자단위로 출력
		   
		  3. 한 줄 단위로 읽어온다 -> readLine()사용 (\n , \r가 올 경우를 한 줄의 끝으로 간주)
		     BufferedReader
		     -> readLine()을 사용해서 결론적으로는, 아무리 많은 문자를 입력하더라도 한 줄 단위로 빠르게 읽어들일 수 있다.
		     Scanner(System.in)과, BufferedReader를 사용했을 때의 속도차이가 있다.
		     
		     Scanner sc = new Scanner(System.in);
		*/
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader    br  = new BufferedReader(isr);
		
		//+) 매개변수(parameter)란, 함수의 정의에서 전달받은 인수를, 함수 내부로 전달하기 위해 사용하는 변수를 의미한다.
		//위의 두 가지 코드를 하나로 사용할 수 있음 : BufferedReader객체 생성시, 매개변수로 바로 생성가능
		BufferedReader    br2 = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		
		위 코드의 해석
		=> System.in(InputStream) 1byte단위로 읽어옴
		   InputStreamReader는 2byte단위(문자) 읽어옴
		   BufferdReader는 문자열(한 줄)단위로 읽어옴	
		   
	    1byte단위로 읽어온 데이터 -> 2byte문자를 읽을 수 있는 inputStreamReader가 -> BufferedReader에게 char단위로 전달하면, BufferedReader가 Line으로 읽어온다(readLine()) 
		
		
		System.in(1Byte단위로 읽어온다) -> InputStreamReader(char단위로 읽어온다:문자스트림) -> BufferedReader(문자열Line단위로 읽어온다)
		
		BufferedReader를 사용하면 문자열로 읽어오기때문에 숫자형으로 입력받고싶으면, Integer.parseInt() 로 꼭 형변환 해줘야한다.
		
		
		*/
		
		System.out.print("id>>");
		
		//IO를 제대로 실행하지 못했거나, 제대로 읽어오지 못했을 경우에 대한 예외처리 해야함 -> IOException
		String id = br2.readLine();
		
		System.out.print("pwd>>");
		String pwd = br2.readLine();
		
		int password = Integer.parseInt(pwd);
		
		
		//console창에 출력
		//OutputStreamWriter클래스의 매개변수로, System.out객체를 지정했기 때문에, 결과를 화면에 출력할 수 있다.
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		
		System.out.println("-------[1.OutputStreamWriter]-------");
		
		out.write(id);
		
		System.out.println();
		
		out.write("pwd>>" + password); 
		
		System.out.println();
		
		
		System.out.println("id>>" + id);
		
		
		//out.write는 출력버퍼에 값을 저장한다. 저장된 값을 flush메소드를 사용하여 화면에 출력할 수 있다.
		//bufferd로 값을 읽어올 떄의 한계점
		//버퍼에 데이터가 축적되는 과정에서 예외상황 발생시, 버퍼가 비워지지못해서 데이터가 그대로 유실되는 경우가 있다
		//이 점을 보완하기위해, 버퍼링을 이용하는 클래스에는 flush() 메소드를 지원한다.
		//버퍼를 비우는 기능을하며, 기본적으로 스트림이 종료되면, 자동으로 작동하긴하지만, 중요한데이터를 저장하는 구문 뒤에는 꼭 flush를 써주는 게 좋다
		out.flush();
		
		System.out.println("-------[2. System.out.print]-------");
		System.out.printf("id>> %s\n", id);
		System.out.printf("pwd>> %d\n", password);
		
		
		
	}
}