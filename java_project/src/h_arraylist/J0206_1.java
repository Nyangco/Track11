package h_arraylist;

import java.util.ArrayList;

public class J0206_1 {

	public static void main(String[] args) {
//		때에 따라서 길이가 줄어들고 늘어날 수 있는 배열
		
		
		ArrayList<String> arr = new ArrayList<>();
//		유연한 배열이라고 해도 변수의 타입은 잡아줘야 한다.
//		ArrayList 도  Scanner 과 마찬가지로 Java.Util Package 안의 Class 이다 -> 사용하려면 import 과정을 거쳐야 한다.
		arr.add("가");
//		ArrayList에서 값을 추가하고자 할 땐 add method를 사용한다.
		arr.add("나");
		arr.add("다");
		System.out.println(arr.size());
//		ArrayList의 size method는 일반 배열의 length method에 필적한다.
		
		System.out.println(arr.get(2));
//		ArrayList에서 값을 꺼낼 땐 get method를 사용한다.
		
		arr.add(3,"라");
		arr.add(1,"마");
//		직접 순서를 지정해줄 수도 있다. 앞의 정수 순서에 끼워넣는 방식으로 작동한다.

		System.out.println();
		for(int k=0; k<arr.size(); k++) {
			System.out.println(arr.get(k));
		}
		
		System.out.println();
		arr.set(0, "다");
//		set method는 해당 index의 값을 뒤의 값으로 수정한다.
		for(int k=0; k<arr.size(); k++) {
			System.out.println(arr.get(k));
		}
		
		System.out.println();
		arr.remove("다");
//		remove method는 특정 object를 인식해서 삭제할 수도 있고, 혹은 특정 index의 값을 삭제할 수도 있다.
		for(int k=0; k<arr.size(); k++) {
			System.out.println(arr.get(k));
		}
		
		arr.remove(0);
		
		arr.remove(arr.size()-1);
		System.out.println();
		for(int k=0; k<arr.size(); k++) {
			System.out.println(arr.get(k));
		}
		
		ArrayList<Integer> in = new ArrayList<>();
//		ArrayList의 type은 기본형 사용 불가 - Integer 라는 대표 class type으로 사용해야 한다.
//		Byte Short Integer Long / Float Double / Boolean / Character
		
		in.add(10);
		in.add(20);
		in.add(30);
		for(int k=0; k<in.size(); k++) {
			System.out.println(in.get(k));
		}
		
		
	}
}
