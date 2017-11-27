import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		Arrays.fill(a, 0);
		a[0]=1;
		for(int i=3; i<=n; i+=3)
			a[i]=i/3;
		for(int i=5; i<=n; i++) {
			if(i%5==0)
				a[i]=i/5;
			else{
				if(a[i-5]>0)
					a[i]=a[i-5]+1;
			}
		}
		if(a[n]==0)
			a[n]=-1;
		System.out.println(a[n]);
	}
}
