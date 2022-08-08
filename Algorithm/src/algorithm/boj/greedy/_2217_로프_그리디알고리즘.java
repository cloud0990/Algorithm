package algorithm.boj.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
1. 고려사항
반드시 주어진 모든 로프를 사용할 필요가 없다.
만약, 10 10 6 이렇게 있는 경우, 6을 버리면 포함시켰을 때보다 더 큰 최대중량값을 얻을 수 있다.

주식문제와 비슷하게 오름차순해놓은 상태에서 순차적으로 비교하면 어려운 문제였다.
그리디알고리즘의 핵심은 가장 이득을 볼 수 있다면 조금의 손해도 감수하는 것이기 때문에,
오름차순을 해서 처음부터 볼 필요가 없는 것이다. 다음에 그리디알고리즘을 또 풀게된다면 최대값을 먼저 봐야겠다.
모든 요소가 동일한 최대중량을 들어야하는 게 아니라, 최대중량을 들 수만 있다면, 최소값이나 그 외의 값들은 버려도 된다.
최대값부터 비교를 시작할 때, i+1의 이유는, 중복값이 없다고 가정했을 때, 숫자가 작아질 수록, 곱해야할 로프의 갯수가 많아지기때문이다.
최소값에 가까워질 수록, 최소값보다 값은 크지만 최소값의 최대중량과 같이 들어야하기때문에 해당 로프도 병렬해야한다.



2. 문제점
알고리즘 분류에따라서 그 알고리즘을 가장 잘 이용할 수있도록 고민해야하는데 확인 해놓고도 활용할 생각을 막상 문제 고민하기시작하면 못한다.
이번 문제 풀면서 확실히 느낀 점은, 문제의 예제기준으로 문제를 푸니까 반례가 생기면 적용하지못하고 계속 반례에 맞게 코드를 수정하니까
또 다른 반례가 나오면 또 틀려서 또 다시 반례에 맞게 코드를 수정했다.
오늘 그렇게 풀긴 했지만, 그 동안 문제 풀면서 메소드 호출해서 결과값 구하는 거랑 boolean형 메소드의 리턴값으로 결과값 도출하는 거 연습해봐서 좋았다.
그리고 원래는 문제를 보면 어떻게 접근해야할지 전혀 감도 안 왔는데 이제는 틀리더라도 이런 식으로 풀면 되지 않을까 정도가 됐다는 걸 확인 할 수 있는 문제였다
그리디알고리즘은 대부분 정렬을 해서 최대값부터 탐색하는 것 같다. 다음에 그리디알고리즘을 또 풀게 된다면 정렬 후 최대값을 먼저 탐색하는 방법을 사용해봐야겠다.
*/


public class _2217_로프_그리디알고리즘 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder   sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[n];
		
		for(int i=0; i<n; i++) {
			st     = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, Collections.reverseOrder()); //내림차순 정렬
		
		int max = 0;
		
		for(int i=0; i<arr.length; i++) {
			
			if( max < arr[i]*(i+1) ) {
				max = arr[i]*(i+1);
			}
		}
		
		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}