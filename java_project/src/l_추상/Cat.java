package l_추상;

public class Cat extends Animal{
	
	String cat;
	
	@Override
	String getVoice() {
		return "야옹";
	}

	@Override
	int getWeight() {
		return 3;
	}
	
	String getHeight() {
		return "25cm";
	}
	
	

}
