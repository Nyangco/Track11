package e_배열;

public class J0113_4 {

	public static void main(String[] args) {
		int[] arr = {112,435,124,755,866,439,112,536,445,857,263,622,425,378,495,745,
					926,378,464,568,594,555,855,454,874,512,125,545,118,564};
		int evenNum = 0, oddSum = 0;
		
		for(int k=0; k<arr.length; k++) {
			if(arr[k]%2==0) evenNum++;
			if(arr[k]%2==1) oddSum+=arr[k];
		}
		
		System.out.println(evenNum);
		System.out.println(oddSum);
		
		
	}
}
