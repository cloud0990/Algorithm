package algorithm.boj.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

고려사항
아까 풀었던 이분탐색 문제와 비슷하지만, 같은 숫자가 나온다면 같은 위치에 append해야한다.
+) 원래 이진탐색은 중복되지않은 값들을 가지고 진행한다.

1. 중복값까지 count해야하니까 target과 일치하더라도 계속 탐색하는 조건 찾기
2. 시간초과

end값으로 n-1을 줬기때문에, start가 배열 끝까지 돌게 하려고 처음에 while반복 조건으로 start<=end를 줬다
근데 end값으로 n을 줘버리고, start<end하면 start는 결국 배열의 끝까지 돌 수 있으면서 end보다 작을 때까지 반복하는 거니까
명령수행 완료 후 반복문을 탈출할 수 있다.

while 반복조건으로 start<end 변경 후, end값을 그대로 n-1로 하니까, 배열의 마지막 인덱스를 체크하지못했다.


*/

public class _10816_숫자카드_이분탐색 {

	
	//왼쪽 이분탐색
	public static int leftBound(int target) {
		
		int start = 0;
		int end   = n; //ex) n=10
		
		while(start<end) { //start가 end보다 작을 때만 반복
			
			int mid = (start+end)/2;
			
			if(arr[mid]==target) {
				end = mid; //end범위 mid로 줄이기
			}else if(arr[mid]>target) {
				end = mid;
			}else if(arr[mid]<target) {
				start = mid+1;
			}
		}//while end
		return start;
	}
	
	//오른쪽 이분탐색
	public static int rightBound(int target) {
		
		int start = 0;
		int end   = n; //인덱스계산 때문에 -1 했었는데 -1하면 안 됨
		
		while(start<end) {
			
			int mid = (start+end)/2;
			
			if(arr[mid]<=target) { //= arr[mid]==target / arr[mid]<target
				start = mid+1;
			}else if(arr[mid]>target) {
				end = mid;
			}
		}//while end
		return end;
	}
	
	
	public static int count(int target) {
	
		int start = leftBound(target);
		int end   = rightBound(target);
		
		return end-start;
	}
	
	
	//static 변수 선언 -> 클래스 내 어디서든 선언 없이 바로 사용 가능 -> 1회만 생성
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder  sb  = new StringBuilder();
	static int n;
	static int t;
	static int [] arr;
	
	
	
	public static void main(String[] args) throws IOException{
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n   = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		//StringTokenizer 초기화
		st = new StringTokenizer(br.readLine());
		//arr 입력받기
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//오름차순 정렬
		Arrays.sort(arr);
		
		//StringTokenizer 초기화
		st = new StringTokenizer(br.readLine());

		//보유 중인 카드 갯수 입력받기
		t  = Integer.parseInt(st.nextToken());
		
		//StringTokenizer 초기화
		st = new StringTokenizer(br.readLine());
		
		//보유 중인 카드 갯수만큼, target입력받아서 반복1회마다 count()에 인자값으로 넣어서 전달
		while( t-- > 0 ) { 
			int target = Integer.parseInt(st.nextToken());
			sb.append(count(target)).append(" ");
		}
		
		out.write(sb.toString());
		out.flush();
		br.close();
		out.close();
	}
}