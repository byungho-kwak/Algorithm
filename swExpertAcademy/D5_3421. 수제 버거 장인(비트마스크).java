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
				
				// 재료 a 해당 비트 번호에 반영 시키기
				state = 1<<a;
				
				// 재료 b 해당 비트 번호에 반영 시키기고 a와 합친다.
				// 이는 한 비트열에 재료a번과 b번을 1로 반영 시킨다.
				state = state|1<<b;
				
				// 비트 시작이 0이므로, 오른쪽으로 shift시켜서 해당 케이스 삭제 여부 확인
				// 이전에 다른 경우에서 삭제한 경우라면 방문 안한다.
				if(!check[state>>1])
					ans-=bitDP(state, 1);
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	// 해당 위치의 비트가 1이면 비트열 그대로 넘기고 idx만 추가하여 다음 재료set 확인
	// 해당 위치의 비트가 0이면, 비트열 그대로 넘기고 idx만 추가하여 다음 재료set 확인 + 해당 비트열 1로 변경하여(재료추가) 삭제 확인 해봐야함
	static int bitDP(int state, int idx) {
		int sum=0;
		
		// 비트 인덱스 번호가 재료 갯수 초과 경우 종료
		if(idx>n)
			return 0;
		
		// 
		if(!check[state>>1]) {
			check[state>>1]=true;
			sum++;
		}
		// 다음 인덱스에 대해 조합 케이스 확인
		// 0010인 경우, 앞으로 0110, 1110의 경우를 확인 해봐야 하므로 조건 없이 재귀를 진행한다.
		sum+=bitDP(state, idx+1);
		
		
		// 해당 위치의 비트가 0인 경우 1로 변경하여 가능한 케이스를 만든다.
		// 해당 케이스의 방문 여부를 확인
		
		
		if((state&(1<<idx))==0) {
			state|=1<<idx;
			// 해당 위치가 0데 1로 변경하는건 집합 set을 추가하는 것
			// 00010인 경우에 3번째 비트를 확인 중에 있다면, 0인 비트를 1로 바꾸어 확인 해봤더니 방문 했던 적이 있으면
			// 이후 앞에 나오는 모든 경우는 앞선 재료 set에서 확인 됐된 결과이기 때문에 확인하지 않는다.
			// 확인이 안된 경우에만 재귀를 진행한다.
			if(!check[state>>1]) {
				check[state>>1]=true;
				sum++;
				sum+=bitDP(state, idx+1);
			}
		}
		return sum;
	}
}