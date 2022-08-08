package algorithm.java.reviewthread;


//Runnable로 구현한 객체를, Thread클래스의 생성자로 초기화
//지금은 예제만드느라 부모클래스가 없지만, 나중에서는 있을 수도 있고, 없었지만 추가될 경우도 발생할 수 있으니까
//Runnable 더 많이 쓰는듯
//->자바에서는 단일상속만 가능하니까, Thread를 일반상속 받아버리면, 다른 부모클래스를 상속받을 수 없다

public class ThreadTest_동기화 implements Runnable{
	
	private int deposite = 10000;
	
	@Override
	public void run() { //공유자원 메소드
		
		synchronized (this) {
			
			for(int i=0; i<10; i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				deposite -= 100;
				
				if(deposite<=0) break;
			}//for end
			
			System.out.println(Thread.currentThread().getName());
			System.out.println(deposite);
			
		}//동기화 종료
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		/*
		
		+) 공유자원 : 인스턴스,static변수...
		
		임계영역 : 서로다른 스레드에 의해 공유자원이 참조될 수 있는 코드의 범위
		         두 개 이상의 스레드가 특정자원을 공유하고 있을 때, 한 번에 하나의 스레드만 접근할 수 있도록 허용하는 영역
		
		=> 멀티스레드 프로그래밍 환경에서 하나의 객체를 공유한 경우, 임계영억을 처리할 떄 많은 어려움 발생
		   말 그대로 멀티스레드인데. 임계영역에서는 한 번에 하나의 스레드만 접근할 수 있으니까
		   -> 그래서 싱크로나이즈드예약어를 사용해서 해결할 수 있따
		   싱크로나이즈드블럭은, 특정 스레드가 공유자원에 접근하면, 락을 걸어 다른 스레드가 접근할 수 없게 하고, 일이 끝나면 락을 해제해 접근할 수 있도록함
		   어제 했던 New -> Runnable -> Running의 순서에서, 
		   먼저 Running상태에 도달한 스레드가 싱크로나이즈드 블록을 만나면, 락 영역으로 이동된다(Lock)
		   일 처리 후 메소드 종료시 Unlock상태가되어 락 영역을 빠져나와 다시 실행가능한 상태로 돌아가고,
		   한 스레드의 락이 해제되어 락 영역을 탈출했을 때, 다른 스레드가 락을 획득해 락 영역에 들어갈 수 있다
		   
		   메소드의 동기화방법 접근제한자 뒤에 바로 예약어 적음
		   public synchronized (this생략되있음) void 메소드명(){
		   		임계영역 코딩
		   }
		   => 이 경우, 메소드에 하나의 스레드가 진입하면 공유객체의 락을 획득해 다른 스레드가 접근할 수 없고, 완료되면 언락
		   
		
		   특정블록의 동기화
		   public void 메소드명(){
		   	   synchronized(동기화할 객체/클래스명 => 주로 this사용){
		   	   		임계영역 코딩
		   	   }
		   }
		   => 여러개의 스레드가 메소드에 접근할 수는 있지만, 동기화된 블록에서는 하나의 스레드만 진입할 수 있닫
		   특정영역에 동기화 하는 이유 : 전체 메소드를 동기화하는 것보다, 필요한부분만 동기화해서 시간절약
		   블록으로 설정할 때, 매개변수로 동기화할 객체, 클래스명을 사용하는데, 동기화할 클래스가 자신인 경우 this사용
		   static메소드 안에서 동기화를 해야할 경우에는 클래스명으로 사용(static메소드에서는 this사용불가)	
			
		
		---> 해결방법 : lock
		락 : 공유객체에 여러스레드가 동시에 접근하지 못하도록 함, 객체가 힙 영역에 생성될 때, 자동으로 생성됨 
		=> 임계영역에서, 한 번에 하나의 스레드를 처리하고자 할 때, synchronized블록으로 되어있을 때 사용(보통의 경우에는 사용X)
		
		해당 메소드 앞에 synchronized예약어를 붙이면, 자동으로 특정 스레드가 공유자원에 접근하면, 락을 걸어 다른 스레드가 접근할 수 없도록 함
		일 끝나면 락을 풀어 다른 스레드가 접근할 수 있도록 함
		=> synchronized블럭이 없을 경우, 스케줄러에의해 선점형스케줄링 -> 스레드가 공정하게 실행되지않는다
		
		
		
		
		공정 : 여러 개의 스레드가 하나의 자원을 사용하기위해, 동시에 접근하는 프로그램을 작성할 경우, 
		멀티스레드 프로그래밍할 경우, 모든 스레드가 공정하게 자원을 사용할 수 있도록 해야함
		이 조건을 만족하면 프로그램이 공정한 거고, 아니면 기아상태, 교착상태에 빠졌다고 함
		
		기아상태 : 스레드가 자원을 얻기위해 blocked상태에 있고, 그 자원을 얻을 수 없게 되면 다른 작업을 못하는 상태
		결국 일 못하고 놀고있는 상태 -> 조건부로 notify할 때, 기아상태에 진입할 가능성 있음
		-> 만약 스레드가 2개 있는데 한 스레드가 저 상태면, 다른 한 스레드만 계속 일하는 상태
		
		교착상태 : 두 개 이상의 스레드가, 서로에게 어떤 일을 해주기를 기다리는 상태, 둘 중 한 명이 먼저 포기 안 하면 영원히 기다림 -> 최악의 상태
		
		
		
		
		*/
		
		//클래스 객체 생성 해야함
		ThreadTest_동기화 t = new ThreadTest_동기화();
		
		//스레드 생성 -> new Thread
		Thread tt = new Thread(t, "출금");
		
		Thread get = new Thread(t, "계좌이체");
		
		//추상메소드 run에서 동작하지만, start가 먼저 실행되고 난 후 run메소드가 실행 얘가 run메소드 실행하라고 하는 거임
		tt.start();
		get.start();
		//start메소드를 실행하게되면, 하나의 run공유자원을 ㄹㅇ 공유하는 게 아니라, run메소드를 복사하여 각각 독립적으로 사용하는 것임
		//=> 공유자원을 복사해서 각각 독립적으로 사용한다
	}
}