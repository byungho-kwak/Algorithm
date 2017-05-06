import java.awt.Point;
import java.util.*;
import java.util.Arrays;

public class Test {  
	/*
	<�ֻ���(Die) �� ����>
	  	  2
		4 1 3
	  	  5
	  	  6
	*/
	static int[] Die = new int[7];
	static Point nowPoint;
	static int[][] MAP = new int[21][21];
	static int N,M;
	static int[] recommand = new int[1001];
	static int recmmdNum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		nowPoint = new Point(sc.nextInt()+1, sc.nextInt()+1);
		recmmdNum = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				MAP[i][j] = sc.nextInt();
			}
		}
		
		// �������� �Է�
		for(int i=1; i<=recmmdNum; i++)
			recommand[i] = sc.nextInt();
		
		// �ֻ��� 0���� �ʱ�ȭ
		for(int i=1; i<=6; i++) 
			Die[i] = 0;
		
		Point beforePoint;
		for(int i=1; i<= recmmdNum; i++) {
			//�ֻ��� �̵� �� ���
			beforePoint = nowPoint;
			
			// �ֻ��� �̵�
			nowPoint = NextPoint(recommand[i]);
			
			// �̵��� ��ġ�� ���� ���� ������ ����
			if(nowPoint.x <= N && nowPoint.x >0 && nowPoint.y <= M && nowPoint.y > 0) {
				// ���� �̵��� ����, �ֻ��� ��ġ ������ ���� �� �̵�
				dieMove(recommand[i]);
				
				// ���� ���ǿ� ���� ����
				if(MAP[nowPoint.x][nowPoint.y] == 0) {
					MAP[nowPoint.x][nowPoint.y] = Die[6];
				}
				else {
					Die[6] = MAP[nowPoint.x][nowPoint.y];
					MAP[nowPoint.x][nowPoint.y] = 0;
				}
				
				System.out.println(Die[1]);
			}
			// ���� ���̸� skip
			else
				nowPoint = beforePoint;	
		}
	}
	
	static Point NextPoint(int direction) {
		Point nextPoint = null;
		// 1: ��, 2: ��, 3: ��, 4: ��
	switch (direction) {
	case 1 :
		nextPoint = new Point(nowPoint.x, nowPoint.y+1);
		break;
	case 2 : 
		nextPoint = new Point(nowPoint.x, nowPoint.y-1);
		break;
	case 3:
		nextPoint = new Point(nowPoint.x-1, nowPoint.y);
		break;
	case 4 :
		nextPoint = new Point(nowPoint.x+1, nowPoint.y);
		break;
	}
		return nextPoint;
	}
	
	static void dieMove(int direction) {
		int temp;
		// 1: ��, 2: ��, 3: ��, 4: ��
		
		switch (direction) {
		// ������ �̵�
		case 1 :
			temp = Die[3];
			Die[3] = Die[1];
			Die[1] = Die[4];
			Die[4] = Die[6];
			Die[6] = temp;
			break;
		// ��
		case 2 :
			temp = Die[3];
			Die[3] = Die[6];
			Die[6] = Die[4];
			Die[4] = Die[1];
			Die[1] = temp;
			break;
		// ��
		case 3 :
			temp = Die[1];
			Die[1] = Die[5];
			Die[5] = Die[6];
			Die[6] = Die[2];
			Die[2] = temp;
			break;
		// ��
		case 4 :
			temp = Die[1];
			Die[1] = Die[2];
			Die[2] = Die[6];
			Die[6] = Die[5];
			Die[5] = temp;
			break;
		}
	}
}