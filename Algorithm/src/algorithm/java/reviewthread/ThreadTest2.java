package algorithm.java.reviewthread;

public class ThreadTest2 extends Thread {
	
	int thread;
	
	@Override
	public void run() { //run()가 끝나면, 해당 일을 수행한 스레드는 소멸된다.
		System.out.println("스레드 실행 : run()");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("스레드 종료");
		
	}//run() end
	
	
	//오버로드 생성자 쓰려고 기본생성자 생성
	public ThreadTest2() {
	}
	
	//오버로드 생성자 생성
	public ThreadTest2(int t) {
		this.thread = t;
	}
	
	
	
	public static void main(String[] args) {
		
		/*
		
		1. Thread를 상속받아 구현하는 방법                    extends    Thread     (일반상속)
		2. Runnable을 구현한 객체를 Thread클래스에 전달하는 방법  implements Runnable   (인터페이스 상속)
		   => 함수형인터페이스 : 추상메소드 run하나만 존재, -> 해당 추상메소드 재정의해서 사용
		       -> 추상메소드를 한 개만 가지고 있는 인터페이스 : 함수형 인터페이스
		
		=> 스레드의 생성방법을 두 가지로 제공하는 이유
		부뫀클래스는 하나 밖에 가질 수 없다(단일상속). Thread 클래스를 상속받으면, 다른 부모클래스를 가질 수 없고,
		이미 다른 부모클래스를 상속 받았다면 스레드 클래스를 상속 받을 수 없다
		그래서 Runnable인터페이스를 상속받아서 스레드를 생성할 수 있다
		
		
		#스레드 주요메소드
		getName() : 스레드의 이름 반환 (String)
		setName() : 스레드의 이름 지정
		
		currentThread() : 현재 수행되는 스레드객체를 리턴
		=> Thread.currentThread(); 로 사용 -> class명.함수명
		=> 이 메소드는 static메소드여서, 클래스명으로 호출해서 사용
		
		+) setPriority : 스레드의 우선순위 지정 ---> 조심해서 사용
		
		
		
		
		
		지금은 Thread클래스 extends상속받아서 run메소드를 따로 구현했다. 
		interface Runnable을 상속받게될 경우, 무조건 추상메소드 재정의해야한다.
		하지만 Thread클래스 일반상속을 받았다 하더라도, start해서 run해야하기때문에 메소드 재정의해서 사용한다
		
		콘솔창의 결과를 확인하면, 스레드가 순서대로 실행되지않고, 뒤죽박죽 실행되는 것을 확인 할 수있다.
		이것을 동기화라고 하는데, 동기화란, OS(운영체제)의 스레드 스케줄러에 의해 각각의 스레드들의 순번을 스케줄러가 지정한다.
		우리는 스케줄러를 제어할 수 없다. 이렇기 때문에 멀티스레드환경에서는, 동기화를 고려해야한다.
		최악의 경우, 스레드들이 기아상태나 교착상태에 빠기때문에 프로그램이 아예 동작하지 않는 경우도 있다
		
		resume()  : 스레드 재가동
		suspend() : 스레드 일시정지
		
		프라이머리 스레드 (주스레드/메인스레드) -> 맨 처음, CPU(Processor)로부터 할당받은 스레드이다
		
		프로세스 : 운영체제에서 실행 중인 하나의 프로그램
		스레드(프로세스 내에서 실행되는 세부 작업단위)가 여러 개 모여서 하나의 프로세스를 이룬다
		
		
		New      : 스레드가 만들어진 상태 ==> Thread tr = new Thread();
		Runnable : 실행가능한 상태 -> start메소드 호출한 상태 : 실제 스레드가 할당되는 시점
		running  : 실행상태 -> run 메소드를 실행한 상태
		
		=> 스레드가 생성(New)되고, 스레드가 실행가능한 상태(Runnable)로 이동, 다시 스케줄러에 의해 실행상태(Running)로 이동
		
		
		Blocked : 대기상태
		Dead    : 스레드가 종료(run()종료)되면, 그 스레드는 소멸된다.
		
		
		
		
		
		선점형 스케줄링 : 실행 중인 스레드보다 우선순위가 더 높은 스레드가, 실행가능한상태(Runnable)에 있다면
		스레드 스케줄러는 우선순위가 더 높은 스레드에게 제어권을 넘겨준다.   -> 스케줄러 우리가 제어못함, 예측도 못함
		
		JVM은 현재 스레드를 수행한 다음에 실행 가능한 상태의 스레드 중에서, 
		하나를 선택해서 실행한다. 우선순위가 같을 때에는 스레드 스케줄러의 기준에 의해 실행될 스레드가 결정된다.
		여러 개의 스레드가 start메소드에 의해 시작되더라도, 어떤 스레드가 우선적으로 수행될지 알지 못함
		
		스레드의 우선순위가 같은 경우, 스레드 스케줄러가 어떤 스레드에게 제어권을 넘길지 알지 못함
		## 동일한 운영체제에서, 동일한 프로그램을 실행해도 결과가 항상 같지 않다
		-> 여기서 스레드 우선순위를 부여하는 setPriority메소드를 사용할 수 있는데,
		제대로 제어 못할 거면 손 안 대는 게 좋음 -> 조심해서 사용 
		
		멀티스레드프로그램에서, 여러 개의 스레드가 하나의 자원을 공유할 경우, 그래서 동기화 문제가 발생한다
		-> 해결방법 : synchronized 예약어 사용
		
		
		
		
		
		
		*/
		
		
		ThreadTest2 tt2 = null;
		
		for(int i=0; i<10; i++) {
		
			//클래스객체 생성하자마자 오버로드생성자 초기화
			tt2 = new ThreadTest2(i);
			
			tt2.start(); //스레드 객체 생성하고, 여기서 start메소드를 실행하면, 위의 run메소드가 내부적으로 실행하도록 동작한다
			//1. start()실행 -> 2. run()메소드 실행
		}
		
		System.out.println("main() 종료");
		
	}//main() 종료
}