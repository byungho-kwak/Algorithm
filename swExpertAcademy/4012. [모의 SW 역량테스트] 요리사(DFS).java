/*
 * 4012. [���� SW �����׽�Ʈ] �丮��
 * ���� : dfs(����Ž��) + ��Ʈ����ũ Ȱ��
 */

import java.util.Scanner;

public class Main {
	static int[][] map;
	static int N, ans;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			ans=244444444;
			N = sc.nextInt();
			map=new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// ��� üũ ��Ʈ����ũ, ��� ��� ����, ��� üũ�Ϸ��� ���� �ε���
			dfs(0, 0, 0);
			System.out.println("#"+t+" "+ans);
		}
	}
	static void dfs(int visited, int cnt, int idx) {
		// N/2�� ��� üũ �� �Ǿ��ٸ�
		if(cnt==N/2) {
			// visite : üũ�� ����
			// ~visited : üũ���� ���� ����
			if(ans>Math.abs(calc(visited) - calc(~visited)))
				ans = Math.abs(calc(visited) - calc(~visited));
			return;
		}
		// N/2�� �ڷ� ����� �ȵǾ�����, ��� Ȯ�� �ε����� ������ �� ��� 
		if(idx==N)
			return;
		
		// ���� idx�� ��Ḧ ����ϴ� ���
		dfs((1<<idx+1)|visited, cnt+1, idx+1);
		// ���� idx�� ��Ḧ ������� �ʴ� ���
		dfs(visited, cnt, idx+1);
	}
	
	static int calc(int visited) {
		int taste=0;
		// ���� ��ῡ ���ؼ� �ó��� �� ���ϱ�
		for(int i=1; i<N; i++) {
			if(((visited>>i)&1)==1) {
				for(int j=i+1; j<=N; j++) {
					if(((visited>>j)&1)==1) {
						taste+=map[i][j]+map[j][i];
					}
				}
			}
		}
		return taste;
	}
}

