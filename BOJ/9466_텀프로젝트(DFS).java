import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static final int YES = 1;
	static final int NO = 0;
	static final int UNKOWN= 2;
	static int Answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
	
		for(int testcase=0; testcase<TC; testcase++) {
			Answer=0;
			int num = sc.nextInt();
			
			int[] choice = new int[num+1];
			boolean[] visit = new boolean[num+1];
			int[] circle = new int[num+1];
			
			Arrays.fill(visit, false);
			Arrays.fill(circle, UNKOWN);
			
			for(int i=1; i<=num; i++)
				choice[i] = sc.nextInt();
			
			int now, next;
			Stack<Integer> s = new Stack();
			
			for(int i=1; i<=num; i++) {
				now=i;
				if(!visit[now]) {
					while(!visit[now]) {
						next=choice[now];
						s.push(now);
						visit[now]=true;
						now=next;
					}
					// ��ȸ ���� ��
					int circleStart=now;
					
					//��ȸ �Ǵ� �κ� ��ȸ üũ
					if(circleStart == s.peek()) 
						circle[s.pop()]=YES;
					else if(circle[circleStart]==UNKOWN) {
						
						while(!s.isEmpty() && s.peek()!=circleStart) 
							circle[s.pop()]=YES;
						// ��ȸ ���� idx pop
						if(circleStart == s.peek())
							circle[s.pop()]=YES;
					}
					// ��ȸ �ȵǴ� �� �ȵȴٰ� üũ
					while(!s.isEmpty())
						circle[s.pop()]=NO;
				}
			}
			
			for(int i=1; i<=num; i++){
				if(circle[i]==NO)
					Answer++;
			}
			System.out.println(Answer);
			
		}
	}
}
