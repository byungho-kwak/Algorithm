import java.util.Scanner;

public class Main {
	static int n;
	static boolean[] check;
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		for(int tc=1; tc<=t; tc++) {
			
			n = sc.nextInt();
			check = new boolean[1<<n];
			int ans=1<<n;
			int testcase = sc.nextInt();
			
			for(int i=0; i<testcase; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int state =0;
				
				// ��� a �ش� ��Ʈ ��ȣ�� �ݿ� ��Ű��
				state = 1<<a;
				
				// ��� b �ش� ��Ʈ ��ȣ�� �ݿ� ��Ű��� a�� ��ģ��.
				// �̴� �� ��Ʈ���� ���a���� b���� 1�� �ݿ� ��Ų��.
				state = state|1<<b;
				
				// ��Ʈ ������ 0�̹Ƿ�, ���������� shift���Ѽ� �ش� ���̽� ���� ���� Ȯ��
				// ������ �ٸ� ��쿡�� ������ ����� �湮 ���Ѵ�.
				if(!check[state>>1])
					ans-=bitDP(state, 1);
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	// �ش� ��ġ�� ��Ʈ�� 1�̸� ��Ʈ�� �״�� �ѱ�� idx�� �߰��Ͽ� ���� ���set Ȯ��
	// �ش� ��ġ�� ��Ʈ�� 0�̸�, ��Ʈ�� �״�� �ѱ�� idx�� �߰��Ͽ� ���� ���set Ȯ�� + �ش� ��Ʈ�� 1�� �����Ͽ�(����߰�) ���� Ȯ�� �غ�����
	static int bitDP(int state, int idx) {
		int sum=0;
		
		// ��Ʈ �ε��� ��ȣ�� ��� ���� �ʰ� ��� ����
		if(idx>n)
			return 0;
		
		// 
		if(!check[state>>1]) {
			check[state>>1]=true;
			sum++;
		}
		// ���� �ε����� ���� ���� ���̽� Ȯ��
		// 0010�� ���, ������ 0110, 1110�� ��츦 Ȯ�� �غ��� �ϹǷ� ���� ���� ��͸� �����Ѵ�.
		sum+=bitDP(state, idx+1);
		
		
		// �ش� ��ġ�� ��Ʈ�� 0�� ��� 1�� �����Ͽ� ������ ���̽��� �����.
		// �ش� ���̽��� �湮 ���θ� Ȯ��
		
		
		if((state&(1<<idx))==0) {
			state|=1<<idx;
			// �ش� ��ġ�� 0�� 1�� �����ϴ°� ���� set�� �߰��ϴ� ��
			// 00010�� ��쿡 3��° ��Ʈ�� Ȯ�� �߿� �ִٸ�, 0�� ��Ʈ�� 1�� �ٲپ� Ȯ�� �غô��� �湮 �ߴ� ���� ������
			// ���� �տ� ������ ��� ���� �ռ� ��� set���� Ȯ�� �Ƶ� ����̱� ������ Ȯ������ �ʴ´�.
			// Ȯ���� �ȵ� ��쿡�� ��͸� �����Ѵ�.
			if(!check[state>>1]) {
				check[state>>1]=true;
				sum++;
				sum+=bitDP(state, idx+1);
			}
		}
		return sum;
	}
}