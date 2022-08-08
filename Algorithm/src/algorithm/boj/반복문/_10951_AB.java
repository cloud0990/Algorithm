package algorithm.boj.반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

EOF : End Of File

입력에서 더 이상 읽을 수 있는 데이터가 없는 경우
-> 더 이상 입력이 주어지지않은 경우

BufferedReader는 읽을 입력값이 없는 경우 null을 반환한다.
테스트케이스를 입력받지만 얼만큼 받을 지 모른다 -> 반복의 횟수를 알 수 없다 -> while사용

Scanner사용 시, 다음 읽어올 데이터가 있는 경우 -> hasNext
ex) sc.hasNext 
입력받은 데이터가 있으면 true, 없으면 false반환

Scanner사용시,


while(sc.hasNextInt()){
	int A = sc.nextInt();
	int B = sc.nextInt();
	
	sb.append(A+B).append("\n");
}


+) 주의할 점
StringTokenizer는 문자열을 '입력'받는 게 아니라 입력받은 문자열을 '가공'하는 역할이다.
EOF처리를 하기위해 StringTokenizer를 사용할 수는 없다.
-> BufferedReader's readLine() 사용

*/

public class _10951_AB {

	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder   sb = new StringBuilder();
		
		String str;
		
		//입력받은 str이 null이 아닌 경우
		//BufferedReader는 입력값이 없을 경우(EOF) -> null 반환
		while( (str=br.readLine())!=null ) {
			
			//공백을 기준으로 한자리의 수가 주어지기때문에 charAt으로 추출할 위치가 정해져있다.
			//우리가 사용할 숫자로 변환하려면 -48 or -'0'을 하면 정수형으로 변환된다.
			int A = str.charAt(0) - 48;
			int B = str.charAt(2) - '0';
			
			sb.append(A+B).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}