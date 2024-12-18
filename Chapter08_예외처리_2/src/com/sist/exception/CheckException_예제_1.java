package com.sist.exception;

public class CheckException_예제_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] lotto = new int[6];
			
			for(int i = 0;i<lotto.length;i++) {
				lotto[i] = (int)(Math.random()*45)+1;
				for(int j =0; j<i;j++) {
					if(lotto[i]==lotto[j]) {
						i--;
						break;
					}
				}
			}
			
			for(int i :lotto) {
				System.out.print(i + " ");
				Thread.sleep(1000);
			}
			
		}catch (InterruptedException e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			System.out.println("프로그램 종료");
		}

		
	}

}
