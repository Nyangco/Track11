package f_method;

public class J0125_1 {

	public static void main(String[] args) {
		J0125_1_sub sub = new J0125_1_sub();
		
		int total = sub.getTotal("10",20);
		System.out.println(total);
		
		total = sub.getTotal(30,"40" );
		System.out.println(total);
		
		int[] arr = {10,20,30};
		total = sub.getTotal(arr);
		System.out.println(total);
		
		int[] point = sub.getTotal(100,200);
		System.out.println(point[0]);
		System.out.println(point[1]);
		
		String[] result = sub.getTotal(10,20,30);
		for(int k=0; k<result.length; k++) {
			System.out.println(result[k]);
		}
		
		total = sub.getTotal(point,result);
		System.out.println(total);
		
		
		
		
		
	}
}
