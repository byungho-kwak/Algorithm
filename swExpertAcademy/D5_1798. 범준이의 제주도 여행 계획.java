import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] timeTb;
	static final int A = 1, P = 2, H = 3;
	static int[][] pointInfo;
	static int maxSatisfy;
	static int[] visitOrder;
	static ArrayList q;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			maxSatisfy = 0;
			N = sc.nextInt();
			M = sc.nextInt();

			timeTb = new int[N + 1][N + 1];
			pointInfo = new int[3][N + 1];

			for (int i = 1; i <= N - 1; i++) {
				for (int j = i + 1; j <= N; j++) {
					timeTb[i][j] = sc.nextInt();
					timeTb[j][i] = timeTb[i][j];
				}
			}

			String p;
			for (int i = 1; i <= N; i++) {
				p = sc.next();
				if (p.equals("A"))
					pointInfo[0][i] = A;
				else if (p.equals("H"))
					pointInfo[0][i] = H;
				else {
					pointInfo[0][i] = P;
					pointInfo[1][i] = sc.nextInt();
					pointInfo[2][i] = sc.nextInt();
				}
			}

			// DFS ���� ����
			boolean[] vCheck = new boolean[N + 1];
			q = new ArrayList<Integer>();
			
			dfs(1, 0, 0, vCheck, 1, 0, q);
			
			System.out.print("#" + test_case + " " + maxSatisfy+" ");
			for(int i=1; i<q.size(); i++)
				System.out.print(q.get(i)+" ");
			System.out.println();
		}
	}

	static void dfs(int nowPoint, int nowSatisfy, int nowTime, boolean[] b_visit, int day, int visitNum, ArrayList queue) {
		boolean[] visit = Arrays.copyOf(b_visit, N+1);
		ArrayList tempQ = new ArrayList<Integer>();
		if(!queue.isEmpty()) {
			for(int i=0; i<queue.size(); i++)
				tempQ.add(queue.get(i));
		}

		// ��� �̵��ؼ� ������ ���� üũ
		if (day <= M) {
			if (pointInfo[0][nowPoint] == H) {
				day++;
				nowTime = 0;
			}
			visit[nowPoint] = true;
		}
		tempQ.add(nowPoint);
		// �������� : ��������(M) ���׵����ϸ� M+1�� ��
		if (day == M + 1) {
			if (nowSatisfy > maxSatisfy) {
				maxSatisfy = nowSatisfy;
				q = tempQ;
			}
			return;
		}

		// M-1���� �� ���� X,
		// M�������� ���� ���� ����
		int moveTime=0;
		for (int nextP = 1; nextP <= N; nextP++) {
			// ���� �����
			moveTime=nowTime + timeTb[nowPoint][nextP];
			if (moveTime <= 540) {
				// �������� �ƴϰ� ���� ���� ��
				if (pointInfo[0][nextP] == P && day <= M && !visit[nextP] && moveTime+pointInfo[1][nextP]<540)
					dfs(nextP, nowSatisfy + pointInfo[2][nextP], moveTime + pointInfo[1][nextP], visit, day, visitNum + 1, tempQ);

				// ���� ����
				if (pointInfo[0][nextP] == H && day < M)
					dfs(nextP, nowSatisfy, moveTime, visit, day, visitNum + 1, tempQ);

				// �������� ���װ���
				if (pointInfo[0][nextP] == A && day == M)
					dfs(nextP, nowSatisfy, moveTime, visit, day + 1, visitNum + 1, tempQ);
			}
		}
	}
}