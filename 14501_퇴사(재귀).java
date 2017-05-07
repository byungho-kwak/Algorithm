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
		
		// �湮 ���� �Ǵ� ó�� ������ �ʰ� Ȯ��
		if(day > N ) {
			if(paySum > MAX)
				MAX = paySum;
			return;
		}
		
		if(T[day]+day-1 <= N) {
			// ���� ��¥ ��� ��
			BFS(T[day]+day, paySum+P[day]);
		}
		
		//if(day+1 <= N){  
			// *****�Ǽ��� �κ� (������ N ��谪 �����ϴµ� ��������� ���� ���� ���� ******
			// ex) day = 7�� ���, day+1 <=7 ����X
			// ����, day 7�� P7 paySum�� �߰����� ����
			// ��, ù ��° �Ǻ������� day > N�� ��찡 ������ ���Ͽ� MAX ���� ����
			
		// ���� ��¥ ��� ����
		BFS(day+1, paySum);
	//	}
		
	}

}