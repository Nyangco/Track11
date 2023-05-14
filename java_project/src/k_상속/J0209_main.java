package k_상속;

public class J0209_main {
	public static void main(String[] args) {
		J0209_a aa = new J0209_a();
		
		J0209_b bb = new J0209_b();
		System.out.println(bb.getTotal(20, 30));
		
		J0209_c cc = new J0209_c();
		
		J0209_a dd = new J0209_c();
		
	}
}
