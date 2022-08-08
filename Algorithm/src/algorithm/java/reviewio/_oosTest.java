package algorithm.java.reviewio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class _oosTest {

	public static void main(String[] args) throws Exception{
		
		//                       오버로드생성자 생성해놨기 때문에 바로 초기화 가능
		_voTest vo = new _voTest(20, "홍길동", "서울특별시 관악구");
		
		//직렬화 -> 데이터를 순서대로 분해해서 저장한다
		OutputStream os = new FileOutputStream("voTest.dat");
		
		//직렬화 객체 생성           os에 직렬화해서 저장할 파일 이름의 주소를 저장했기 때문
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		//직렬화 -> writeObject
		oos.writeObject(vo);
		
		//닫기 -> 열린역순
		oos.close();
		os.close();
		
		
		//역직렬화 -> 직렬화로 분해된 데이터를 순서대로 재조립해서 읽어온다
		InputStream is = new FileInputStream("voTest.dat"); // voTest.dat파일을 fileInputStream으로 읽어와서 is참조변수 안에 저장
		
		ObjectInputStream ois = new ObjectInputStream(is);
		
		//직렬화가 된 객체를 is에서 읽었고, 읽은 파일은 objectInputStream으로 재조립했다
		//재조립되어 다시 객체가 된 데이터를 읽어온다
		_voTest v = (_voTest)ois.readObject();
		//재조립된 데이터타입을 readObject로 받으면, Object는 최상위class이기때문에 모두 읽어올 수 있다
		//하지만, _voTest는 Object의 하위클래스이기때문에 object의 영역을 _voTest까지도 쓸 수 있도록 down-casting영역확장을 해야한다.
		
		System.out.println(v);
		
		//닫기 -> 열린역순
		ois.close();
		os.close();
		
	}
}