// 문제 : 2382. [모의 SW 역량테스트] 미생물 격리
// 유형 : 구현
// * 메모리가 너무 크다. 코드보기 했던 코드를 참고하여 리펙토링 필요


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static int N, K, M, dx[] = {0,-1,1,0,0}, dy[] = {0,0,0,-1,1}, reverse[] = {0,2, 1, 4, 3};
	static int[][] map;
	static Queue<Bacteria> q;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			N = sc.nextInt(); 	// map 크기
			M = sc.nextInt();	// 격리시간
			K = sc.nextInt();	// 군집수
			
			map = new int[N][N];
			q = new LinkedList<>();
			
			int totalBacCnt=0;
			
			for(int i=0; i<K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int bacCnt = sc.nextInt();
				int direct = sc.nextInt();
				q.add(new Bacteria(x, y, bacCnt, direct));
				map[x][y]+=1;
			}
			
			for(int m=0; m<M; m++) {
				int nextMap[][] = new int[N][N];
				int pqCnt = q.size();
				if(pqCnt==0) break;
				for(int size=0; size<pqCnt; size++) {
					Bacteria b = q.poll();
					move(b, nextMap);
				}
				checkSet(nextMap);
				
				copyArr(nextMap);
				//print(nextMap);
			}
			
			while(!q.isEmpty()) {
				Bacteria b = q.poll();
				totalBacCnt+=b.bacCnt;
			}
			System.out.println("#"+t+" "+totalBacCnt);
		}
	}
	
//	static void print(int[][] nextArr) {
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(nextArr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("--------");
//	}
	
	static void move(Bacteria b, int[][]nextArr) {
		int nextX = b.x+dx[b.direct];
		int nextY = b.y+dy[b.direct];
		
		b.x = nextX;
		b.y = nextY;
		
		// 약품에 도달
		if(nextX==0 || nextX==N-1 || nextY==0 || nextY==N-1) {
			b.bacCnt = b.bacCnt/2;
			b.direct = reverse[b.direct];
		}
		nextArr[nextX][nextY]++;
		q.add(b);
	}
	
	static void copyArr(int[][] nextArr) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = nextArr[i][j];
			}
		}
	}
	
	static void checkSet(int[][] nextArr) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(nextArr[i][j] <= 1) continue;
				
				Bacteria maxB = new Bacteria(i, j, 0, 0);
				int maxCnt=0;
				int size=q.size();
				for(int idx=0; idx<size; idx++) {
					Bacteria b = q.poll();
					if(b.x != i || b.y != j){
						q.add(b);
						continue;
					}
					
					maxB.bacCnt+=b.bacCnt;
					if(maxCnt<b.bacCnt) {
						maxCnt = b.bacCnt;
						maxB.direct = b.direct;
					}
				}
				q.add(maxB);
				nextArr[i][j]=1;
			}
		}
	}
}

class Bacteria {
	int x;
	int y;
	int bacCnt;
	int direct;
	
	Bacteria(int x, int y, int bacCnt, int direct) {
		this.x = x;
		this.y = y;
		this.bacCnt = bacCnt;
		this.direct = direct;
	}
}