
import java.util.Scanner;
 

// �κй迭 : ���� ���������� �־��Ѵ�.
// ex) 12345 �κй迭�� 2,3,4 ����, but 1,5 �Ұ���

class Main {
	static int Answer;
	static int INF = 2100000000;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			
			Answer=INF;
			
			int num = sc.nextInt();
			int s = sc.nextInt();
			
			int[] arr = new int[num+1];
			
			int sum=0;
			int cnt=0;
			
			for(int i=1; i<=num; i++)
				arr[i] = sc.nextInt();
			
			
			for(int i=1; i<=num; i++) {
				sum+=arr[i];
				
				// ���� ���� S �ʰ��ÿ�
				if(sum>=s) {
					// ���� ������ ������ arr[j]�� �Ѱ��� ���鼭 S�̸��� �Ǵ� ���� ã�´�. 
					// ������ �ð��ʰ��� ������ �� ������ �ݴ�� �ؼ�.. (���� �ε������� ���������� ���ذ��鼭 S�Ѵ� ���� ã��)
					for(int j=i-cnt; j<i; j++) {
						if(sum-arr[j]<s) {
							cnt=i-j+1;
							if(Answer>cnt)
								Answer=cnt;
							break;
						}
						else
							sum-=arr[j];
					}
				}
				else {
					cnt++;
				}
			}
			
			if(Answer==INF)
				Answer=0;
			
			System.out.println("#testcase"+(test_case+1));
			System.out.println(Answer);
		}
	}
}