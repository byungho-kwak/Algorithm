/*
 * 2383. [���� SW �����׽�Ʈ] ���� �Ļ�ð�
 * ���� : ��Ʈ����ũ + ����Ž��
 */
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int[][] map, Dist;
	static int[] k, kx, ky, x, y;
	static int ans;
	static LinkedList<Integer> move;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			map = new int[N][N];
			ans=999999999;
			
			k = new int[2];
			kx = new int[2];
			ky = new int[2];
			x = new int[10];
			y= new int[10];
			
			move = new LinkedList<>();
			
			int peopleCnt=0, kCnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int tmp = sc.nextInt();
					if(tmp==1) {
						x[peopleCnt] = i;
						y[peopleCnt++] = j;
					}
					if(tmp>1) {
						k[kCnt] = tmp;
						kx[kCnt] = i;
						ky[kCnt++] = j;
					}
				}
			}
			Dist = new int[2][peopleCnt];
			
			for(int i=0; i<peopleCnt; i++) {
				Dist[0][i] = Math.abs(x[i]-kx[0]) + Math.abs(y[i]-ky[0]);
				Dist[1][i] = Math.abs(x[i]-kx[1]) + Math.abs(y[i]-ky[1]);
			}
			
			int choice = 0;
			
			while(choice <= (1<<peopleCnt)-1) {
				for(int i=0; i<peopleCnt; i++) {
					if(((choice>>i)&1) == 1) {
						move.add(Dist[0][i]);
					}
				}
				
				int timeA = moveCal(k[0]);
				
				for(int i=0; i<peopleCnt; i++) {
					// 000110 ���� �� ���� 111001 ��Ʈ����ũ�� ǥ�� 
					// 111111 xor(^) 000110 = 111001
					if((((((1<<peopleCnt)-1)^choice)>>i)&1) == 1) {
						move.add(Dist[1][i]);
					}
				}
				
				int timeB = moveCal(k[1]);
				
				if(ans>Math.max(timeA, timeB))
					ans = Math.max(timeA, timeB);
				
				choice++;
			}
			
			System.out.println("#"+t+" "+ans);
			
		}
	}
	static int moveCal(int k) {
		LinkedList<Integer> q = new LinkedList<>();
		int time=0;
		
		while(!move.isEmpty() || !q.isEmpty()) {
			int StairCnt=0;;
			// �� �̵� 
			if(!move.isEmpty()) {
				for(int i=0; i<move.size(); i++) {
					move.set(i, move.get(i)-1);
					if(move.get(i)<=-1) {
						StairCnt++;
					}
				}
			}
			
			// ��� ��������
			if(!q.isEmpty()) {
				for(int i=0; i<q.size(); i++) {
					q.set(i, q.get(i)-1);
					if(Math.abs(q.get(i))==k) {
						// poll�� �ϸ� ���� ���ڰ� ���� ��ġ�� �̵��ϴµ� i++�� �Ǹ� ���� ���� Ȯ�� ���� ����,
						// poll �ϰ� �ε����� �������Ѿ��ϱ� ������ i-- ������ 
						q.poll();
						i--;
					}
				}
			}
			
			//��ܿ� �ֱ�
			for(int i=0; i<move.size(); i++) {
				if(q.size()<3 && move.get(i)<=-1) {
					q.add(0);
					// remove�� �ϸ� ���� ���ڰ� ���� ��ġ�� �̵��ϴµ� i++�� �Ǹ� ���� ���� Ȯ�� ���� ����,
					// remove �ϰ� �ε����� �������Ѿ��ϱ� ������ i-- ������
					move.remove(i);
					i--;
					StairCnt--;
					if(StairCnt==0)
						break;
				}
			}
			time++;
		}
		return time;
	}
}

