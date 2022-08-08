package algorithm.java.reviewio;

import java.io.Serializable;


				      //직렬화가 가능하도록 직렬화가 가능한 객체로 만들어준다 -> Serializable 인터페이스를 상속받는다6
public class PersonVo implements Serializable {
	
	/*
	Vo(Value Object)
	1. 데이터를 저장관리하는 객체
	2. getter/setter를 반드시 구현해놔야함 => Vo 객체를 쓸 때 반드시 선언
	
	cf) DTO or To
		Date Transfer Object(데이터 전달객체)
	*/
	
		
		private String name;
		transient private  int age; //transient : 해당필드는 직렬화에서 제외된다
		private String addr;
		
		
		//Overload된 생성자가 있을 경우, 반드시 기본생성자도 생성
		public PersonVo() {
		}
		
		
		public PersonVo(String name, int age, String addr) {
			super();
			this.name = name;
			this.age = age;
			this.addr = addr;
		}
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		
		
		public String toString() {
			String str = String.format("%s-%d-%s", name, age, addr);
			return str;
		}
}