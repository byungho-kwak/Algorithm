import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] check = new boolean[10001];
		boolean first = false;
		int firstNum=0;
		Arrays.fill(check, false);
		
		for(int i=1; i<=100; i++) 
			check[i*i]=true;
		
		for(int i=M; i<=N; i++) {
			if(check[i]) {
				sum+=i;
				if(!first) {
					firstNum=i;
					first=true;
				}
			}
		}
		
		if(sum==0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(firstNum);
		}
	}	
}
