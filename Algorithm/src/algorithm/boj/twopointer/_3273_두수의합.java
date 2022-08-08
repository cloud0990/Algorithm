package algorithm.boj.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

1. 문제
N개를 입력받아 N개로 이루어진 수열을 생성한다.
X를 입력받아 두 수의 합이 X가 되는 경우를 카운트하여 출력한다.


2. 고려사항
시작지점과 종료지점의 위치지정 => start = 0; end = n-1; (양 끝에서 안 쪽으로 모이는 형식)
정렬여부 선택             => 오름차순 정렬

투포인터 3개의 식이 나오는 이유
sum > x / sum < x의 식을 세우는 이유가 포인터를 이동하면서 x에 근접한 값을 찾기위함이다
이 문제의 경우 1 2 3 5 7 9 10 11 12에서 5 7 9부분의 포인터 이동을 고려해보면
5 + 9 = 14 > x 보다 크니까 end--로 근접값을 찾는다
5 + 7 = 12 < x 이미 14의 값에서 end를 --한 게 13보다 크니까 근접값을 찾기위해 한 칸 앞으로 이동한 건데
앞으로 이동한 것의 합이 x보다 작으니까 7 + 9는 안 봐도 된다

결국, 투 포인터 식은 x의 근접값을 찾기위해 포인터를 조정해나간다는 것이다.

중요한 점은, 반복문의 조건설정 시, start와 end가 역전될 경우를 고려해야한다.
start != end 라는 식은 역전의 가능성을 고려하지 않은 식이다.
-> start < end start가 end보다 커지면 역전되는 거니까 역전가능성을 없앨 수 있다


3. 문제점
start와 end의 역전가능성을 고려하지않았기 때문에, out of length 오류 발생
투포인터의 개념을 제대로 이해하지 못한 상태에서 조건식을 사용했다. -> x의 근접값을 찾기위해 3개의 경우의 포인터 조정을 하는 것이다.
StringTokenizer를 초기화하는 경우 -> 여러 개의 수를 반복하면서 입력받아야할 경우
이 경우 아니고서는, Integer.parseInt(br.readLine()); 을 사용하면된다.
st 초기화 이유가 배열안에 입력받은 수를 공백단위로 잘라서 넣기 위함이니까

-> 포인터 반복문의 조건식으로, 등호는 되도록 사용하지말자


+) StringBuilder를 사용해서 결과를 출력해봤다
   답을 출력하는 로직을 메소드로 분리했다

*/


public class _3273_두수의합 {

	//static으로 한 이유
	//main()가 제일 처음 시작되는데, 그 전에 미리 생성되있어야 main()에서 호출가능
	public static int twoPointer(int n, int x, int [] nArr) {
		
		int start = 0;   //시작지점
		int end   = n-1; //종료지점(0base)
		int count = 0;   //결과카운트
		
		Arrays.sort(nArr); //오름차순 정렬
		
		
		//start와 end가 역전되는 경우 고려
		while(start<end) {
			
			int sum = nArr[start] + nArr[end];
			
			if(sum == x) {
				
				count++;
				end--;
				start++;
			
			}else if(sum < x) {
				
				start++;
			
			}else {
				
				end--;
			
			}
		}//while end
		
		return count;
	}//twoPointer() end
	
		
		
	public static void main(String[] args) throws IOException {
		 
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		int    n    = Integer.parseInt(st.nextToken()); //수열의 크기
		int [] nArr = new int[n];
		
		//여러 개의 수 입력받기 때문에 StringTokenizer초기화
		st = new StringTokenizer(br.readLine()); //여기서 입력받은 수를, for문 안에서 공백을 기준으로 하나씩 넣음
		
		//수열
		for(int i=0; i<nArr.length; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		//결과출력
		sb.append(twoPointer(n, x, nArr));
		System.out.println(sb);
		
	}
}