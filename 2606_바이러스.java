import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	static int Answer;
	
	public static void main(String[] args) {
		int Answer=0;
		
		Queue<Integer> q = new LinkedList();
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		boolean[] visit = new boolean[V];
		
		Vector<Integer>[] adj = new Vector[V];
        for (int i = 0; i < adj.length; i++) {
        	// 정점마다 벡터 
            adj[i] = new Vector();
        }
		
        for(int i=0; i<E; i++) {
        	int start = sc.nextInt();
        	int end = sc.nextInt();
        	
        	adj[start-1].add(end);
        	adj[end-1].add(start);
        }
		
		Arrays.fill(visit, false);
		
		q.add(1);
		
		int start;
		while(!q.isEmpty()) {
			start=q.poll();
			
			for(int i=0; i<adj[start-1].size(); i++) {
				if(visit[adj[start-1].elementAt(i)-1]==false)
					q.add(adj[start-1].elementAt(i));
			}
			visit[start-1] = true;
		}
		
		for(int i=0; i<V; i++) {
			if(visit[i])
				Answer++;
		}
		
		System.out.println(Answer-1);
	}
	
}
