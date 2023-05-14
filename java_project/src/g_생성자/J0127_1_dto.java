package g_생성자;

public class J0127_1_dto {
	
	String id, name, area;
	int age;
	//source의 constructors using fields에서 생성자도 자동생성이 가능하다.
	
	public J0127_1_dto() {
		this(null,null,null,0);
	}
	
	public J0127_1_dto(String id) {
		this(id,null,null,0);
	}

	public J0127_1_dto(String id, String name) {
		this(id,name,null,0);
	}

	public J0127_1_dto(String id, String name, String area) {
		this(id,name,area,0);
	}

	public J0127_1_dto(String id, String name, String area, int age) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.age = age;
	}
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	J0127_1_dto(String id, String name){
//		this(id,name,"area",0);
//		알아서 잘 찾아간다 - 순서 바꿔도 잘 동작함
//	}
}
