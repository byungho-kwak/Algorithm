/*
 * 2383. [모의 SW 역량테스트] 점심 식사시간
 * 유형 : 비트마스크 + 완전탐색
 */
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int[][] map, Dist;
	static int[] k, kx, ky, x, y;
	static int ans;
	static LinkedList<Integer> move;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			map = new int[N][N];
			ans=999999999;
			
			k = new int[2];
			kx = new int[2];
			ky = new int[2];
			x = new int[10];
			y= new int[10];
			
			move = new LinkedList<>();
			
			int peopleCnt=0, kCnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int tmp = sc.nextInt();
					if(tmp==1) {
						x[peopleCnt] = i;
						y[peopleCnt++] = j;
					}
					if(tmp>1) {
						k[kCnt] = tmp;
						kx[kCnt] = i;
						ky[kCnt++] = j;
					}
				}
			}
			Dist = new int[2][peopleCnt];
			
			for(int i=0; i<peopleCnt; i++) {
				Dist[0][i] = Math.abs(x[i]-kx[0]) + Math.abs(y[i]-ky[0]);
				Dist[1][i] = Math.abs(x[i]-kx[1]) + Math.abs(y[i]-ky[1]);
			}
			
			int choice = 0;
			
			while(choice <= (1<<peopleCnt)-1) {
				for(int i=0; i<peopleCnt; i++) {
					if(((choice>>i)&1) == 1) {
						move.add(Dist[0][i]);
					}
				}
				
				int timeA = moveCal(k[0]);
				
				for(int i=0; i<peopleCnt; i++) {
					// 000110 선택 후 남은 111001 비트마스크로 표현 
					// 111111 xor(^) 000110 = 111001
					if((((((1<<peopleCnt)-1)^choice)>>i)&1) == 1) {
						move.add(Dist[1][i]);
					}
				}
				
				int timeB = moveCal(k[1]);
				
				if(ans>Math.max(timeA, timeB))
					ans = Math.max(timeA, timeB);
				
				choice++;
			}
			
			System.out.println("#"+t+" "+ans);
			
		}
	}
	static int moveCal(int k) {
		LinkedList<Integer> q = new LinkedList<>();
		int time=0;
		
		while(!move.isEmpty() || !q.isEmpty()) {
			int StairCnt=0;;
			// 맵 이동 
			if(!move.isEmpty()) {
				for(int i=0; i<move.size(); i++) {
					move.set(i, move.get(i)-1);
					if(move.get(i)<=-1) {
						StairCnt++;
					}
				}
			}
			
			// 계단 내려가기
			if(!q.isEmpty()) {
				for(int i=0; i<q.size(); i++) {
					q.set(i, q.get(i)-1);
					if(Math.abs(q.get(i))==k) {
						// poll을 하면 다음 인자가 현재 위치로 이동하는데 i++가 되면 현재 인자 확인 못함 따라서,
						// poll 하고 인덱스를 유지시켜야하기 때문에 i-- 시켜줌 
						q.poll();
						i--;
					}
				}
			}
			
			//계단에 넣기
			for(int i=0; i<move.size(); i++) {
				if(q.size()<3 && move.get(i)<=-1) {
					q.add(0);
					// remove를 하면 다음 인자가 현재 위치로 이동하는데 i++가 되면 현재 인자 확인 못함 따라서,
					// remove 하고 인덱스를 유지시켜야하기 때문에 i-- 시켜줌
					move.remove(i);
					i--;
					StairCnt--;
					if(StairCnt==0)
						break;
				}
			}
			time++;
		}
		return time;
	}
}

