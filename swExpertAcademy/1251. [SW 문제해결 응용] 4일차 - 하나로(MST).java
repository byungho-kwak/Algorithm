/*
 * 1251. [S/W 문제해결 응용] 4일차 - 하나로
 * 유형 : MST(최소비용신장트리)
 * 접근 : prim 알고리즘
 */


import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final double INF = 299999999;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] x = new int[N];
			int[] y = new int[N];
			double [] weight = new double[N];
			double[][] map = new double[N][N];
			
			Arrays.fill(weight, -1);
			weight[0]=0;
			
			for(int i=0; i<N; i++)
				x[i] = sc.nextInt();
			for(int i=0; i<N; i++)
				y[i] = sc.nextInt();
			
			double E = sc.nextDouble();
			
			// 노드간의 간선 가중치 계산
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					double len = Math.pow(x[i]-x[j], 2);
					len += Math.pow(y[i]-y[j], 2);
					map[i][j]=Math.sqrt(len);
					map[j][i] = map[i][j];
				}
			}
			
			// 1회당 새로운 노드 1개씩 추가 되므로, 처음 선택된 노드 제외한 노드 갯수만큼
			// for 문 돌리면 모든 노드 선택됨
			for(int k=1; k<N; k++) {
				// 방문했던 노드 중 간선 가중치 최저인 간선 찾기
				double minWeight = INF;
				int minVertex=0;
				
				for(int i=0; i<N; i++) {
					// 방문 안했던 노드는 skip
					if(weight[i]<0) continue;
					for(int j=0; j<N; j++) {
						// 방문 했던 노드(i)에서 → 방문 한 적 없는 노드(j)로 가는 간선 가중치 최소값 구하기
						if(weight[j]>=0) continue;
						if(minWeight>map[i][j]) { 
							minWeight = map[i][j];
							minVertex = j;
						}
					}
				}
				weight[minVertex] = minWeight;
			}
			double sumCost = 0;
			for(int i=0; i<N; i++) sumCost+=weight[i]*weight[i];
			System.out.print("#"+t);
			System.out.print(" "+String.format("%.0f",E*sumCost));
			System.out.println();
		}
	}
}

