/*
 		배열 복사
 		 = 옅은 복사 (Call By Reference) => 주소에 의한 참조
 		                 => 같은 메모리를 이용한다
 		 = 깊은 복사 => 새로운 배열 생성 (메모리 공간이 따로 생성)
 */
public class 배열정리_추가내용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,30,40,50};
		int[] arr_copy=arr.clone();
		
		System.out.println("arr:"+arr);
		System.out.println("arr_copy:"+arr_copy);
		arr_copy[0] = 100;
		arr_copy[1] = 200;
		arr_copy[2] = 300;
		for(int i : arr)
			System.out.print(i + " ");
	}

}
