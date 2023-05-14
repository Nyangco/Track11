package m_interface;

public class J2010_main {

	public static void main(String[] args) {
//		interface란? - 극단적인 추상클래스
//		어차피 추상method만이 오니까 굳이 abstract 쓰지 않아도 작동한다.
//		interface를 상속받을땐 implements 라는 약속어를 사용한다.
//		interface의 모든 method와, 이를 상속받는 class의 모든 상속된 method들은 접근제한자로서 public을 갖는다.
//		interface은 얼마든지 상속받을 수 있다. 일반적인 class의 상속은 하나로 제한됨.
//		추상클래스는 interface에 비해 효율이 떨어진다.
//		type을 통일시키기 위한 목적으로 interface를 주로 사용한다.
		Cat cat1 = new Cat();
		Animal cat2 = new Cat();
		InterAA cat3 = new Cat();
		InterBB cat4 = new Cat();
	}

}
