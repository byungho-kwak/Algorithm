import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static Point moveLeft = new Point(0,-1);
	static Point moveRight = new Point(0,1);
	static Point moveUp = new Point(-1,0);
	static Point moveDown = new Point(1,0);
	
	static char[][] MAP = new char[11][11];
	static int N, M;
	static final int RED = 1;
	static final int BLUE = 2;
	
	static Stack<Point> traceRedBall = new Stack<Point>();
	static Stack<Point> traceBlueBall = new Stack<Point>();
	
	static Point hole;
	
	static Point redPoint;
	static Point bluePoint;
	
	static int minSucessCnt = 11;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
	    
		N = Integer.parseInt(s[0]);
	    M = Integer.parseInt(s[1]);
	
		char input;
		
		
		for(int i=1; i<=N; i++) {
			String inputString = br.readLine();
			for(int j=1; j<=M; j++) {
				input = inputString.charAt(j-1);
				
				if(input == 'O') {
					hole = new Point(i,j);
					MAP[i][j] = 'O';
				} else if(input == 'R') {
					traceRedBall.push(new Point(i,j));
					MAP[i][j] = 'R';
				} else if(input == 'B') {
					traceBlueBall.push(new Point(i,j));
					MAP[i][j] = 'B';	
				}else if(input == '#')
					MAP[i][j] = '#';
				else
					MAP[i][j] = '.';
			}
		}
			
		findHole(traceRedBall.peek(), traceBlueBall.peek(), 0);
		
		if(minSucessCnt == 11)
			System.out.println("-1");
		else
			System.out.println(minSucessCnt);
	}
			
	
	static void findHole(Point red, Point blue, int moveCnt) {
		
		if(moveCnt > 10)
			return;
		
		if(blue.x == hole.x && blue.y == hole.y)
			return;
		
		if((blue.x != hole.x || blue.y != hole.y) && (red.x == hole.x && red.y == hole.y)) {
			if(moveCnt < minSucessCnt)
				minSucessCnt = moveCnt;
			return;
		}
		
		movePointLeft(red, blue);
		if((traceRedBall.peek().x == red.x && traceRedBall.peek().y == red.y) && 
				(traceBlueBall.peek().x == blue.x && traceBlueBall.peek().y == blue.y)) {
			traceRedBall.pop();
			traceBlueBall.pop();
		} else {
			findHole(traceRedBall.peek(),traceBlueBall.peek(),moveCnt + 1);
		}
		movePointDown(red, blue);
		if((traceRedBall.peek().x == red.x && traceRedBall.peek().y == red.y) && 
				(traceBlueBall.peek().x == blue.x && traceBlueBall.peek().y == blue.y)) {
			traceRedBall.pop();
			traceBlueBall.pop();
		} else {
			findHole(traceRedBall.peek(),traceBlueBall.peek(),moveCnt + 1);
		}
		movePointRight(red, blue);
		if((traceRedBall.peek().x == red.x && traceRedBall.peek().y == red.y) && 
				(traceBlueBall.peek().x == blue.x && traceBlueBall.peek().y == blue.y)) {
			traceRedBall.pop();
			traceBlueBall.pop();
		} else {
			findHole(traceRedBall.peek(),traceBlueBall.peek(),moveCnt + 1);
		}
		
		movePointUp(red, blue);
		if((traceRedBall.peek().x == red.x && traceRedBall.peek().y == red.y) && 
				(traceBlueBall.peek().x == blue.x && traceBlueBall.peek().y == blue.y)) {
			traceRedBall.pop();
			traceBlueBall.pop();
		} else {
			findHole(traceRedBall.peek(),traceBlueBall.peek(),moveCnt + 1);
		}
		
		traceRedBall.pop();
		traceBlueBall.pop();

	}
	
	static void movePointUp(Point red, Point blue) {
		
		Point nextRedP;
		Point nextBlueP; 
		
		// 공 이동시키기
				// 움직이려는 방향 끝에 가까운 공부터 움직인다.
		
		if(red.x < blue.x) {
			nextRedP = mUp(red, RED);		
			nextBlueP = mUp(blue, BLUE);	

		}else {
			nextBlueP = mUp(blue, BLUE);
			nextRedP = mUp(red, RED);		
		}
		
		traceRedBall.push(nextRedP);
		traceBlueBall.push(nextBlueP);
		
	}
	
	
	static Point mUp(Point nowPoint, int color) {		
		Point nextPoint = new Point(nowPoint.x, nowPoint.y);
		
		while(MAP[nextPoint.x+ moveUp.x][nextPoint.y] =='.' )
			nextPoint.x = nextPoint.x + moveUp.x;
		
		if(MAP[nextPoint.x+ moveUp.x][nextPoint.y] == 'O') {
			nextPoint.x = nextPoint.x + moveUp.x;
		}else {
			MAP[nowPoint.x][nowPoint.y] = '.';
			if(color == RED)
				MAP[nextPoint.x][nextPoint.y] = 'R';
			else
				MAP[nextPoint.x][nextPoint.y] = 'B';
		}
		return nextPoint;			
	}
	
	static void movePointDown(Point red, Point blue) {
		
		Point nextRedP;
		Point nextBlueP; 
		
		// 공 이동시키기
				// 움직이려는 방향 끝에 가까운 공부터 움직인다.
		
		if(red.x < blue.x) {
			nextBlueP = mDown(blue, BLUE);
			nextRedP = mDown(red, RED);	
		}else {
			nextRedP = mDown(red, RED);		
			nextBlueP = mDown(blue, BLUE);	
		}
		
		traceRedBall.push(nextRedP);
		traceBlueBall.push(nextBlueP);
		
	}
	
	
	static Point mDown(Point nowPoint, int color) {		
		Point nextPoint = new Point(nowPoint.x, nowPoint.y);
		
		while(MAP[nextPoint.x+ moveDown.x][nextPoint.y] =='.' )
			nextPoint.x = nextPoint.x + moveDown.x;
		
		if(MAP[nextPoint.x+ moveDown.x][nextPoint.y] == 'O') {
			nextPoint.x = nextPoint.x + moveDown.x;
		}else {
			MAP[nowPoint.x][nowPoint.y] = '.';
			if(color == RED)
				MAP[nextPoint.x][nextPoint.y] = 'R';
			else
				MAP[nextPoint.x][nextPoint.y] = 'B';
		}
		return nextPoint;			
	}
	
	static void movePointRight(Point red, Point blue) {
		
		Point nextRedP;
		Point nextBlueP; 
		
		// 공 이동시키기
				// 움직이려는 방향 끝에 가까운 공부터 움직인다.
		
		if(red.y < blue.y) {
			nextBlueP = mRight(blue, BLUE);
			nextRedP = mRight(red, RED);	
		}else {
			nextRedP = mRight(red, RED);		
			nextBlueP = mRight(blue, BLUE);	
		}
		
		traceRedBall.push(nextRedP);
		traceBlueBall.push(nextBlueP);
		
	}
	
	
	static Point mRight(Point nowPoint, int color) {		
		Point nextPoint = new Point(nowPoint.x, nowPoint.y);
		
		while(MAP[nextPoint.x][nextPoint.y+moveRight.y] =='.' )
			nextPoint.y = nextPoint.y + moveRight.y;
		
		if(MAP[nextPoint.x][nextPoint.y + moveRight.y] == 'O') {
			nextPoint.y = nextPoint.y + moveRight.y;
		}else {
			MAP[nowPoint.x][nowPoint.y] = '.';
			if(color == RED)
				MAP[nextPoint.x][nextPoint.y] = 'R';
			else
				MAP[nextPoint.x][nextPoint.y] = 'B';
		}
		return nextPoint;			
	}
	
	static void movePointLeft(Point red, Point blue) {
	
		Point nextRedP;
		Point nextBlueP; 
		
		// 공 이동시키기
				// 움직이려는 방향 끝에 가까운 공부터 움직인다.
		
		if(red.y < blue.y) {
			nextRedP = mLeft(red, RED);		
			nextBlueP = mLeft(blue, BLUE);	
		}else {
			nextBlueP = mLeft(blue, BLUE);
			nextRedP = mLeft(red, RED);	
		}
		
		traceRedBall.push(nextRedP);
		traceBlueBall.push(nextBlueP);
		
	}
	
	
	static Point mLeft(Point nowPoint, int color) {		
			
		char c;
		Point nextPoint = new Point(nowPoint.x, nowPoint.y);
		
		while(MAP[nextPoint.x][nextPoint.y+moveLeft.y] == '.' ) {
			c = MAP[nextPoint.x][nextPoint.y+moveLeft.y];
			nextPoint.y = nextPoint.y + moveLeft.y;
		}
		
		if(MAP[nextPoint.x][nextPoint.y+moveLeft.y] == 'O') {
			nextPoint.y = nextPoint.y + moveLeft.y;
		}else {
			MAP[nowPoint.x][nowPoint.y] = '.';
			if(color == RED) {
				MAP[nextPoint.x][nextPoint.y] = 'R';
			}
			else
				MAP[nextPoint.x][nextPoint.y] = 'B';
		}
		return nextPoint;			
	}
}
