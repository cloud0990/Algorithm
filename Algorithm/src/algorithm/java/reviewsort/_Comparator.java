package algorithm.java.reviewsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _Comparator {

	public static void main(String[] args) throws IOException {
		 
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] arr = new int[2][2];
		
		//배열을 입력받는다
		
		
		Comparator<int[]> comparator = new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		};
		
		//사용자정의의 정렬기준으로 정렬
		Arrays.sort(arr, comparator);
		
		
		
		
		
		
		
		
		
	}
}