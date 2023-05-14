package f_method;

public class J0119_2 {

	public static void main(String[] args) {
		
		J0119_2_sub sub = new J0119_2_sub();
		
		String result = sub.getGubun("200");
		System.out.println(result);
		
		int a = 80, b = 90;
		String total = sub.getTotal(a,  "90");
		System.out.println(total);
	}
}
