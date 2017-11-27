import java.awt.Point;
import java.util.Scanner;

public class Main {
	static int Answer;
	static final int INF = 9999999;
	static int check(char[][] map, int checkCnt, Point red, Point blue) {
		int temp=INF;
		if(checkCnt > 10)
			return INF;
		
		if((red.y-1>0 && map[red.x][red.y-1]!='#') || (blue.y-1>0 && map[blue.x][blue.y-1]!='#'))
			temp=leftMove(map, checkCnt, red, blue);
		if((red.y+1<map[0].length && map[red.x][red.y+1]!='#') || (blue.y+1<map[0].length && map[blue.x][blue.y+1]!='#'))
			temp=Math.min(temp,rightMove(map, checkCnt, red, blue));
		if((red.x-1>0 && map[red.x-1][red.y]!='#') || (blue.y+1>0 && map[blue.x-1][blue.y]!='#'))
			temp=Math.min(temp,upMove(map, checkCnt, red, blue));
		if((red.x+1<map.length && map[red.x+1][red.y]!='#') || (blue.y+1<map.length && map[blue.x+1][blue.y]!='#'))
			temp=Math.min(temp,downMove(map, checkCnt, red, blue));
		return temp;
	}
	
	// 왼쪽으로
	static int leftMove(char[][] map, int checkCnt, Point red, Point blue) {
		char [][] m = new char[map.length][map[0].length];
		for(int i=0; i<map.length; i++) 
			for(int j=0; j<map[0].length; j++)
				m[i][j]=map[i][j];
		
		int moveRed=red.y;
		int moveBlue=blue.y;
		
		if(red.y < blue.y) {
			while(true){
				if(m[red.x][moveRed]=='#') {
					moveRed+=1;
					m[red.x][red.y]='.';
					m[red.x][moveRed]='R';
					break;
				}
				else if(m[red.x][moveRed]=='O') {
					m[red.x][red.y]='.';
					break;
				}
				moveRed--;
			}
			while(true){
				if(m[blue.x][moveBlue]=='#' || m[blue.x][moveBlue]=='R') {
					moveBlue+=1;
					m[blue.x][blue.y]='.';
					m[blue.x][moveBlue]='B';
					break;
				}
				else if(m[blue.x][moveBlue]=='O') {
					m[blue.x][blue.y]='.';
					break;
				}
				moveBlue--;
			}
		}
		else {
			while(true){
				if(m[blue.x][moveBlue]=='#') {
					moveBlue+=1;
					m[blue.x][blue.y]='.';
					m[blue.x][moveBlue]='B';
					break;
				}
				else if(m[blue.x][moveBlue]=='O') {
					m[blue.x][blue.y]='.';
					break;
				}
				moveBlue--;
			}
			while(true){
				if(m[red.x][moveRed]=='#' || m[red.x][moveRed]=='B') {
					moveRed+=1;
					m[red.x][red.y]='.';
					m[red.x][moveRed]='R';
					break;
				}
				else if(m[red.x][moveRed]=='O') {
					m[red.x][red.y]='.';
					break;
				}
				moveRed--;
			}
		}
		
		if(m[blue.x][moveBlue]=='O')
			return INF;
		else if(m[blue.x][moveBlue]!='O' && m[red.x][moveRed]=='O')
			return checkCnt;
		else {
			red = new Point(red.x, moveRed);
			blue =  new Point(blue.x, moveBlue);
			return check(m, checkCnt+1, red, blue);
		}
	}
	
	// 오른쪽으로
	static int rightMove(char[][] map, int checkCnt, Point red, Point blue) {
		char [][] m = new char[map.length][map[0].length];
		for(int i=0; i<map.length; i++) 
			for(int j=0; j<map[0].length; j++)
				m[i][j]=map[i][j];
		
		int moveRed=red.y;
		int moveBlue=blue.y;
		
		if(red.y > blue.y) {
			while(true){
				if(m[red.x][moveRed]=='#') {
					moveRed-=1;
					m[red.x][red.y]='.';
					m[red.x][moveRed]='R';
					break;
				}
				else if(m[red.x][moveRed]=='O') {
					m[red.x][red.y]='.';
					break;
				}
				moveRed++;
			}
			while(true){
				if(m[blue.x][moveBlue]=='#' || m[blue.x][moveBlue]=='R') {
					moveBlue-=1;
					m[blue.x][blue.y]='.';
					m[blue.x][moveBlue]='B';
					break;
				}
				else if(m[blue.x][moveBlue]=='O') {
					m[blue.x][blue.y]='.';
					break;
				}
				moveBlue++;
			}
		}
		else {
			while(true){
				if(m[blue.x][moveBlue]=='#') {
					moveBlue-=1;
					m[blue.x][blue.y]='.';
					m[blue.x][moveBlue]='B';
					break;
				}
				else if(m[blue.x][moveBlue]=='O') {
					m[blue.x][blue.y]='.';
					break;
				}
				moveBlue++;
			}
			while(true){
				if(m[red.x][moveRed]=='#' || m[red.x][moveRed]=='B') {
					moveRed-=1;
					m[red.x][red.y]='.';
					m[red.x][moveRed]='R';
					break;
				}
				else if(m[red.x][moveRed]=='O') {
					m[red.x][red.y]='.';
					break;
				}
				moveRed++;
			}
		}
		
		if(m[blue.x][moveBlue]=='O')
			return INF;
		else if(m[blue.x][moveBlue]!='O' && m[red.x][moveRed]=='O')
			return checkCnt;
		else {
			red = new Point(red.x, moveRed);
			blue =  new Point(blue.x, moveBlue);
			return check(m, checkCnt+1, red, blue);
		}
	}
	
