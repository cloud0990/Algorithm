package algorithm.java.reviewthread;

public class ThreadTest extends Thread {

	public static void main(String[] args) {
		
		//스레드를 생성하는 방법 2가지
		//1. extends Thread : Thread클래스 상속받기
		//2. implements Runnable : Runnable interface상속받기
		//   => 인터페이스상속이기때문에, 해당 인터페이스의 추상메소드(run())을 재정의해야함
		
		/*
		
		start() : 스레드를 실행하겠다는 메소드
		run()   : start()가 실행되면, run()으로 스레드 생성
		
		
		스레드 : 일꾼
		싱글 스레드 프로세스 : 한 프로세스당 1개의 스레드가 일함. 1개의 스레드가 모든 일처리 수행
		멀티 스레드 프로세스 : 한 프로세스에, 여러 개의 스레드가 동작 -> 효율성 높고, 비용 적음
		
		CGI방식 : 사용자가 웹서버에 요청할 때마다, 프로세스를 생성하는 방식
		Java Servlet : 사용자가 웹서버에 요청할 때마다, 한 프로그램 내에서 스레드를 생성하여 일처리 -> 효율적
		
		멀티스레드 사용시 고려사항 -> 고려사항많은 게 단점
		1. 동기화에 주의 -> 동기화란, os 스레드 스케줄러에의해 순서가 정해진다. -> 그 순서는 우리가 지정할 수도 알 수도 없다
		2. 동기화처리를 제대로 하지않는다면, 기아상태/교착상태에 빠질 수 있다.
			2-1. 기아상태 : 한 스레드만 계속 일하고, 한 스레드는 일 없이 논다
			2-2. 교착상태 : 두 스레드 모두 서로 일하라고 둘 다 일 안 하고 있는 상태
		3. 각 스레드가 효율적으로, 고르게 실행되도록 구현해야함
		*/
		
		//스레드 객체생성 => 상속받은 부모클래스의 객체를 생성해서 요소 사용
		Thread tr = new Thread();
		
		tr.start();
		
		//해당클래스 객체 생성 후, 부모클래스의 요소 사용
		ThreadTest tt = new ThreadTest();
		
		//해당 클래스는 스레드클래스를 상속받았기 때문에, 해당 클래스객체를 생성해도 스레드클래스의 기능을 모두 사용가능
		tt.start(); 
		
		//스레드클래스는, start()메소드가 실행되면, run메소드가 실행되도록 내부적으로 동작한다.
		
		
		
		
		
	}
	
	
	class ThreadTestInter implements Runnable{

	@Override //인터페이스를 상속받았기 때문에 꼭 재정의해서 구현해야함
	public void run() {
		
	}
		
	Runnable rn = new Runnable() {
	
		@Override
		public void run() {
			
		}
	};
	
	
	
}
	
	
	
}