import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	static int INF = 10000000;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		ArrayList<MoveInfo>[] adj = new ArrayList[V+1];

		for(int i=1; i<=V; i++)
			adj[i] = new ArrayList();
		
		int[] d = new int[V+1];
		boolean[] visit = new boolean[V+1];
		
		Arrays.fill(d, INF);
		Arrays.fill(visit, false);
		
		int start = sc.nextInt();
		d[start] = 0;
		
		// A to B + wreght
		for(int i=1; i<=E; i++) {
			int vertexA = sc.nextInt();
			adj[vertexA].add(new MoveInfo(sc.nextInt(), sc.nextInt()));
		}
		
		PriorityQueue<MoveInfo> pq = new PriorityQueue();
		pq.add(new MoveInfo(start, d[start]));

		int vertexA=start;
		MoveInfo mi;
		while(!pq.isEmpty()) {
			
			while(true) {
				if(!pq.isEmpty() && visit[vertexA]==true) {
					vertexA = pq.poll().vertex;
				}
				else
					break;
			}
			if(visit[vertexA]==true)
				break;

			for(int i=1; i<=adj[vertexA].size(); i++) {
				mi = adj[vertexA].get(i-1);
				int vertexB = mi.vertex;
				int weight = mi.weight;
				
				d[vertexB] = Math.min(d[vertexB], d[vertexA]+weight);
				pq.add(new MoveInfo(vertexB, d[vertexB]));
			}
			visit[vertexA] = true;
		}
		
		for(int i=1; i<=V; i++) {
			if(d[i]==INF)
				System.out.println("INF");
			else
				System.out.println(d[i]);
		}
	}
}

class MoveInfo implements Comparable<MoveInfo> {
	int vertex;
	int weight;
	
	MoveInfo(int ver, int wei) {
		this.vertex = ver;
		this.weight = wei;
	}
	
	@Override
	public int compareTo(MoveInfo o) {
		// 음수 : this 객체가 o보다 앞으로
		// 양수 : this 객체가 o보다 뒤로
		return this.weight < o.weight ? -1 : 1;
	}
}

