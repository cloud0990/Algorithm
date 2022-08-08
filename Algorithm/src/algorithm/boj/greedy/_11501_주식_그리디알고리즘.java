package algorithm.boj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제해석 : 순이익을 최대로 얻을 수 있는 값 구하기
할 수 있는 행동
1. 현재 가격의 주식을 1개 살 수 있다
2. 산 주식을 원하는만큼, 현재 가격에 팔 수 있다
3. 아무것도 안 한다
            
1. 고려사항
최대값 구하기(반복문 돌면서 max값 갱신) : 정렬 안 하고 max값 계속 찾을 수 있는 방법
최소값일 때 사고 최대값일 때 판다
주가가 떨어지는 상황이라면 현재 인덱스값보다 작아지면 판다.

순이익 구하는 식 : max-nArr[i] -> nArr[i]번째에서 해당 인덱스값을 샀을 거니까, 그 값 빼줘야 순 이익 나옴

일단 count 생각 하지말고 순이익 구하는 방법만 해보기
반복문 앞에서부터 돌면 주가 떨어지는 것까지 계산해야하는데 뒤에서부터 max값 갱신시키면 주가 떨어져도 그냥 순이익 구하는 식만 쓰면됨

+) 반복문을 역순으로 돌리는 방법을 생각하는 게 제일 중요했던 것 같다
순차적으로 계산하면 주가가 떨어지는 것 까지 계산해야하는데 뒤에서부터 max값 갱신시키면서 max보다 작은 현재 인덱스값을 빼면 바로 순이익이 나왔다


2. 문제점
StringTokenizer를 제대로 이해못하고 있어서 쓸 때마다 NoSuchElement Error 발생
-> BufferedReader와 StringTokenizer 다시 보기

반복문에서 사용할 변수의 선언위치를 잘 고민하고 선언해야겠다
StringBuilder로 결과출력할 때도 반복문 안에서 결과출력 해버려서 자꾸 값이 이상하게 나왔다

조금만 생각을 바꾸면 금방 풀 수 있는 문제들을, 너무 문제 그대로 이해하고 구현하려고 하니까 시간도 많이 걸리고 결국 처음 구현한 로직 사용 못함
다음 문제 풀 때는 최대한 쉽게 풀 수 있는 방법이 뭐가있을지 고민하면서 접근해야겠다

Error
NumberFormatException
-> int형보다 범위가 큰 자료형을 Integer.parseInt()하려고 할 때 발생한다.
long과 int의 자료형을 안 맞춰서 발생한 것 같다.
*/

public class _11501_주식_그리디알고리즘 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder     sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine()); 
		
		
		for(int k=0; k<testCase; k++) {
			
			//testCase 돌 때마다 초기화
			long profit = 0;
			long max    = 0;
			
			int n = Integer.parseInt(br.readLine());
			long [] nArr = new long[n];
			
			
			st = new StringTokenizer(br.readLine());
	
			for(int i=0; i<n; i++) {
				nArr[i] = Integer.parseInt(st.nextToken());
			}//for i end
			
			for(int j=n-1; j>=0; j--) {
				
				if(max<nArr[j]) {
					max = nArr[j];
				}else { //max값이 아닐 때의 경우
					
					profit = profit + (max - nArr[j]); //max-nArr[i] (최대값에서 이득 봤을 거니까 순이익 구하려면 샀던 주식 빼야함)
				
				}//if end
			}//for j end
			sb.append(profit + "\n");
		}//for end
		
		System.out.println(sb);
	}
}