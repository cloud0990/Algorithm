package algorithm.java.reviewbase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _StringTokenizer {

	public static void main(String[] args) throws IOException{
		
		//문자를 한 줄 단위로 입력받을 수 있음 -> readLine() 사용시
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		//BufferedReader의 readLine()을 바로 생성자에 초기화하면서 객체 생성했기 때문에 이미 여기서부터 입력받는 거임
		//만약에 여러 줄 입력받을 때는 밑에서 한 번 더 초기화 해줘야함
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//이렇게 선언하면 한 줄 단위로 읽어오기 때문에 스페이스까지 문자로 인식해서 값 제대로 안 들어감
		//엔터로 값 입력할 거면 상관없는데 "4 2" 이렇게 입력할 거면 오류뜸 for input String "4 2"
		//int n = Integer.parseInt(br.readLine());
		//스페이스(공백)으로 입력 받을 거면 Integer.parseInt(st.nextToken()); 으로 해야함 -> 위에서 토큰 객체생성하면서 바로 br.readLine
		//했으니까 여기서 입력받은 값을 공백단위로 잘라서 int n 안에 넣을 수 있음
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//이렇게 해야 공백을 기준으로 한 줄로 입력받았을 때 각각 하나씩 떼서 변수 안에 넣을 수 있음
		//한 줄에 공백단위로 입력한 거니까 토그나이저 객체 하나 생성해놓고 그냥 두 개 잘라서 넣은 거임
		
		int [] arr = new int[5];
		
		//위에서 st.nextToken하고, 밑에서 또 입력받아야할 때, st = new ... 이거 객체 생성 또 해줘야함
		//위에서 이미 한 줄 입력받아서 공백단위로 잘라서 토근을 다 변수 안에 넣어서 여기서 초기화 안 해주면 토큰 없다고 오류남
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//반복문 한 번 돌 때마다 한 줄에 공백단위로 입력한 숫자들을 하나씩 떼서 인덱스에 값 추가하는 거임
		//입력을 for문 안에서 st.nextToken이 받는 게 아니라 반복문 위에 br.readLine초기화하면서 객체생성한 저기서 입력받고
		//그 입력받은 값을 공백단위로 잘라서 변수 안에 넣는 거임
		//너무 Integer.parseInt로 변환해서 쓰는 것만 해서 String형에 값 넣을 때 헷갈리는데,
		//BufferedReader는 문자열로 인식되서 String에 넣을 때는 Integer형변환 안 해줘도 됨
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		//-> String으로 입력받아서 토크나이저 객체 쓰는 경우
		//위에서 또 토큰 다 썼으니까 여기서 또 초기화
		System.out.print("문자열 입력 : 과일 3개>>");
		st = new StringTokenizer(br.readLine());
		
		String [] str_arr = new String[3];
		
		for(int i=0; i<str_arr.length; i++) {
			str_arr[i] = st.nextToken();
		}
		
		for(String str : str_arr) {
			System.out.print(str + " ");
		}
		
		//입력받은 문자열을 배열 안에 넣을 때는 위의 방법으로 하면 되고, 그냥 입력만 받을 때는 토크나이저
		//필요없이 바로 br.readLine(); 하면 될듯
		//토크나이저 객체 생ㅇ성할 때, 그냥 br.readLine()하면 자동으로 공백 기준으로 잘라줌
		//특정문자 기준으로 자르고 싶으면 br.readLine(), "-" 하면 됨
		st = new StringTokenizer(br.readLine(), "-");
		String [] strArr = new String[3];
		
		for(int i=0; i<strArr.length; i++) {
			strArr[i] = st.nextToken();
		}
		
		for(String str : strArr) {
			System.out.print(str + " ");
		}
		
		//결론 : 토크나이저 객체 생성 br.readLine으로 한다고 해놓고
		//Integer.parseInt(br.readLine)하면 또 오류뜸
		//위에서 한 줄 단위로 입력받겠다고 같이 선언한 거니까 
		//각각의 변수 안에 넣으려면 전달인자로 st.nextToken써줘야 원하는대로 넣을 수 있음
		//저기에 한 번에 적어놨지만 원래는 따로 선언하는 거임
		//BufferedReader랑 StringTokenizer 같이 쓸 때
		//그냥 코드 외웠다고 막 쓰지말고 어디서 br.readLine()으로 입력받고
		//어디서 토크나이저 쓰는지 계속 생각하면서 쓰자
		
		
		
		//구분자 뒤에 true false
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ", true);
		//기본값(생략시) false
		//true면 구분자도 토큰에 포함시키고, false면 구분자는 토큰에 포함시키지 않는다.
		
		/*
		StringTokenizer
		문자열을 구분자 기준으로 잘라서 토큰에 저장한다. 결과값이 문자열이다.
		
		split
		문자열을 정규표현식으로 구분하며, 구분자까지 인식한다.
		결과값이 배열이다.
		
		*/
	}
}