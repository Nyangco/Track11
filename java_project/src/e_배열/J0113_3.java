package e_배열;

public class J0113_3 {

	public static void main(String[] args) {
		
		int[] arr = {12,45,14,75,86,49,12,56,45,85,23,
					62,45,78,95,45,26,78,64,68,54,55,85};
		int total = 0, total2 = 0;
		
		for(int k=0; k<arr.length ; k++) {
			total+=arr[k];
		}
		System.out.println(total);
		
		total = 0;
		for(int k=0; k<arr.length; k++) {
			if(arr[k]<50) {
				total++;
				total2+=arr[k];
			}
		}
		System.out.println(total);
		System.out.println(total2);
	}
}
