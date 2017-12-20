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

			// DFS 로직 구성
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

		// 방금 이동해서 도착한 지점 체크
		if (day <= M) {
			if (pointInfo[0][nowPoint] == H) {
				day++;
				nowTime = 0;
			}
			visit[nowPoint] = true;
		}
		tempQ.add(nowPoint);
		// 종료조건 : 마지막날(M) 공항도착하면 M+1일 됨
		if (day == M + 1) {
			if (nowSatisfy > maxSatisfy) {
				maxSatisfy = nowSatisfy;
				q = tempQ;
			}
			return;
		}

		// M-1일차 때 공항 X,
		// M일차때만 공항 접근 가능
		int moveTime=0;
		for (int nextP = 1; nextP <= N; nextP++) {
			// 지점 놀러가기
			moveTime=nowTime + timeTb[nowPoint][nextP];
			if (moveTime <= 540) {
				// 마지막날 아니고 지점 가는 것
				if (pointInfo[0][nextP] == P && day <= M && !visit[nextP] && moveTime+pointInfo[1][nextP]<540)
					dfs(nextP, nowSatisfy + pointInfo[2][nextP], moveTime + pointInfo[1][nextP], visit, day, visitNum + 1, tempQ);

				// 숙소 들어가기
				if (pointInfo[0][nextP] == H && day < M)
					dfs(nextP, nowSatisfy, moveTime, visit, day, visitNum + 1, tempQ);

				// 마지막날 공항가기
				if (pointInfo[0][nextP] == A && day == M)
					dfs(nextP, nowSatisfy, moveTime, visit, day + 1, visitNum + 1, tempQ);
			}
		}
	}
}