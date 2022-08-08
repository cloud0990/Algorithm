package algorithm.boj.reviewplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

투 포인터    : start와 end의 이동이 가변적 -> 두 지점을 이동하면서 target과 근접한 값을 찾기 위해 if~else로 누적값과 비교하면서 포인터 이동했음
슬라이딩윈도우 : 방식은 투포인터와 비슷하지만, 

예를 들어 target이 3일 때, 0 1 2 에서 3칸만큼 한 칸 이동했을 때 1 2 3이다.
여기서 1 2 는 중복되고 0 3이 달라졌다. 그래서 한 칸 씩 앞으로 이동할 때 left++하면서, 이 값을 누적값에서 빼고
=> sum -= nArr[left++]
3은 right로 이동하면서 추가된 값이기 때문에 right++하면서 해당 인덱스값을 더해준다
=> sum += nArr[right++]
즉, 처음 0 1 2의 누적합을 구해놓은 다음, left++한 값을 누적합에서 빼면 되고, right++한 값을 누적합에 더하면 된다.

이 과정을 right가 해당 배열의 끝까지 도달하기 전까지 반복하면 된다.
투포인터에서도 이 과정을 while문으로 했는데, while문 반복조건문에서 주의할 점이 있다.
while(right!=arr.length) : arr.length라고 하면 그 전까지 돌거라고 생각해서 처음에 이렇게 조건을 줬었지만,
arr.length가 5라고 가정했을 때, 5가 아닌 모든 수에서 while문을 실행할 수 있다.
내 의도는 5전까지인 4까지 도는 거니까, while(right<arr.legnth)라고 하면 된다.
처음에 사용했던 조건문은 right가 배열보다 더 나간 경우를 고려하지 않은 식이었다.

*/

public class _2003_수들의합_슬라이딩윈도우 {
	
	public static int twoPointer(int [] nArr, int target) {
		
		int count = 0;
		
		
		for(int i=0; i<nArr.length; i++) { //배열의 크기만큼 반복
			
			int left  = 0; //start
			int right = i; //end : 반복할 때마다 한 칸씩 증가
			int sum   = 0; 
			
			//첫 번째 for문에는 right=0이다. 그래서 처음에는 이 식 실행 안 하고 건너뛴다.
			//처음에는 k<right라고 조건식을 적었는데, 그러면 첫번 째 반복문에서 sum값을 제대로 구하지 못하고 넘어가버린다. <=
			for(int k=0; k<=right; k++) { 
				sum = sum + nArr[k]; //결론적으로 첫번 째 반복문에서는 nArr[0]번째 첨자 하나를 누적했다
			}
			
			if(sum==target) count++; //구한 누적값과 target과 값이 같으면 경우의 수(결과) 카운트 증가
			
			right++; //그러고나서 right위치 한 칸 증가 -> 첫번째 반복문에서는 right = 1
			
			
			while(right<nArr.length) { //첫번째 반복문 기준으로 지금 right=1이니까 1부터 배열마지막인덱스까지 반복
				
				sum = sum - nArr[left++]; //왼쪽 값 빼면서 right로 이동
				sum = sum + nArr[right++];
				
				if(sum==target) count++;
			}//while end
			
		}//for i end
		
		return count;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder   sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [] nArr = new int[n]; //입력받은 n만큼의 배열 생성
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<nArr.length; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		sb.append(twoPointer(nArr, m));
		System.out.println(sb);
		
	}
}