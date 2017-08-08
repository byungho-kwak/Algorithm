import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] input = new int[51];
		
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++)
			input[i] = sc.nextInt();
		
		int temp;
		
		for(int i=N; i>=1; i--) {
			for(int j=1; j<i; j++) {
				if(input[j] < input[j+1]) {
					temp = input[j+1];
					input[j+1] = input[j];
					input[j] = temp;
				}
			}
		}
		
		System.out.println(input[1]*input[N]);
		
	
	}
}
