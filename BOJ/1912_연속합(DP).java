import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] input = new int[100001];
	static int[] DP = new int[100001];
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++)
			input[i] = sc.nextInt();
		
		Arrays.fill(DP, 0);
		
		DP[1] = input[1];
		// DP �� �� �ִ� �� �����ϱ�
		int max = DP[1];
		
		for(int i=2; i<=N; i++) {
			// ���� �ε��� �� ���� �������� �������� �ִ� ���ϱ�
			// now �ε��� �� ��ü vs now �ε��� �� ��ü + now-1 �ε��� ���� ������ �ִ�(DP[now-1]) 
			
			DP[i] =  Math.max(input[i], input[i]+DP[i-1]);
			
			if(DP[i] > max)
				max = DP[i];
		}

		System.out.println(max);
	}

}
