package g_생성자;

public class J0203_dto {

	String name, gender;
	int age, money;

	J0203_dto(){}

	public J0203_dto(String name, String gender, int age, int money) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
