import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] map = new boolean[400001];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(map, false);
		int ans=0;
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		for(int i=1; i<N; i++) {
			for(int j=i-1; j>=0; j--){
				map[arr[i-1]+arr[j]+200000]=true;
			}
			
			for(int k=0; k<i; k++) {
				if(map[arr[i]-arr[k]+200000]) { 
					
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}