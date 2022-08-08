package algorithm.boj.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
1. 고려사항
만들 수 있는 삼각형 세 변의 최대합을 구한다.
최대합을 구하기위해서 배열을 처음부터 보는 게 아니라 내림차순 정렬해서 최대합부터 확인하면 빠른 시간 안에 찾을 수 있다.

여기서는 병합정렬 대신 Arrays클래스를 이용해서 reverseOrder()를 사용했다.
제출했을 때 정답이긴했지만 병합정렬로 채점한 답안과의 시간차이가 꽤 났다.

2. 문제점
최대값부터 찾는 건 좋았지만, 자꾸 문제 예제에 맞게 코드를 짜서 반례에서 항상 막힌다.
항상 했던 실수인 것 같은데 변수를 특정 값에 맞추면 반례에서 막히는 것 같다.
이번 문제같은 경우에는 내림차순 정렬을 했으니 max를 arr[0]값에 고정시켰는데
삼각형을 만들 수 없는 조건에 대응할 수 없어서 틀렸다.

다음 문제풀 때는 어느 변수 하나도 특정값을 주지말고, 모든 경우에 적용가능할 수 있도록 고민해서 선언해야겠다.
*/

public class _1448_삼각형_그리디알고리즘 {

	public static int triangle(Integer[] arr, int n) {
		
		int max = 0;
		
		for(int i=0; i<n-2; i++) {
			
			if(arr[i]<arr[i+1]+arr[i+2]) {
				max = Math.max(max, (arr[i]+arr[i+1]+arr[i+2]) );
			}
			
			//여기서 else if로 해버리면 위의 조건이 만족하지 않았을 때 다음 최대값을 찾는 게 아니라 바로 max==0명령을
			//수행하기 때문에 이런 상황에서는 단일 if문을 사용해서 마지막에 체크해주는 게 좋다.
			if(max==0) { 
				max = -1;
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder    sb  = new StringBuilder(); 
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[n];
		
		for(int i=0; i<n; i++) {
			st     = new StringTokenizer(br.readLine());
			arr[i] = Integer.valueOf(st.nextToken());
		}//예제입력완료

		Arrays.sort(arr, Collections.reverseOrder()); //내림차순 정렬
		
		sb.append(triangle(arr, n));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}