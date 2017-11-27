import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
	static int Answer;
	static final int A=1;
	static final int B=2;
	
	static class compare implements Comparator<Point> {
		@Override
		public int compare(Point o1, Point o2) {

			return Integer.compare(o1.x, o2.x);
		}
	}
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer=1;
			compare cmp = new compare();
			
			// 우선순위 큐를 이용하여 x -> y 가 최대한 연쇄적으로 표기 될 수 있도록 한다.
			PriorityQueue<Point> pq = new PriorityQueue(cmp);
			
			int areaNum = sc.nextInt();
			int ajArea = sc.nextInt();
			
			int[] check = new int[areaNum+1];
			Arrays.fill(check, 0);
			
			for(int i=1; i<=ajArea; i++) {
				pq.add(new Point(sc.nextInt(), sc.nextInt()));
			}
			
			int	x,y;
			
			
			// check[x]에 표기되어 있는 것과 반대의 지역관리자를 check[y]에 표기 (A->B, B->A)
			while(!pq.isEmpty()) {
				x=pq.peek().x;
				y=pq.peek().y;
				pq.poll();
				
				if(check[x]==0) {
					check[x]=A;
					check[y]=B;
				}
				else if(check[x]==check[y]) {
					// 인접 지역에 동일 관리자 표기 되어 있다면 0
					Answer=0;
					break;
				}
				else {
					if(check[x]==A)
						check[y]=B;
					else
						check[y]=A;
				}
			}
	
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}