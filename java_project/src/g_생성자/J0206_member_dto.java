package g_생성자;

public class J0206_member_dto {

	String id, name, result; 
	double height, weight;
	
	public J0206_member_dto() {
		super();
	}

	public J0206_member_dto(String id, String name, double height, double weight, String result) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.result = result;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
	
}
