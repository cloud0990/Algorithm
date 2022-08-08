package algorithm.java.reviewstream;

import java.util.Arrays;
import java.util.stream.IntStream;

/*

- IntStream (java 8.0 later)

java.util.stream 의 API
-> primivive(원시)데이터형 int를 Stream으로 관리할 수 있게 해줌

- IntStream.of()
of의 인자로, 숫자 / 배열 가능


- IntStream.range(시작인덱스, 종료인덱스)

range(1,5) : 1 2 3 4  int Stream 생성
결과 : 1 2 3 4

- IntStream.rangeClosed(시작인덱스, 종료인덱스) : 1 2 3 4 5 int Stream 생성
결과 : 1 2 3 4 5


+) Arrays.stream(배열만 가능)

*/

public class _IntStream {

	public static void main(String[] args) {
		
		int   N   = 5;
		int[] arr = {1, 2, 3, 4, 5};
		
		//IntStream을 사용하여 max / min 값 구하기
		int max = IntStream.range(1, N).max().getAsInt(); 
		int max2 = Arrays.stream(arr).max().getAsInt();
	
		int min = IntStream.rangeClosed(1, N).min().getAsInt(); 
		int min2 = Arrays.stream(arr).min().getAsInt();
		
		//IntStream을 사용하여 합계 구하기
		int sum  = IntStream.of(arr).sum();
		int sum2 = Arrays.stream(arr).sum();
		
		//IntStream을 사용하여 평균값 구하기 : average()는 double만 가능
		double avg  = IntStream.of(arr).average().getAsDouble();
		double avg2 = Arrays.stream(arr).average().getAsDouble();
		
		//람다식을 사용해서 배열의 요소 하나씩 출력
		System.out.println("IntStream");
		IntStream.of(arr).forEach(System.out::println);
		
		System.out.println("Arrays.stream");
		Arrays.stream(arr).forEach(System.out::println);
		
		
		System.out.printf("최대값    : %d\n", max);
		System.out.printf("arr최대값 : %d\n", max2);
		System.out.println();
		System.out.printf("최소값    : %d\n", min);
		System.out.printf("arr최소값 : %d\n", min2);
		System.out.println();
		System.out.printf("IntStream     합계 : %d\n", sum);
		System.out.printf("Arrays.stream 합계 : %d\n", sum2);
		System.out.println();
		System.out.printf("IntStream     평균 : %.3f\n", avg);
		System.out.printf("Arrays.stream 평균 : %f\n", avg2);
		
	}
}