	// 아래로
	static int downMove(char[][] map, int checkCnt, Point red, Point blue) {
		char [][] m = new char[map.length][map[0].length];
		for(int i=0; i<map.length; i++) 
			for(int j=0; j<map[0].length; j++)
				m[i][j]=map[i][j];
		
		int moveRed=red.x;
		int moveBlue=blue.x;
		
		if(red.x > blue.x) {
			while(true){
				if(m[moveRed][red.y]=='#') {
					moveRed-=1;
					m[red.x][red.y]='.';
					m[moveRed][red.y]='R';
					break;
				}
				else if(m[moveRed][red.y]=='O') {
					m[red.x][red.y]='.';
					break;
				}
				moveRed++;
			}
			while(true){
				if(m[moveBlue][blue.y]=='#' || m[moveBlue][blue.y]=='R') {
					moveBlue-=1;
					m[blue.x][blue.y]='.';
					m[moveBlue][blue.y]='B';
					break;
				}
				else if(m[moveBlue][blue.y]=='O') {
					m[blue.x][blue.y]='.';
					break;
				}
				moveBlue++;
			}
		}
		else {
			while(true){
				if(m[moveBlue][blue.y]=='#') {
					moveBlue-=1;
					m[blue.x][blue.y]='.';
					m[moveBlue][blue.y]='B';
					break;
				}
				else if(m[moveBlue][blue.y]=='O') {
					m[blue.x][blue.y]='.';
					break;
				}
				moveBlue++;
			}
			while(true){
				if(m[moveRed][red.y]=='#' || m[moveRed][red.y]=='B') {
					moveRed-=1;
					m[red.x][red.y]='.';
					m[moveRed][red.y]='R';
					break;
				}
				else if(m[moveRed][red.y]=='O') {
					m[red.x][red.y]='.';
					break;
				}
				moveRed++;
			}
		}
		
		if(m[moveBlue][blue.y]=='O')
			return INF;
		else if(m[moveBlue][blue.y]!='O' && m[moveRed][red.y]=='O')
			return checkCnt;
		else {
			red = new Point(moveRed, red.y);
			blue =  new Point(moveBlue, blue.y);
			return check(m, checkCnt+1, red, blue);
		}
	}
	
	// 위로
	static int upMove(char[][] map, int checkCnt, Point red, Point blue) {
		char [][] m = new char[map.length][map[0].length];
		for(int i=0; i<map.length; i++) 
			for(int j=0; j<map[0].length; j++)
				m[i][j]=map[i][j];
		
		int moveRed=red.x;
		int moveBlue=blue.x;
		
		if(red.x < blue.x) {
			while(true){
				if(m[moveRed][red.y]=='#') {
					moveRed+=1;
					m[red.x][red.y]='.';
					m[moveRed][red.y]='R';
					break;
				}
				else if(m[moveRed][red.y]=='O') {
					m[red.x][red.y]='.';
					break;
				}
				moveRed--;
			}
			while(true){
				if(m[moveBlue][blue.y]=='#' || m[moveBlue][blue.y]=='R') {
					moveBlue+=1;
					m[blue.x][blue.y]='.';
					m[moveBlue][blue.y]='B';
					break;
				}
				else if(m[moveBlue][blue.y]=='O') {
					m[blue.x][blue.y]='.';
					break;
				}
				moveBlue--;
			}
		}
		else {
			while(true){
				if(m[moveBlue][blue.y]=='#') {
					moveBlue+=1;
					m[blue.x][blue.y]='.';
					m[moveBlue][blue.y]='B';
					break;
				}
				else if(m[moveBlue][blue.y]=='O') {
					m[blue.x][blue.y]='.';
					break;
				}
				moveBlue--;
			}
			while(true){
				if(m[moveRed][red.y]=='#' || m[moveRed][red.y]=='B') {
					moveRed+=1;
					m[red.x][red.y]='.';
					m[moveRed][red.y]='R';
					break;
				}
				else if(m[moveRed][red.y]=='O') {
					m[red.x][red.y]='.';
					break;
				}
				moveRed--;
			}
		}
		
		if(m[moveBlue][blue.y]=='O')
			return INF;
		else if(m[moveBlue][blue.y]!='O' && m[moveRed][red.y]=='O')
			return checkCnt;
		else {
			red = new Point(moveRed, red.y);
			blue =  new Point(moveBlue, blue.y);
			return check(m, checkCnt+1, red, blue);
		}
	}
	
	public static void main(String[] args) {
		Answer=INF;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] map = new char[N][M];
		
		sc.nextLine();
		Point red=null;
		Point blue=null;
		for(int i=0; i<N; i++) {
			String temp = sc.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j] = temp.charAt(j);
				if(temp.charAt(j)=='R')
					red = new Point(i,j);
				else if(temp.charAt(j)=='B')
					blue = new Point(i,j);
			}
		}
		
		Answer = check(map, 1, red, blue);
		if(Answer==INF)
			Answer=-1;
		System.out.println(Answer);
	}	
}
