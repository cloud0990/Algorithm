package algorithm.boj.reviewplus;

import java.util.Scanner;

public class _4344_평균 {

	public static void main(String[] args) {
		
		//학생들의 점수의 평균 구하기
		//평균 구하려면 점수의 합이 필요하다. 점수 입력받음과 동시에 누적값을 구한다
		//점수의 누적값/학생수 => 평균점수
		//평균점수<학생의 성적index 비교해서 count증가(평균넘는 학생수)
		//구한 학생수/전체학생수 * 100 => 평균넘는 학생들의 비율
		//조건 : 비율을 반올림하여 소수점 3째 자리까지 출력 (소수점자리 출력하려면 double형 사용)
		
		
		/*
			실수형 자료형의 기본자료형 : double
				-> float형으로 쓸 때 숫자 뒤에 f붙여줌    ex) float = 3.14f;
			
			float VS double -> 정밀도면에서 double이 더 정확하게 자료를 보관하기때문에, 자바에서 실수형자료형의 기본자료형은 double
			
			*모든 연산시, 자료형 맞춰서 연산해야 정확한 값이 나옴*
			-> 연산에 필요한 변수의 자료형은 통일시키는 게 좋음 -> 더 큰 랭크의 자료형을 작은 랭크에 담을 수 있지만, 데이터 손실 가능성 O
			   자동으로 형변환이 된다고 해도 그냥 자료형 맞춰서 연산
			
			
		*/
		
		Scanner scanner = new Scanner(System.in);
		
		//테스트 케이스 갯수
		int testCase = scanner.nextInt();
		
		for(int i=0; i<testCase; i++) { //입력받은 testCase만큼 돈다
			
			//학생 수 배열 생성
			int student = scanner.nextInt(); //학생수만큼의 점수 받아야하니까 학생 수 먼저 입력받기
			//testCase수만큼 돌면서 배열 만들어짐
			int [] n = new int[student]; //입력받은 학생 수만큼의 배열 => 학생 수 만큼 점수 받을 수 있음
			
			
			//결과값, 평균이 넘는 학생 수 : double 자료형 -> int 자료형의 범위 초과 발생 가능성 유
			double res   = 0; //결과값 -> 평균넘는 학생의 비율 -> 소숫점 셋쨰자리까지 출력해야해서 double
			//평균 넘는 학생 수 -> 학생 수는 정수이지만, 비율 구할 때 double형 자료형에 값을 넣을 거여서 double형으로 해야 결과값 제대로 나옴
			double count = 0; 
			int    sum   = 0; //점수 누적값 담을 변수 -> 점수는 결과값 연산에 영향 안 미침 -> int형으로 선언해도 오류X
			
			
			//점수 입력받아서 누적값 구하는 for문
			for(int k=0; k<n.length; k++) {
				
				//성적입력 => 점수 입력 제대로 안 됨
				int score = scanner.nextInt(); //성적 입력하기
				n[k] = score; //입력받은 성적 배열 안에 넣기
				
				//점수 입력 제대로 안 되니까 누적도 안 됨
				//성적 누적 => 위에서 n[k]안에 점수 담음
				sum = sum + n[k]; //score입력 받자마자 누적값 구하기
				
			}//for k end
				
			//... 평균도 안 구해짐
			//평균 구하기 => student만큼 나누기
			double average = sum/student; //결과값 변수 자료형이 double이니까 평균 구할 변수 자료형도 맞춤
			
			//평균넘는 학생수 체크하기
			for(int j=0; j<n.length; j++) {
			
				//각 첨자의 점수와 average비교하기
				if(average<n[j]) { //n[j]에 각 점수가 들어있으니까, 그거랑 평균점수랑 비교함
					count++; //평균 넘는 학생 수 증가
				}
			}//for j end
			
			//비율 구하기 "부분 수량/전체수량 * 100"
			res = (count/student)*100;
			System.out.printf("%.3f%%\n", res);
		}//for i end
		
	}
}