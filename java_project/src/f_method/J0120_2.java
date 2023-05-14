package f_method;

public class J0120_2 {

	public static void main(String[] args) {
		J0120_2_sub sub = new J0120_2_sub();
		int total = sub.getTotal(10,20,30);
		System.out.println("total : "+total);
		total = sub.getTotal(10, 20, "30");
		System.out.println("total : "+total);
		total = sub.getTotal(10, "20", "30");
		System.out.println("total : "+total);
		total = sub.getTotal(10, "20");
		System.out.println("total : "+total);
	}
}
