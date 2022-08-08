package algorithm.boj.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

/*
브루트포스 알고리즘

최대한 많은 경우의 수를 모두 탐색한다. 
-> 문제의 숫자범위제한이 크지 않아서 이중 for문을 2개 돌려도 시간복잡도가 최악의 경우까지 가지 않을 거라고 판단

첫번 째 반복문은 각 사람들의 몸무게열, 두번 째 반복문은 사람들의 키의 열을 탐색한다.

순위의 기준은 x<p && y<q 로 잡는다.

+) 만약, i와 k가 같다면 같은 사람이기 때문에 비교할 필요가 없다 : continue;


*break vs continue

break : 특정 조건을 만족했을 때, 반복문을 벗어날 때 사용하면 유용

자신이 포함된 가장 가까운 반복문을 강제탈출한다. (뒤의 남은 명령 수행하지 않는다)
if문은 조건문이다. if 내에서 break를 했다면, if를 감싸고 있는 가장 가까운 반복문을 탈출한 것이다.

continue : 전체 반복 중에서 특정 조건을 만족하는 경우를 제외하고싶을 때 사용하면 유용

반복문의 끝으로 이동하여 다음 반복으로 넘어간다. break와 다르게 반복문 전체를 벗어나지않고
다음 반복을 계속 수행할 수 있다.

-> for문의 경우 증감식으로 이동
    while, do-while문의 경우 조건식으로 이동


continue예시

for(int i=0; i<10; i++){
	
	if(i%2==0){ //짝수면
		continue;
	}
	
	System.out.println(i);
	
} -> 조건에 만족했을 때 이동되는 continue의 위치

결과 : 1 3 5 7 9 -> if의 조건에 만족하면 반복문의 끝으로 이동하기 때문에 해당값은 출력되지않는다
*/

public class _7568_덩치 {
	
	//공유자원
	static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder   sb = new StringBuilder();
	
	
	public static String weightRank(int n, int[][] arr) {
		
		for(int i=0; i<n; i++) {
			
			int rank = 1;
			
			for(int k=0; k<n; k++) {
				
				//해당조건을 만족하는 경우를 제외하고싶음
				//break를 사용하게되면 for k반복문을 벗어나기 때문에 원하는 결과를 확인할 수 없음
				if(i==k) continue; 
				
				if( (arr[i][0]<arr[k][0]) && (arr[i][1]<arr[k][1]) ) {
					
					rank++;
				}
			} //continue
			sb.append(rank).append(" ");
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) throws IOException{
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		
		int[][] arr = new int[n][2];
		
		
		for(int i=0; i<arr.length; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int k=0; k<arr[i].length; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(weightRank(n, arr));
		bw.flush();
		bw.close();
		br.close();
	}
}