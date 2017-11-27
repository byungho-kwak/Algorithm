
import java.util.Scanner;
 

// 부분배열 : 수가 연속적으로 있어한다.
// ex) 12345 부분배열은 2,3,4 가능, but 1,5 불가능

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
				
				// 합이 기준 S 초과시에
				if(sum>=s) {
					// 덧샘 시작한 곳부터 arr[j]를 한개씩 빼면서 S미만이 되는 점을 찾는다. 
					// 기존에 시간초과난 이유는 위 내용을 반대로 해서.. (현재 인덱스에서 시작점까지 더해가면서 S넘는 지점 찾기)
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