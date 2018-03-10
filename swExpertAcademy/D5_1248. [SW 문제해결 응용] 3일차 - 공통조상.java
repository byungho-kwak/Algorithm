
/*
 * 1248. [S/W 문제해결 응용] 3일차 - 공통조상
 * 트리 idx 저장 및 접근방식 문제
*/
import java.util.Scanner;

public class Main {
	static int[][] tree;
	static int[] visited;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();

			tree = new int[2][V+1];
			visited = new int[V+1];
			visited[1]=1;
			
			int nodeA = sc.nextInt();
			int nodeB = sc.nextInt();
			int[] nodeIdx = new int[2];
			nodeIdx[0] = 1;
			nodeIdx[1] = 1;
			int commonParent=0;
			
			for(int i=0; i<E; i++) {
				int pos = sc.nextInt();
				int val = sc.nextInt();
				
				if(nodeA == val)
					nodeIdx[0] = pos;
				if(nodeB == val)
					nodeIdx[1] = pos;
				
				if(tree[0][pos]==0)
					tree[0][pos]=val;
				else
					tree[1][pos]=val;
			}
			
			for(int i=0; i<2; i++) {
				int nowIdx = nodeIdx[i];
				int moveIdx = V;
				while(moveIdx!=1) {
					moveIdx--;
					if(tree[0][moveIdx]==nowIdx || tree[1][moveIdx]==nowIdx) {
						if(visited[moveIdx]==1) {
							commonParent = moveIdx;
							break;
						}
						visited[moveIdx]=1;
						nowIdx=moveIdx;
						moveIdx=V;
					}
				}
			}
			int subTreeCnt = 1+calSubTreeCnt(commonParent);
			System.out.println("#"+t+" "+commonParent+" "+subTreeCnt);
		}
	}
	
	static int calSubTreeCnt(int idx) {
		int ret=0;
		if(tree[0][idx]>0) {
			ret+= 1 + calSubTreeCnt(tree[0][idx]);
		}
		if(tree[1][idx]>0) {
			ret+= 1 + calSubTreeCnt(tree[1][idx]);
		}
		return ret;
	}
}