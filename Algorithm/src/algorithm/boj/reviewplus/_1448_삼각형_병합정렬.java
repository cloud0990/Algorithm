package algorithm.boj.reviewplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

/*
그리디 알고리즘

문제 해석 : 세 수를 더해서 가장 큰 합이 되는 결과 출력 (최대값 찾기)
-> 배열요소의 1번최대값보다, 2번 3번최대값의 합이 더 작으면 안 됨
   그럴 경우, 2번최대값을 1번최대값으로 설정 
   +) 주어지는 수는 무조건 3이상 => index : 최소 0 1 2 는 있음

가장 큰 합이 되는 조건만 고려하면 됨


이유
배열인덱스를 반복하면서 모든 요소를 확인해서 max값을 찾는 것보다, 정렬 후 맨 위에 있는 값을 선택하는 게 효율적이라 판단
정렬을 하게되면, 1번 최대값을 쓸 수 없는 상황이더라도, 2번 최대값이 바로 뒤에 있기 때문에 또 그걸 찾기 위한 반복문을 안 돌려도 됨
최대값을 찾고, 나머지 2개의 요소의 합 중에서 또 최대값을 찾는 조건이어서, 일일이 for문 사용하는 것보다 정렬 한 번으로 바로 찾는 게 나을 듯


고려사항
1. 주어진 수 중, 최대값을 가장 빠르게 찾을 수 있는 방법 -> 내림차순정렬 후 맨 위에있는 값
   => 요소의 모든 부분을 고려해서 max값을 찾는 것보다, 내림차순 정렬해서 필요한 3개의 수만 찾음
    
2. 2번최대값을 써야할 경우, 어떻게 찾아야 효율적일지 생각
   => 처음에는 일반적으로 답이 나오는 경우와, 2번max값을 써야할 때의 조건까지 썼었는데
   
	   예를 들어, 10 2 1 1 1 이라는 수를 받았을 때, 두 수의 합의 경우가 10보다 큰 경우가 없어서 2 1 1로 미뤄진다
	   미뤄진 max값도 삼각형 생성조건에 만족하지 않아서, 1 1 1로 미뤄지고, 조건이 만족하기 때문에 결과값이 3이 나온다.
	   
	   max값을 계속 미뤄야할 경우를 고려하지않았기 때문에 정확한 결과가 나오지않았다.
	   
	   그래서 for문을 1번만 돌려서 삼각형생성 조건에 만족할 경우에만 max값을 갱신하고, 아닌 경우는 max값이 갱신되지 못해서 초기값을 그대로 가지고 오니까
	   -1을 출력해주면 원하는 결과를 볼 수 있었다


문제점
경우의 수를 자꾸 예제에 맞춰서 고려하기때문에 계속 틀리는듯
예제의 수와 결과에 맞춰서 구현하지말고, 문제의 전체적인 그림을 이해하고 거기에 맞는 식을 세워야할 것 같다

다음문제는 예제코드는 그냥 문제가 이렇구나 이해하는 용도로만 활용하고, 문제를 기준으로 구현해보기
*/

public class _1448_삼각형_병합정렬 {
	
	public static Integer [] nArr; //원본배열
	public static Integer [] temp; //원본배열의 복사본배열
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//빨대의 개수
		int n = Integer.parseInt(st.nextToken());
		
		//각 빨대의 길이
		nArr = new Integer[n];
		temp = new Integer[nArr.length];
		
		//빨대의 길이 입력받기
		for(int i=0; i<nArr.length; i++){
		
			st = new StringTokenizer(br.readLine());
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		//병합정렬_내림차순
		mergeSort(0, nArr.length-1);
		
		int max = 0;
		
		
		//조건식의 이유
		//for문 내부에서 3개의 인덱스를 비교하는 조건을 넣었기 때문에, nArr.length-2를 안 해주면 out of length 발생
		for(int i=0; i<nArr.length-2; i++) {
			
			//삼각형 생성조건에 부합할 경우만 max값 갱신
			if(nArr[i] < nArr[i+1] + nArr[i+2]) {
				
				max = Math.max(max, nArr[i] + nArr[i+1] + nArr[i+2]);
			}
			
		}//for end
		
		//조건으로 max==0인 이유
		//위의 if문의 조건을 만족하지못했을 때 max값 갱신이 안 되기 때문에 초기값 0을 가지고 여기로 내려온다
		//즉, 삼각형을 만들 수 없는 조건이기때문에 -1을 출력한다
		if(max==0) {
			max = -1;
		}
		
		System.out.println(max);
	}//main() end
	
	
	
	/*
	병합정렬(Merge Sort)
	요소가 저장된 배열을 계속 쪼개서(divide) 길이가 1인 배열을 만들고 그 이후 정렬하면서 합치는(conqure) 알고리즘
	정렬의 대상이 되는 데이터 외의 추가적인 공간을 필요로한다 -> 제자리정렬X
	최대한 작게 쪼개어 순서대로 합치기 때문에 안정정렬이다. (selection sort -> 불안정정렬)
	 => 불안정 정렬 : 동일한 값의 초기순서와, 정렬 후 순서가 다름 
	*/
	
	//병합정렬_내림차순()
	public static void mergeSort(int start, int end) {
		
		if(start<end) {
			
			int mid = (start+end)/2; //분할할 중앙 값
			
			//구간분할
			mergeSort(start, mid); //중앙기준으로 왼쪽
			mergeSort(mid+1, end); //중앙기준으로 오른쪽
			
			int s = start; //시작지점
			int e = mid+1; //중앙기준 오른쪽 시작지점
			
			int idx = s; //증가하며 배열에 값 담기위한 변수선언
			
			while(s<=mid || e<=end) { //배열 범위 벗어나지 않도록 범위 지정 반복
				//정렬시작
				
				//조건문 이유 
				//1. 오른쪽분할의 요소를 다 가져온 경우
				//2. 왼쪽분할의 요소이면서, 왼쪽분할요소가 오른쪽분할요소보다 큰 경우 -> 내림차순 (< : 오름차순)
				//=> 두 조건 중 하나이상 만족(or)할 경우 왼쪽분할에서 요소를 가져온다
				if(e>end || ( s<=mid && nArr[s]>nArr[e]) ) {
					temp[idx++] = nArr[s++];
				}else {
					temp[idx++] = nArr[e++];
				}
			}//while end
			
			//temp에 정렬해놓은 값을 다시 원본배열에 넣기
			for(int i=start; i<=end; i++) {
				nArr[i] = temp[i];
			}
		}
	}//mergeSort() end
}