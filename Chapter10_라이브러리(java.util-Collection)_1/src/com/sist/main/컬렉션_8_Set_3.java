package com.sist.main;

import java.util.Random;
import java.util.TreeSet;


//제네릭 => Collection 전체 사용이 가능
//LIst / Set / Map
/*
 * List <String> => ArrayList (Vector,LinkedList)
 * Set<String> => HashSet / TreeSet
 *      => add()
 *      => addAll() => 다른 collection 데이터를 첨부
 *      => clear()
 *      => isEmpty()
 *      => size()
 *      => iterator()
 *      
 * Map<String,String> => HashMap / Hashtable
 *                                      ---------    ------------
 *                                       비동기          비동기
 *                                       ㅣ                   ㅣ
 *                                       속도               안정성 => 
 */
public class 컬렉션_8_Set_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> set = new TreeSet<Integer>();
		Random r = new Random();
		for(int i=0;i<10;i++) {
			set.add(r.nextInt(101));//0~100
		}
		//출력
		System.out.println(set.size());
		for(int i : set) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("===== 60점 이하 =====");
		System.out.println(set.headSet(60));
		System.out.println("===== 60점 이상 =====");
		System.out.println(set.tailSet(60));
	}

}
