import java.util.Arrays;
import java.util.Scanner;

import java.util.Stack;

public class Main {
	static int TC;
	static int[] N;
	static int[] len;
	static int[][] numX;
	static int[][] numY;
	static int[][] circle;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		N = new int[TC+1];
		len = new int[TC+1];
		numX = new int[TC+1][10];
		numY = new int[TC+1][10];
		circle = new int[TC+1][101];
		
		for(int i=1; i<=TC; i++) {
			N[i] = sc.nextInt();
			len[i] = sc.nextInt();
			
			for(int j=1; j<=len[i]; j++) 
				numX[i][j] = sc.nextInt();			
			for(int j=1; j<=len[i]; j++) 
				numY[i][j] = sc.nextInt();
			for(int j=1; j<=N[i]; j++)
				circle[i][j] = sc.nextInt();
		}
		
		for(int i=1; i<=TC; i++)
			System.out.println(Circle(i));
		
	}
	
	static int Circle(int tcN) {
		int success = 0;
		
		// 자릿수 곱하기로해서 숫자 만들기
		
		int k=1;
		int X=0;
		int Y=0;
		int Z=0;
		
		for(int i=len[tcN]; i>=1; i--) {
			X += numX[tcN][i]*k;
			Y += numY[tcN][i]*k;
			k=k*10;
		}
		k=1;
		
		// 원판에서 Z값 구하기
		for(int i=N[tcN]; i>=1; i--) {
			
			//Z값 계산
			for(int L=0; L<len[tcN]; L++) {
	
				if(i-L < 1 )
					Z += circle[tcN][(i-L)+N[tcN]]*k;
				else
					Z += circle[tcN][i-L]*k;
					
				k=k*10;
			}
			
			// Z 비교
			if(X<=Z && Z<=Y)
				success++;
			
			//초기화		
			Z=0;		
			k=1;
		}
		return success;
	}
}
