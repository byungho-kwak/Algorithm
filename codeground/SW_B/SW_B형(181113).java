import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int[][] tempMap;
	static int CallCnt;
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		CallCnt=0;
		N = sc.nextInt();
		map = new int[N][N];
		tempMap = new int[N][N];
		
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++)
				map[i][j] = sc.nextInt();

		//Result result = new Result();
		
		find(0,0,N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(tempMap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("observe È£Ãâ È½¼ö : "+CallCnt);
		
	}
	
	static void find(int x, int y, int size) {
		int infactCnt=observe(y, x, size);
		if(infactCnt==0)
			return;
		if(size==1) {
			tempMap[x][y]=infactCnt;
			return;
		}
		
		int divSize=0;
		if(size%2==0)
			divSize = (size/2);
		else
			divSize = (size/2)+1;
		
		
		if(size%2==0) {
			find(x,y,divSize);
			find(x+divSize, y, divSize);
			find(x, y+divSize, divSize);
			find(x+divSize, y+divSize, divSize);
		}
		// È¦¼öÀÎ °æ¿ì
		else {
			find(x,y,divSize);
			find(x+divSize, y, divSize);
			for(int i=x+divSize; i<N; i++) {
				tempMap[i][y+divSize-1]=observe(y+divSize-1, i, 1);
			}
			find(x, y+divSize, divSize);
			for(int j=y+divSize; j<N; j++) {
				tempMap[x+divSize-1][j]=observe(j, x+divSize-1, 1);
			}
			find(x+divSize, y+divSize, divSize);
		}
	}
	
	static int observe(int y, int x, int size) {
		int infect=0;
		for(int i=x; i<x+size; i++) {
			if(i>=N)
				continue;
			for(int j=y; j<y+size; j++) {
				if(j>=N)
					continue;
				
				if(map[i][j]==1)
					infect++;
			}
		}
		CallCnt++;
		return infect;
	}
	
	static class Result {
		int count;
		Result() {
			count=0;
		}
		
		Cell[] cell = new Cell[N];
	}
	
	static class Cell {
		int x, y;
	}
}