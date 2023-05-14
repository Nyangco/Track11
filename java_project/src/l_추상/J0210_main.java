package l_추상;

public class J0210_main {

	public static void main(String[] args) {
//		부모 클래스의 method 사용에 강제성을 부여하는 방법.
//		@ -> 부연설명을 하기 위한 특수문자(Annotation) . 
//		Override -> 연산 과정에서 부모클래스의 method를 상속함을 compiler에게 전달하기 위함.
//					-> 클래스를 상속받아 재정의할때 사용.
//		
//		abstract - 부모 클래스에서 추상 method를 선언하기 위한 예약어
//		추상 method? - method 이름만 존재하는 method, 선언하기 위해선 class 역시 추상class여야 한다.
//		추상 class? - 자식 class에서 반드시 override 해야만 사용할 수 있게 재정해놓은 class를 의미.
//		추상 class를 상속받은 자식 class는 반드시 추상 class에서 abstract로 제정해놓은 method를 참조하지 않으면 exception을 뱉어낸다.
//		@Override를 사용하는 이유? - 1. 이 method가 부모클래스로부터 상속받은 method임을 알림.
//								2. 부모 클래스의 문법과 맞지 않으면 컴파일 오류를 일으키기 때문에, 오타를 줄이는데 도움이 된다.
//		추상 method 없이 추상 class를 선언하면 안된다.
//		결론 ) 추상 method는 body가 없는 이름만 있는 method. 추상 class는 하나 이상의 추상 method를 포함하는 class.
//		추상 class는 일반적인 생성방식으로는 생성이 되지 않는다. - 누군가에게 상속을 받아서 사용해야 한다.
//		자식 class는 부모 class의 type로 형성될 수 있다.
//		부모 class type으로 형성된 자식 class의 경우, method와 field는 부모 class를 따르게 된다. ( 단독으로 생성한 method는 잘려나간다.)
//		실행문이나 return 같은 경우엔 자식을 따를듯?
//		그러나 field의 경우엔 부모 class type의 field를 갖게 된다.
//		추상 method와 부모클래스 이형성을 적절히 섞으면 각 index별로 할당된 method의 return을 자식 class를 부모 type으로 선언하면서 간단히 해결할 수 있다.
//		추상 Class는 icon에 A가 붙는다.
		
		
		
		Cat cat = new Cat();
		Animal cat2 = new Cat();
		Dog dog = new Dog();
		
		
		
		String voice = "";
		voice = cat.getVoice();
		System.out.println(voice);
		voice = dog.getVoice();
		System.out.println(voice);
		
		String height = cat.getHeight();
		System.out.println(height);
		
		Animal[] animal = new Animal[2];
		animal[0] = cat2;
		
		System.out.println(cat2.getVoice());
		
		
		
		
		
	}
}
