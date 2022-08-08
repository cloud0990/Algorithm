package algorithm.java.reviewinherit;

class Human {
	
	int arms = 2;
	int legs = 2;
	
	public void armsLegs() {
		
		System.out.printf("Human has arms(%d) and legs(%d)\n", arms, legs);
	}
}


class Baby extends Human {
	
	//Baby의 추가속성
	String cute = "cute";
	
	public void cute() {
		super.legs = 4;
		
		//super(); => [super class의 생성자 호출] 인데, 여기서는 안 만들어서 안 썼음
		
		System.out.printf("Baby has legs(%d)\n", legs);
		System.out.printf("Baby is %s\n", cute);
	}
}

class Teenager extends Baby {
	
	//Teenager의 추가속성
	String schoolUniform = "schoolUniform";
	
	public void schoolUniform () {
		super.arms = 2;
		super.legs = 2;
		System.out.printf("Teenager has arms(%d) and legs(%d)\n", arms, legs);
		System.out.printf("Teenager wear %s\n", schoolUniform);
	}
}

class Adult extends Teenager {
	
	//Adult의 추가속성
	String exhausted = "exhausted";
	
	public void look() {
		super.arms = 2;
		super.legs = 2;
		System.out.printf("Adult has arms(%d) and legs(%d)\n", arms, legs);
		System.out.printf("Adult looks %s\n", exhausted);
	}
	
}


public class _01_Inheritance{
	
	public static void main(String[] args) {
														
		//Up-casting(자동형변환) => Baby(Human+Baby)의 속성 중, 사용범위를 Human으로 제한
		//    참조변수 => 사용범위    =>자식클래스의 객체가 부모클래스의 객체타입으로 형변환
		Baby human = new Baby();
		human.armsLegs();
		//human.cute(); //(X) 사용영역 Human으로 제한되어있어서 호출할 수 없음
		
		System.out.println("--------------------------------");
		
		//Down-casting(강제형변환) => human의 사용영역을 Human+Baby로 늘려서 Baby안에 있는 데이터 사용가능
		//업캐스팅으로 Baby의 사용영역을 human으로 제한해놨기 때문에, 다시 human을 Baby로 다운캐스팅 가능함
		Baby baby = (Baby)human;  //=> Baby baby = (Baby)new Human : 오류코드
		baby.cute(); //Baby의 cute()
		baby.armsLegs(); //Human의 armsLegs() => Human의 sub class이기때문에 접근가능
		
		//다운캐스팅은 원래 성립하지 않는 문법이지만 위와같이 업캐스팅이 선행된 경우, 다운캐스팅 성립됨

		System.out.println("---------------------------------");
		
		Teenager tng = new Teenager();
		tng.schoolUniform();
		
		System.out.println("---------------------------------");
		
		Adult adult = new Adult();
		adult.look();
		
	}
}