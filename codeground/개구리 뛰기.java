import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int TC;
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;

			int stoneCnt = sc.nextInt();
			int[] stoneIdx = new int[stoneCnt+1];
			
			stoneIdx[0] = 0;
			for(int i=1; i<=stoneCnt; i++)
				stoneIdx[i] = sc.nextInt(); 
			
			
			long jump = sc.nextInt();
			
			int nowIdx=0;
			
			//-------입력 끝-------
			

			for(int i=1; i<=stoneCnt; i++) {
				if(nowIdx+jump < stoneIdx[i]) {	// stoneIdx[i] 까지 점프로 갈 수 없으면
					nowIdx = stoneIdx[i-1];
					Answer++;
				}
			}
			Answer++;
			
			for(int i=0; i<stoneCnt; i++) {
				if(stoneIdx[i+1] - stoneIdx[i] > jump)
					Answer=-1;
			}
			
			System.out.println("Case #"+(test_case+1));
			
			if(Answer == -1)
				System.out.println(-1);
			else
				System.out.println(Answer);
		}
	}
}
