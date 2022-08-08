package algorithm.boj.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

자연수 N (1 ≤ N ≤ 1,000,000)

- Edge Case : int형 (연산해도 20억 안 넘을 듯)

분해합 : N + N을 이루는 각 자릿수의 합

어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라고 한다.
ex)
245의 분해합 = 256(245+2+4+5)
256의 생성자는 245이다.

문제 : M이 주어졌을 때, N의 가장 작은 생성자를 구하시오
단, 생성자가 없을 경우 0을 출력한다.

1. 가장 작은 생성자는 어떻게 구함
2. 생성자가 없는 경우는 어떻게 앎
  -> 각 자릿수의 합을 구할 수 없는 1의 자리숫자일 때?

-----------------------------------

3자리수(N)을 입력받았다고 가정한다.
N + (N%1000/100) + (N%100/10) + (N%10)

하지만 이 식은 내가 N의 자릿수를 알고있다는 전제 하에 사용할 수 있다.
N을 정수형으로 받지않고 문자열로 입력받는다면?
근데 연산을 해야하니까 String 보다는 char를 사용해서 -48해서 정수로 연산하면?
StringBuilder에 추가한 각 자릿수를 toCharArray()를 통해 char[] 로 조회한다.

주어진 M의 생성자 구하기
M = M + (M의 각 자릿수의 차)
---------------------------------------------
toCharArray()를 사용한다면 필요없을 듯		
		
for(int i=0; i<M.length(); i++) {
	//자릿수 구하기
	N = M.substring(0, i);
	sb.append(N);
}//for end
//누적합 변수 생성
int sum = 0;

//입력받은 M의 각 자릿수를 char[]로 조회 후, 자릿수 누적
for(char m : M.toCharArray()) {
	sum -= m-'0';
}

int sum = mChar[0]-48; //누적합 변수 선언

System.out.println(sum);

*/

public class _2231_분해합 {

	public static void main(String[] args) throws IOException {
		
		//입출력객체 생성
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		//예제 입력
		int M = Integer.parseInt(st.nextToken());
		
		//생성자를 구할 수 없는 경우 출력 후, 바로 종료
		if(M<10) {
			sb.append(0);
			bw.write(sb.toString());
			bw.flush();
			return;
		}
		
		int answer = solution(M);
		
		System.out.println(answer);
		
		
	}
	
	public static int solution(int M) {
		
		//String mStr = Integer.toString(M);
		String mStr = String.valueOf(M);
		
		//M의 char[] 선언
		char[] mChar = mStr.toCharArray();
		
		int sum = 0;
		
		//char[] 초기화
		for(int i=0; i<mChar.length; i++) {
			
			sum -= (mChar[i]-48);
		}
		
		//M의 생성자 선언
		int N = Integer.valueOf(M) + sum + (mChar[0]-48);
		
		
		//가장 작은 생성자 구하기
		
		
		
		
		
		
		
		
		
		
		
		
		return N;
	}
}