package algorithm.java.reviewio;

import java.io.Serializable;

                   //직렬화 대상객체를 직렬화가 가능하도록, Serializable 인터페이스를 상속받는다
public class _voTest implements Serializable{

	private int age;
	private String name;
	private String addr;
	
	
	public _voTest() { //기본 생성자 생성
	
	}
	
	public _voTest(int age, String name, String addr) { //오버로드 생성자
		super();
		this.age = age;
		this.name = name;
		this.addr = addr;
	}


	//getter/setter 생성 -> 외부에서 private에 접근하기 위함
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	public String toString() {
		
		String str = String.format("[%d]-[%s]-[%s]", age, name, addr);
		return str;
	}
	
	
	
	
}