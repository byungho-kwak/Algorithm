import java.util.Scanner;

public class Main {
	static int N;
	static int[][] Graph;
	static int[][] memo;
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Graph = new int[N][N];
		memo = new int[N][1<<N];
		for(int i=0; i<N; i++)
			for(int j=1; j<N; j++)
				Graph[i][j] = sc.nextInt();
			
		System.out.println(solve(0, 0));
		
	
	}
	static int solve(int pos, int visited) {
		// ��� ��Ʈ�� ���� �� ���� �ִٸ�(��� �湮�ߴٸ�)
		if(visited == (1<<N)-1)
			return 0;
		// �� ���������� ������� �湮�ߴ� �������� �ּڰ��� ���Ǿ� �ִٸ� ��� �ȳ����� ��ȯ
		if(memo[pos][visited]>0)
			return memo[pos][visited]; 
		
		int ret = 999999999;
		for(int next=0; next<N; next++) {
			// �ش� ��Ʈ�� ���� ���� �ִٸ� (�ش� ��Ʈ�� ���� �����ִٸ�)
			if((visited&(1<<next))==0) {
				// ��� ����
				// visited|1<<next : ���� �湮�� ���� ��Ʈ�� �� �ѱ�
				int tmp = Graph[pos][next] + solve(next, visited|1<<next);
				if(ret>tmp)
					ret = tmp;
			}
		}
		// ��� �ּڰ� ���Ѱ� �޸������̼�
		memo[pos][visited]=ret;
		return ret;
	}
}