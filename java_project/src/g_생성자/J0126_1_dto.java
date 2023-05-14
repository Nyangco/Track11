package g_생성자;

public class J0126_1_dto {
	
	String name;
	int age;
	
	J0126_1_dto(String name){
		this.name = name;
	}
	
	J0126_1_dto(){}
	
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

	
//	생성자 method - new J0126_DTO(){}; 와 같이 생성되어지기에.
//	Class와 이름이 같고, return이 공란인 method 구조는 생성자 method 라고 한다.
//	생성자는 반드시 하나 이상 필요하며, 별도의 선언이 없으면 기본 생성자를 자동으로 작성한다.
//	기본 생성자는 클래스명과 같고, 소괄호쌍과 중괄호쌍에 아무것도 들어 있지 않은 생성자이다.
	
	

}
