import java.awt.Point;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int arr[], N;
	
	public static void main(String... msg) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int t=1; t<=testcase; t++) {
			N = sc.nextInt();
			arr = new int[N];
			PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					return o1.y>o2.y?-1:1;
				}
			});
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				q.add(new Point(i,arr[i]));
			}
			long ans=0;
			int idx=0;
			while(!q.isEmpty() && idx<N) {
				Point p = q.poll();
				if(arr[idx] <= p.y) {
					for(; idx<=p.x; idx++) {
						ans+=p.y-arr[idx];
					}
				}
			}
			System.out.println(ans);
		}
	}
}
