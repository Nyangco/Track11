package j_package_main;

import j_package_a.Pack_aa;
import j_package_b.Pack_bb;
//다른 package의 class 파일이니, 별도로 import 과정을 거쳐야한다.

public class J0208_1 {

	public static void main(String[] args) {
		Pack_aa aa = new Pack_aa();
		aa.setPrint();
//		default 접근제한자는 다른 package에선 불러올 수 없다 ( 오직 같은 package에서만 사용가능 )
//		public 접근제한자는 다른 package에서도 import과정을 통해 사용하게끔 한다.
		Pack_bb bb = new Pack_bb();
		
		
		
	}
}
