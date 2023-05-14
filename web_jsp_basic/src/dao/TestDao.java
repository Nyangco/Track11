package dao;

import java.util.ArrayList;

import dto.TestDto;

public class TestDao {
	 public int getTotal(int a, int b) {
		 
		 return a+b;
	 }
	 public ArrayList<TestDto> getList(){
		 ArrayList<TestDto> arr = new ArrayList<>();
		 
		 TestDto dto1 = new TestDto("이상민","서울",25);
		 TestDto dto2 = new TestDto("박사율","부산",26);
		 
		 arr.add(dto1);
		 arr.add(dto2);
		 return arr;
	 }
}
