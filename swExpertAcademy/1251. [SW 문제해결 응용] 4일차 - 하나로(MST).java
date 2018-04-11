/*
 * 1251. [S/W �����ذ� ����] 4���� - �ϳ���
 * ���� : MST(�ּҺ�����Ʈ��)
 * ���� : prim �˰���
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
			
			// ��尣�� ���� ����ġ ���
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					double len = Math.pow(x[i]-x[j], 2);
					len += Math.pow(y[i]-y[j], 2);
					map[i][j]=Math.sqrt(len);
					map[j][i] = map[i][j];
				}
			}
			
			// 1ȸ�� ���ο� ��� 1���� �߰� �ǹǷ�, ó�� ���õ� ��� ������ ��� ������ŭ
			// for �� ������ ��� ��� ���õ�
			for(int k=1; k<N; k++) {
				// �湮�ߴ� ��� �� ���� ����ġ ������ ���� ã��
				double minWeight = INF;
				int minVertex=0;
				
				for(int i=0; i<N; i++) {
					// �湮 ���ߴ� ���� skip
					if(weight[i]<0) continue;
					for(int j=0; j<N; j++) {
						// �湮 �ߴ� ���(i)���� �� �湮 �� �� ���� ���(j)�� ���� ���� ����ġ �ּҰ� ���ϱ�
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

