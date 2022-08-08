package algorithm.boj.twopointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2003_수들의합 {
	
	/*
	
10 5
1 2 3 4 2 5 3 1 1 2
	
	*/
	
	public static int twoPointer(int n, int target, int[] arr) {
		
		int count = 0;
		int sum   = 0;
		int start = 1;
		int end   = 2;

		
		while(start<=end) {
			
			if(sum==target) {
				
				count++;
				end++;
				
			}else if(sum<target) {
				
				sum += arr[end++];
				
			}else if(sum>=target) {
				sum -= arr[start++];
			}
			
		}//while end
		
		
		return count;
	}//twoPointer end
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		int n = Integer.valueOf(st.nextToken());
		int t = Integer.valueOf(st.nextToken());
		
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//예제입력완료
		
		sb.append(twoPointer(n, t, arr));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}