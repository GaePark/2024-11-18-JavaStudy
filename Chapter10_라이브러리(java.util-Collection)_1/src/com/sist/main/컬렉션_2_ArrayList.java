package com.sist.main;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

//@EqualsAndHashCode
// Equals / HashCode => 재정의
@Data
//@Getter
//@Setter
class Sawon
{
	private int sabun;
	private String name, dept;
	
	public Sawon(int sabun, String name, String dept) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
	}
	
}
public class 컬렉션_2_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon s1 = new Sawon(1, "홍길동", "개발부");
		Sawon s2 = new Sawon(1, "홍길동", "개발부");
		
		if(s1.equals(s2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

	}

}
