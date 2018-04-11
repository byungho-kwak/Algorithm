import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final int INF = 200000000;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=1; t++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			int start = sc.nextInt()-1;
			
			ArrayList<nodeInfo>[] adj = new ArrayList[V];
			PriorityQueue<nodeInfo> pq = new PriorityQueue<>();
			for(int i=0; i<V; i++)
				adj[i] = new ArrayList<>();
			
			int[] dis = new int [V];
			boolean[] visit = new boolean[V];
			boolean[] pqPushCheck = new boolean[V];
			
			
			for(int e=0; e<E; e++) {
				int vertexA = sc.nextInt()-1;
				int vertexB = sc.nextInt()-1;
				int weight = sc.nextInt();
				adj[vertexA].add(new nodeInfo(vertexB, weight));
			}

			
			Arrays.fill(visit, false);
			Arrays.fill(dis, INF);
			dis[start] = 0;
			pq.add(new nodeInfo(start, 0));
			
			while(!pq.isEmpty()) {
				
				// �ٽɺκ� ����
				// 2) ����ġ�� �� ������ ���� ����ġ�� ���� �������� ���� �Ǿ��ְ�,
				//  �湮 �ߴ� ������ skip �ϰ�, ���� ����ġ ���� �� �� �湮���� ���� ��� ����
				int vertexA = -1;
				while(!pq.isEmpty()) {
					if(visit[pq.peek().node])
						pq.poll();
					else {
						vertexA = pq.peek().node;
						break;
					}
				}
				// ���� ����ġ ���� �� �� �湮���� ���� ��尡 ���ٸ�(���õ��� �ʾҴٸ�) ��� ��� �湮 �� ���̹Ƿ�, ���� Ż��
				if(vertexA==-1)
					break;
				// �ٽɺκ� ��
				
				int minCost = INF;
				visit[vertexA] = true;
				
				for(int j=0; j<adj[vertexA].size(); j++){
					int vertexB = adj[vertexA].get(j).node;
					int weight = adj[vertexA].get(j).dis;
					if(dis[vertexB] > dis[vertexA] + weight) {
						dis[vertexB] = dis[vertexA] + weight;
					}
					// 1) �� ��忡�� ���� ������ ��� ���� �� ť�� �ְ�
					pq.add(new nodeInfo(vertexB, dis[vertexB]));
				}
			}

			for(int i=0; i<V; i++) {
				if(dis[i]==INF)
					System.out.println("INF");
				else
					System.out.println(dis[i]);
			}
		}
	}
}

class nodeInfo implements Comparable<nodeInfo>{

	int node;
	int dis;
	
	nodeInfo(int node, int dis) {
		this.node = node;
		this.dis = dis;
	}
	
	@Override
	public int compareTo(nodeInfo o) {
		return this.dis > o.dis? 1 : (this.dis<o.dis? -1 : 0);
	}
}