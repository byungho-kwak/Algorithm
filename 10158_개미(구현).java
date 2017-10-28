import java.awt.Point;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int y = sc.nextInt();
		int x = sc.nextInt();
		
		int time = sc.nextInt();
		
		Point[] vector = new Point[4];
		vector[0]=new Point(1,1);	// ↘
		vector[1]=new Point(1,-1);	// ↙
		vector[2]=new Point(-1,-1);	// ↖
		vector[3]=new Point(-1,1);	// ↗
		
		int v=0;
		
		for(int i=0; i<time; i++) {
			if(!(x+vector[v].x>=0 && x+vector[v].x<=N && y+vector[v].y>=0 && y+vector[v].y<=M)){
				if(v==0) {
					if(y+vector[v].y>M && x+vector[v].x>N)
						v=2;
					else if(y+vector[v].y>M)
						v=1;
					else
						v=3;
				}
				else if(v==1) {
					if(y+vector[v].y<0 && x+vector[v].x>N)
						v=3;
					else if(x+vector[v].x>N)
						v=2;
					else
						v=0;
				}
				else if(v==2) {
					if(y+vector[v].y<0 && x+vector[v].x<0)
						v=0;
					else if(y+vector[v].y<0)
						v=3;
					else
						v=1;
				}
				else {
					if(y+vector[v].y>M && x+vector[v].x<0)
						v=1;
					else if(y+vector[v].y>M)
						v=2;
					else
						v=0;
				}
			}
			x+=vector[v].x;
			y+=vector[v].y;
		}
		System.out.println(y+" "+x);
	}
}
/*
 * 모범답안
 * 
 import java.util.Scanner;
	public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w,h,p,q,T,x = 1,y = 1,t = 0;
		w = sc.nextInt();
		h = sc.nextInt();
		p = sc.nextInt();
		q = sc.nextInt();
		T = sc.nextInt();
		
		while(t < T) {
			if(p == w) {
				x = -1;
			}
			else if(p == 0) {
				x = 1;
			}
			if(q == h) {
				y = -1;
			}
			else if(q == 0) {
				y = 1;
			}
			p += x;
			q += y;
			t++;
		}
		System.out.println(p + " " + q);
	}
}
 */ 
