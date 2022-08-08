package algorithm.boj.reviewplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _0430_회의실배정 {

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
	
		int [][] timeTable = new int [n][2];
		
		//timeTable 입력받기
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine()); //여러 줄 입력 -> stk 초기화
			
			timeTable[i][0] = Integer.parseInt(st.nextToken());
			timeTable[i][1] = Integer.parseInt(st.nextToken());
		}

		
		//timeTable 0번째 행 정렬
		Arrays.sort(timeTable, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[0]-o2[0];
			}
		}); //sort end
	
		
		
		//timeTable 1번째 행 정렬
		Arrays.sort(timeTable, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1]; //o1 < o2
			}
		}); //sort end
		
		
		int count   = 0; //결과값
		
		//0행의 배열은 종료시간과 비교를 못하니까 일단 0으로 돌리려고 0으로 선언
		//=>for문 첫 번째바퀴는 버리고 두 번째 바퀴부터 실질적 비교
		int end = 0;
		
		for(int i=0; i<n; i++) {
			if(timeTable[i][0]>=end) { //처음엔 0이니까 무조건 조건성립해서 endTime에 0행 1열의 값이 들어감
				end = timeTable[i][1]; //첫번째 회의시간은 무조건 할 수 있음
				count++;
			}//if end
		}//for end
		
		System.out.println(count);
	}
}