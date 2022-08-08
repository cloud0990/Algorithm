package algorithm.programmers.levelone;

import java.util.Scanner;

/*

1. 고려사항

arr1과 arr2의 크기는 동일하다.

solution함수의 인자값으로 들어온 2차원 배열은 0열일 수 있다.

*/

public class _행렬의덧셈 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//배열의 크기 입력받기
		int n = sc.nextInt();
		
		//입력받은 n만큼 배열 생성
		int[][] arr1 = new int[n][n];
		int[][] arr2 = new int[n][n];
		
	
		//arr1 값 입력
		for(int i=0; i<n; i++) {
			
			for(int k=0; k<n; k++) {
				
				arr1[i][k] = sc.nextInt();
			}
		}
		
		//arr2 값 입력
		for(int i=0; i<n; i++) {
			
			for(int k=0; k<n; k++) {
				
				arr2[i][k] = sc.nextInt();
			}
		}
		
		
		//함수호출
		int[][] temp = solution(arr1, arr2);

		
		System.out.println("-----[결과출력]-----");
		
		for(int i=0; i<temp.length; i++) {
			for(int k=0; k<temp[i].length; k++) {
				
				System.out.print(temp[i][k] + " ");
				
			}
			System.out.println();
		}
		
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2){
		
		//answer배열의 크기를 arr1만큼 설정하기위한 변수생성
		int row = arr1.length;
		int col = arr1[0].length;
		
		int[][] answer = new int[row][col];
		
		
		//인자값으로 들어온 배열의 열이 0인 경우 -> 반복 1번으로 가능
		if(col==0) {
			
			for(int i=0; i<row; i++) {
				answer[i][0] = arr1[i][0] + arr2[i][0];
			}
		
	    //인자값으로 들어온 배열의 열이 0 이상인 경우 -> 반복2번으로 가능
		}else {
			
			for(int i=0; i<row; i++) {
				for(int k=0; k<col; k++) {
				
					answer[i][k] = arr1[i][k] + arr2[i][k];
				}
			}
		}//if end
		
		return answer;
	}
	
}