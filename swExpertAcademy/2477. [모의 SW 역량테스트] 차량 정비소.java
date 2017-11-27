import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int Answer=0;
			
			Queue<Integer> q = new LinkedList<>();
			
			int N = sc.nextInt(); // ����â�� ��
			int M = sc.nextInt(); // ����â�� ��
			int k = sc.nextInt(); // �湮�� ��
			int a = sc.nextInt(); // ã���� �ϴ� ����â��
			int b = sc.nextInt(); // ã���� �ϴ� ����â��
			
			int[][] reception = new int[3][N+1];
			int[][] repair = new int[3][M+1];
			int[] A = new int[N+1];
			int[] B = new int[M+1];
			int[] K = new int[k+1];
			boolean[][] visit = new boolean[3][k+1];
			
			for(int i=1; i<=N; i++)
				A[i] = sc.nextInt();
			for(int i=1; i<=M; i++)
				B[i] = sc.nextInt();
			for(int i=1; i<=k; i++)
				K[i] = sc.nextInt();
			
			int kIdx = 1;
			int i=0;
			
			// ��ü�ð� 1��(i)�� ���̳ʽ�
			while(i<5000) {
				
				// reception 1�ʾ� ���̱�
				for(int j=1; j<=N; j++) {
					
					if(reception[2][j]==0 && kIdx<=K.length-1 && K[kIdx]<=i) {
						reception[1][j]=kIdx;
						reception[2][j]=A[j];
						if(j==a)
							visit[1][reception[1][j]]=true;
						kIdx++;
					}
					else if(reception[2][j]>0) {
						reception[2][j]--;
						// 0 ���� �� repair ť�� �ѱ��, ���ڸ� ä���
						if(reception[2][j]==0) {
							q.add(reception[1][j]);
							//���ڸ� ä��� �� �ð�ä���
							if(kIdx<=K.length-1 && K[kIdx]<=i) {
								reception[1][j]=kIdx;
								reception[2][j]=A[j];
								kIdx++;
								if(j==a)
									visit[1][reception[1][j]]=true;
							}
						}
					}
				}
				// repair 1�ʾ� ���̱�
				for(int j=1; j<=M; j++) {
					if(repair[2][j]>0) 
						repair[2][j]--;
					
					if(repair[2][j]==0 && !q.isEmpty()) {
						repair[1][j]=q.poll();
						repair[2][j]=B[j];
						if(j==b)
							visit[2][repair[1][j]]=true;
					}
				}
				
				i++;
			}
			
			for(int j=1; j<=k; j++) {
				if(visit[1][j] && visit[2][j])
					Answer+=j;
			}
			
			if(Answer==0)
				Answer=-1;
			
			System.out.println("#"+(t+1)+" "+Answer);
		}
	}
}
