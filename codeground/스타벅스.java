import java.util.Scanner;

public class Main {
	
	static int TC;
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			int N = sc.nextInt();	// 사람 수
			int M = sc.nextInt();	// 커피 종류
			int K = sc.nextInt();	// 사용 한도
			
			int[] orderNum = new int[N+1];
			int[] coffeePrice = new int[M+1];
			
			for(int i=1; i<=N; i++)
				orderNum[i] = sc.nextInt();
			
			for(int i=1; i<=M; i++)
				coffeePrice[i] = sc.nextInt();
			
			
			for(int i=1; i<=N; i++)
				Answer+=coffeePrice[orderNum[i]];
			
			System.out.println("Case #"+(test_case+1));
			
			if(Answer > K)
				System.out.println("N");
			else
				System.out.println("Y");

		}
	}
}
