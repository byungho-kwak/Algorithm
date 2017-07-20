import java.util.Scanner;

public class Main {

	static int [] DP = new int [12];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int TC = sc.nextInt();
		int[] N = new int[TC+1];
		
		for(int i=1; i<=TC; i++)
			N[i] = sc.nextInt();
		
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
		
		for(int i=4; i<=11; i++)
			DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
		
		for(int i=1; i<=TC; i++)
			System.out.println(DP[N[i]]);
		
	}
}
