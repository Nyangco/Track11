package g_생성자;

public class J0131_2 {

	public static void main(String[] args) {

		J0131_1_dao dao = new J0131_1_dao();
		J0131_1_dto[] arr = new J0131_1_dto[3];
		
		System.out.println(arr.length);
		
		J0131_1_dto dto_0 = new J0131_1_dto();
		arr[0]=dto_0;
		J0131_1_dto dto_1 = new J0131_1_dto("김개똥",90,80,70);
		arr[1]=dto_1;
		J0131_1_dto dto_2 = new J0131_1_dto("홍길동",70,80,90);
		arr[2]=dto_2;
		System.out.println(arr[0].name+" : "+arr[1].name);
		
		for(int k=0; k<arr.length; k++) {
			System.out.println(arr[k].getName());
			dao.setTotal(arr[k]);			
			System.out.println(arr[k].getTotal());
			dao.setAve(arr[k]);
			System.out.println(arr[k].getAve());
		}
		
	}
}
