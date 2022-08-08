package algorithm.programmers.levelone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _제일작은수제거하기 {

//전역변수
	static int[] arr;  //원본배열
	static int[] temp; //복사본배열
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder   sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		arr  = new int[N];
		temp = new int[N]; //복사본배열 초기화
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//입력완료
		
//내림차순 정렬
		mergeSort(0, arr.length-1);
		
		//작은 수 제거하기
		int[] answer = new int[N-1];
		
		for(int i=0; i<answer.length; i++) {
			
			answer[i] = arr[i];
		}
		
		
	}
//병합정렬 : 항상 O(nlogn) 	
	public static void mergeSort(int start, int end) {
		
		//시작범위가 종료범위를 초과하지 않았다면,
		if(start<end) {
			
			//중앙지점 설정
			int mid = (start+end)/2;
			
			//재귀 : left / right half
			mergeSort(start, mid); //left  half
			mergeSort(mid+1, end); //right half
			
			int p   = start; //시작지점
			int q   = mid+1; //half의 시작지점
			int idx = p;
			
			//시작지점이 half 이하이거나, half 시작지점이 종료지점 이하인 경우, (범위 내에 있는 경우 정렬)
			while(p<=mid || q<=end) {
				
				//half시작지점이 종료지점을 초과했거나 / 시작지점이 half종료지점이하이면서, leftside요소가 rightside요소보다 클 때
				//정렬                    asc/desc 조건
				if(q>end || (p<=mid && arr[p]>arr[q])) {
					
					temp[idx++] = arr[p++];
				
				}else {
					
					temp[idx++] = arr[q++];
				}
			}//while end
			
			//정렬된 복사본 배열을 다시 원본배열로 복사
			for(int i=start; i<=end; i++) {
				arr[i] = temp[i];
			}
			
		}//if end
		
	}//mergeSort() end
}