import java.awt.Point;
import java.util.*;
import java.util.Arrays;

public class Test {  
	
	static int N;
	static int [] T = new int [16];
	static int [] P = new int [16];
	static int MAX = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		BFS(1, 0);
		
		System.out.println(MAX);
	}
	
	static void BFS(int day, int paySum) {
		
		// 방문 일자 또는 처리 가능일 초과 확인
		if(day > N ) {
			if(paySum > MAX)
				MAX = paySum;
			return;
		}
		
		if(T[day]+day-1 <= N) {
			// 현재 날짜 상담 함
			BFS(T[day]+day, paySum+P[day]);
		}
		
		//if(day+1 <= N){  
			// *****실수한 부분 (윗쪽의 N 경계값 조사하는데 이중조사로 인한 뎁스 부족 ******
			// ex) day = 7일 경우, day+1 <=7 만족X
			// 따라서, day 7의 P7 paySum에 추가하지 못함
			// 즉, 첫 번째 판별조건인 day > N인 경우가 나오지 못하여 MAX 도출 못함
			
		// 현재 날짜 상담 안함
		BFS(day+1, paySum);
	//	}
		
	}

}