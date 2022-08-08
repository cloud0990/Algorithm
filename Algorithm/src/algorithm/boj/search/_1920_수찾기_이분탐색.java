package algorithm.boj.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
이분탐색
배열을 정렬한 상태에서 사용할 수 있다. -> 사용하기위해서는 반드시 정렬해야한다.
투포인터와 비슷하게 시작지점과 종료지점을 target에 근접하게 이동시킨다.
추가된 점은 처음부터 끝까지 이동시키는 게 아니라 mid값을 지정해서 mid값 기준으로 target을 찾은 후 조건에 맞게
mid+1만큼 증가시키고 mid-1만큼 감소시킨다.
*/

public class _1920_수찾기_이분탐색 {

	public static boolean binarySearch(int [] nArr, int target) {
		
		int start = 0;
		int end   = nArr.length-1;
		int mid   = 0;
		
		while(start<=end) {
			
			mid = (start+end)/2;
			
			if(nArr[mid]==target) {
				return true;
			}else if(nArr[mid]<target) {
				start = mid+1;
			}else if(nArr[mid]>target) {
				end = mid-1;
			}
		}//while end
		
		return false;
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int [] nArr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(nArr);
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		while(0<t--) {
			
			int target = Integer.parseInt(st.nextToken());
			
			if(binarySearch(nArr, target)) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			
			sb.append("\n");
			
		}//while end
		
		System.out.println(sb);
		
	}
}