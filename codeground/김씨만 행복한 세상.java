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
			
			// �켱���� ť�� �̿��Ͽ� x -> y �� �ִ��� ���������� ǥ�� �� �� �ֵ��� �Ѵ�.
			PriorityQueue<Point> pq = new PriorityQueue(cmp);
			
			int areaNum = sc.nextInt();
			int ajArea = sc.nextInt();
			
			int[] check = new int[areaNum+1];
			Arrays.fill(check, 0);
			
			for(int i=1; i<=ajArea; i++) {
				pq.add(new Point(sc.nextInt(), sc.nextInt()));
			}
			
			int	x,y;
			
			
			// check[x]�� ǥ��Ǿ� �ִ� �Ͱ� �ݴ��� ���������ڸ� check[y]�� ǥ�� (A->B, B->A)
			while(!pq.isEmpty()) {
				x=pq.peek().x;
				y=pq.peek().y;
				pq.poll();
				
				if(check[x]==0) {
					check[x]=A;
					check[y]=B;
				}
				else if(check[x]==check[y]) {
					// ���� ������ ���� ������ ǥ�� �Ǿ� �ִٸ� 0
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