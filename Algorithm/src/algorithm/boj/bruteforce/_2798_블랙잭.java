package algorithm.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*

1. 문제
입력받은 숫자 N의 3개씩의 합이, M보다 작거나 같을 때 중에서 max값 구하기

2. 고려사항
나올 수 있는 모든 경우의 수 탐색
out of length가 나오지 않도록, 반복문의 인덱스범위 조절

3. 초기로직
for문을 3번 돌려서 0 1 2부터 탐색할 수 있도록 범위설정
3개의 합이 M을 넘지않는 조건을 만족하면, 3수의 합 중 max값 갱신하는 조건 -> max 출력
인덱스 계산하기 편하도록 수의 크기보다 +1만큼의 여유공간 생성


*/

public class _2798_블랙잭 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //n개의 수
		int m = Integer.parseInt(st.nextToken()); //세 수의 합에 대한 범위
		
		int [] nArr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		//수 입력받기
		for(int i=0; i<nArr.length; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		
		//반복문 범위 조절하기
		//세 수의 합이 나올 수 있는 경우의 수 모두 확인하기 위해서 for문 3개
		for(int i=0; i<nArr.length-2; i++) {
			
			for(int k=i+1; k<nArr.length-1; k++) {
				
				for(int j=k+1; j<nArr.length; j++) {
					
					int sum = 0;
					
					sum = nArr[i]+nArr[k]+nArr[j];
					
					if(sum<=m){
						if(max<sum) {
							max = sum;
						}
					}
				}//for j end
			}//for k end
		}//for i end
		
		System.out.println(max);
		
	}
}