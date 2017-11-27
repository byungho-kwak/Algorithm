import java.awt.Point;
import java.util.Scanner;

public class Main {
	
	static int TC;
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			int N = sc.nextInt();
			sc.nextLine();
			char[][] room = new char[N+1][N+1];
			int[][] visitCheck = new int[N+1][N+1];
			Point[] vector = new Point[4];
			// 0:¡æ	1:¡é		2:¡ç		3:¡è
			vector[0] = new Point(0,1);
			vector[1] = new Point(1,0);
			vector[2] = new Point(0,-1);
			vector[3] = new Point(-1,0);
			
			String input;
			for(int i=1; i<=N; i++) {
				input = sc.nextLine();
				for(int j=0; j<N; j++) {
					room[i][j+1]=input.charAt(j);
					visitCheck[i][j+1]=0;
				}
			}
			
			int i=1;
			int j=1;
			Point nowVector=vector[0];
			
			// 0: °Å¿ïX		1: /		2: \
			while((i>0 && j>0)&&(i<=N && j<=N)) {
				
				if(visitCheck[i][j]!=1 && room[i][j]!='0') {
					visitCheck[i][j]=1;
					Answer+=1;
				}
				
				if(room[i][j] == '0') {
					i+=nowVector.x;
					j+=nowVector.y;
				}
				else if(room[i][j] == '1') {
					if(nowVector == vector[0]){
						i+=vector[3].x;
						j+=vector[3].y;
						nowVector = vector[3];
					}
					else if(nowVector == vector[1]) {
						i+=vector[2].x;
						j+=vector[2].y;
						nowVector = vector[2];
					}
					else if(nowVector == vector[2]) {
						i+=vector[1].x;
						j+=vector[1].y;
						nowVector = vector[1];
					}
					else {
						i+=vector[0].x;
						j+=vector[0].y;
						nowVector = vector[0];
					}
				}
				else {
					if(nowVector == vector[0]){
						i+=vector[1].x;
						j+=vector[1].y;
						nowVector = vector[1];
					}
					else if(nowVector == vector[1]) {
						i+=vector[0].x;
						j+=vector[0].y;
						nowVector = vector[0];
					}
					else if(nowVector == vector[2]) {
						i+=vector[3].x;
						j+=vector[3].y;
						nowVector = vector[3];
					}
					else {
						i+=vector[2].x;
						j+=vector[2].y;
						nowVector = vector[2];
					}
				}
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
