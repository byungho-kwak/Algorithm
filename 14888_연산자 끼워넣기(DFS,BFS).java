import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static final int INF = 1000000000;
	static int max=-INF;
	static int min=INF;
	static int[] a;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		a = new int[N];
		int[] cal = new int[4];
		for(int i=0; i<N; i++)
			a[i] = sc.nextInt();
		for(int i=0; i<4; i++)
			cal[i] = sc.nextInt();

		Cal(a[0], 1, cal);
		
		System.out.println(max);
		System.out.println(min);
    }

	static void Cal(int nowTotal, int idx, int[] cal) {
		int[] nowCal;
		if(idx==a.length) {
			if(min>nowTotal) 
				min=nowTotal;
			if(max<nowTotal)
				max=nowTotal;
			return;
		}

		if(cal[0]>0) {
			nowCal = Arrays.copyOf(cal, 4);
			nowCal[0]-=1;
			Cal(nowTotal+a[idx], idx+1, nowCal);
		}
		if(cal[1]>0) {
			nowCal = Arrays.copyOf(cal, 4);
			nowCal[1]-=1;
			Cal(nowTotal-a[idx], idx+1, nowCal);
		}
		if(cal[2]>0) {
			nowCal = Arrays.copyOf(cal, 4);
			nowCal[2]-=1;
			Cal(nowTotal*a[idx], idx+1, nowCal);
		}
		if(cal[3]>0) {
			nowCal = Arrays.copyOf(cal, 4);
			nowCal[3]-=1;
			int temp=Math.abs(nowTotal)/a[idx];
			if(nowTotal<0) 
				temp=temp*(-1);
			Cal(temp, idx+1, nowCal);
		}
	}
}
