import java.awt.Point;
import java.util.*;
import java.util.Arrays;

public class Main {  
	
	static Point cleanerPoint;
	
	// 0: ��		1:��		2:��		3:��
	static int cleanerDirection;
	static int[][] MAP = new int[51][51];
	static int N,M;
	static int cleanSpace = 0;
	static int count = 0;
	
	// 0 : �����
	// 1 : ��
	// 2 : û���� ��
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		//û�ұ� ��ġ �� ����
		cleanerPoint = new Point(sc.nextInt()+1, sc.nextInt()+1);
		cleanerDirection = sc.nextInt();
		
		for(int i=1; i<=N; i++)
			for(int j=1; j<=M; j++)
				MAP[i][j] = sc.nextInt();
		
		cleanMap(cleanerDirection, cleanerPoint);

		System.out.println(cleanSpace);
	}
	
	// 2ǥ��
	static void cleanMap(int direction, Point now) {
		// Direction :  0: ��		1:��		2:��		3:��
		Point left = LeftSet(direction, now);
		Point right = RightSet(direction, now);
		Point up = UpSet(direction, now);
		Point down = DownSet(direction, now);
		
		while(true) {
		//	System.out.println(count);
			count++;
			// 1. ���� ��ġ�� û���Ѵ�.
			if(MAP[now.x][now.y] == 0)
				MAP[now.x][now.y] = 2;
			
			// 2. ���� ��ġ���� ���� ������ �������� ���ʹ������ ���ʴ�� Ž���� �����Ѵ�.
			
			// ��濡 û���� ������ ����
			if(MAP[left.x][left.y] !=0 && MAP[right.x][right.y] !=0 && MAP[up.x][up.y] !=0 && MAP[down.x][down.y] !=0) {
				// 2-4. ���� ������ ���̶� ������ ���ϸ�
				if(MAP[down.x][down.y] == 1) {
					break;
				}
				// 2-3. ������ �����ϴٸ� ���� ��ġ�� ����
				else {
					//System.out.println("2-3");
					switch(direction) {
					case 0 : 
						now = new Point(now.x+1,now.y);
						break;
					case 1 : 
						now = new Point(now.x,now.y-1);
						break;
					case 2 : 
						now = new Point(now.x-1,now.y);
						break;
					case 3 : 
						now = new Point(now.x,now.y+1);
						break;
					}
					
					left = LeftSet(direction, now);
					right = RightSet(direction, now);
					up = UpSet(direction, now);
					down = DownSet(direction, now);
				}
			}
			//2-2. ���� ���⿡ û���� ������ ������ �� �� ������ û�� �� ������ �����ִٸ�
			if(MAP[left.x][left.y] != 0 && (MAP[right.x][right.y] == 0 || MAP[up.x][up.y] == 0 || MAP[down.x][down.y] == 0)) {
				//System.out.println("2-2");
				// ���� �������� ȸ��
				switch(direction) {
				case 0 : 
					direction = 3;
					break;
				case 1 : 
					direction = 0;
					break;
				case 2 : 
					direction = 1;
					break;
				case 3 : 
					direction = 2;
					break;
				}
				left = LeftSet(direction, now);
				right = RightSet(direction, now);
				up = UpSet(direction, now);
				down = DownSet(direction, now);
			}
			
			// 2-1. ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�,
			if(MAP[left.x][left.y] == 0 ) {
				 //�� �������� ȸ���� ���� �� ĭ�� �����ϰ�
				switch(direction) {
				case 0 : 
					direction = 3;
					now = new Point(now.x,now.y-1);
					break;
				case 1 : 
					direction = 0;
					now = new Point(now.x-1,now.y);
					break;
				case 2 : 
					direction = 1;
					now = new Point(now.x,now.y+1);
					break;
				case 3 : 
					direction = 2;
					now = new Point(now.x+1,now.y);
					break;
				}
				left = LeftSet(direction, now);
				right = RightSet(direction, now);
				up = UpSet(direction, now);
				down = DownSet(direction, now);

				//  1������ �����Ѵ�.
			}
		}
		
		for(int i=1; i<=N-1; i++) 
			for(int j=1; j<=M-1; j++) 
				if(MAP[i][j] == 2) 
					cleanSpace++;
	
	}
	
	static Point UpSet(int direction, Point now) {
		
		Point up = null;
		
		switch(direction) {
		case 0 : 
			up = new Point(now.x-1,now.y);
			break;
		case 1 : 
			up = new Point(now.x,now.y+1);
			break;
		case 2 : 
			up = new Point(now.x+1,now.y);
			break;
		case 3 : 
			up = new Point(now.x,now.y-1);
			break;
		}
		return up;
	}
	
	static Point DownSet(int direction, Point now) {
		
		Point down = null;
		
		switch(direction) {
		case 0 : 
			down  = new Point(now.x+1,now.y);
			break;
		case 1 : 
			down  = new Point(now.x,now.y-1);
			break;
		case 2 :
			down  = new Point(now.x-1,now.y);
			break;
		case 3 : 
			down  = new Point(now.x,now.y+1);
			break;
		}
		return down;
	}
	static Point LeftSet(int direction, Point now) {
		
		Point left= null;
		
		switch(direction) {
		case 0 : 
			left  = new Point(now.x,now.y-1);
			break;
		case 1 : 
			left  = new Point(now.x-1,now.y);
			break;
		case 2 :
			left  = new Point(now.x,now.y+1);
			break;
		case 3 : 
			left  = new Point(now.x+1,now.y);
			break;
		}
		
		return left;
	}
	static Point RightSet(int direction, Point now) {
		
		Point right = null;
		
		switch(direction) {
		case 0 : 
			right = new Point(now.x,now.y+1);
			break;
		case 1 : 
			right = new Point(now.x+1,now.y);
			break;
		case 2 :
			right = new Point(now.x,now.y-1);
			break;
		case 3 : 
			right = new Point(now.x-1,now.y);
			break;
		}
		
		return right;
	}
}