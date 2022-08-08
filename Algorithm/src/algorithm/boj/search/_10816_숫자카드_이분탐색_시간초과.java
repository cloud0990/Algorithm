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
1. 중복값까지 count해야하니까 target과 일치하더라도 계속 탐색하는 조건 찾기
2. 시간초과

*/

public class _10816_숫자카드_이분탐색_시간초과 {

	
	public static int binarySearch(int [] arr, int target) {
		
		int start = 0;
		int end   = arr.length-1;
		int mid   = 0;
		int count = 0;
		
		while(start<=end) {
			
			mid = (start+end)/2;
			
			if(arr[mid]==target) {
				
				//for문 때문에 시간초과 뜨는 듯
				for(int i=0; i<arr.length; i++) {
					if(arr[i]==arr[mid]) count++;
				}
				
				break;
			
			}else if(arr[mid]<target) {
				start = mid+1;
			}else if(arr[mid]>target) {
				end = mid-1;
			}
		}//while end
		return count;
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int [] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		//-------------[예제입력완료]--------------
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<t; i++) { //for문 안에서 binary메소드 호출해야 target을 t만큼 보냄
			int target = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(arr, target)).append(" ");
		}
		
		out.write(sb.toString());
		out.flush();
		
		br.close();
		out.close();
	}
}