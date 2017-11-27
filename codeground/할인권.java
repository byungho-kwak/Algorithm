import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int Answer;
	static int[][] MAP;
	static int N;
	static int INF = 1000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			Answer=0;

			N = sc.nextInt(); // 정거장 수
			int M = sc.nextInt(); // 철로 수
			int K = sc.nextInt(); // 할인권 비용
		
			MAP = new int[N + 1][N + 1];
			// MAP 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						MAP[i][j] = 0;
					else
						MAP[i][j] = INF;
				}
			}
			
			int s;	// start
			int e;	// end
			int v;	// value
			
			//정거장(s) -> 정거장(e)에 대한 비용(v)
			for(int i=1; i<=M; i++) {
				s=sc.nextInt();
				e=sc.nextInt();
				v=sc.nextInt();
				
				MAP[s][e] = v;
				MAP[e][s] = v;
			}
			
			// 여행계획 경로수 및 경로 입력
			int tripPathNum = sc.nextInt();
			int[][] tripPath = new int[tripPathNum+1][3];
			
			for(int i=1; i<=tripPathNum; i++)
				for(int j=1; j<=2; j++)
					tripPath[i][j] = sc.nextInt();

			int temp = 0;
			
			for(int transter=1; transter<=N; transter++) {
				for(int start=1; start<=N; start++) {
					for(int end=1; end<=N; end++) {
						temp = MAP[start][transter] + MAP[transter][end];
						if(MAP[start][end] > temp)
							MAP[start][end]=temp;
					}
				}
			}
			
//			for (int start = 1; start <= N; start++) {
//				for (int end = 1; end <= N; end++) {
//					if (MAP[start][end] == -1) {
//						temp = find(start, end);
//						if (min > temp) {
//							min = temp;
//							MAP[start][end] = min;
//							MAP[end][start] = min;
//						}
//						min = 100000;
//					}
//				}
//			}
			
			for(int i=1; i<=tripPathNum; i++) {
				if(MAP[tripPath[i][1]][tripPath[i][2]] > K)
					Answer++;
			}
			
			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
			
			}
		}
	
/*	static int find(int start, int end) {
		int value=100000;
		int temp;
		
		if(MAP[start][end]>0)
			return MAP[start][end];
		
		for (int transter = 1; transter <= N; transter++) {
			if((start!=transter) && (transter!=end) && MAP[transter][end]>0) {
				temp = find(start, transter) + find(transter, end);
				if (value > temp) 
					value=temp;
			}
		}
		return value;
	}*/

}
