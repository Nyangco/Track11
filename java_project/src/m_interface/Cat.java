package m_interface;

public class Cat extends Animal implements InterAA, InterBB{
	
	@Override
	String getName() {
		return "홍길동";
	}
	
	@Override
	public String getVoice() {
		return "야옹";
	}
	
	@Override
	public String getColor() {
		return "노랑";
	}
	
}
