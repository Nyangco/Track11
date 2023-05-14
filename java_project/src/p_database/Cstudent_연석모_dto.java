package p_database;

public class Cstudent_연석모_dto {

	private String sId, name;
	private int age;
	
	public Cstudent_연석모_dto(String sId, String name, int age) {
		super();
		this.sId = sId;
		this.name = name;
		this.age = age;
	}

	public String getsId() {
		return sId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	
	
}
