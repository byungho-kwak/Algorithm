import java.util.Scanner;

public class Main {
	static final int INF = 2000000000;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		int left = 0;
		int right = N-1;
		int min=INF;
		int ansLeft=0;
		int ansRight=0;
		
		while(left<right) {
			if(min>Math.abs(arr[left]+arr[right])) {
				min = Math.abs(arr[left]+arr[right]);
				ansLeft=left;
				ansRight=right;
			}
			if(arr[left]+arr[right]<0)
				left++;
			else
				right--;  
		}
		
		System.out.println(ansLeft+" "+ansRight);
	}
}