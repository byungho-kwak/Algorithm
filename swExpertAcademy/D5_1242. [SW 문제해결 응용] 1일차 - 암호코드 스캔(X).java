
import java.util.Scanner;

public class Main {
	static int[] KEY = {3211, 2221, 2122, 1411, 1132, 1231, 1114, 1312, 1213, 3112};
	static String[] HexToBin = {"0000", "0001", "0010", "0011", "0100", "0101", 
			"0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
	
	static int N,M,ans;
	static int map[][];
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
//		KEY = new int[3300];
//		KEY[3211]=0; KEY[2221]=1; KEY[2122]=2; KEY[1411]=3; KEY[1132]=4; 
//		KEY[1231]=5; KEY[1114]=6; KEY[1312]=7; KEY[1213]=8; KEY[3112]=9;
		
		int T = sc.nextInt();
		String str;
		StringBuilder buf;
		for(int testcase=1; testcase<=T; testcase++) {
			ans=0;
			N = sc.nextInt();
			M = sc.nextInt();
			sc.nextLine();
			map = new int[2000][2000];
			for(int i=0; i<N; i++) {
				buf = new StringBuilder();
				str = sc.nextLine();
				for(int j=0; j<M; j++) {
					if(str.charAt(j)>'9') {
						buf.append(HexToBin[(str.charAt(j)-'A')+10]);
					} 
					else {
						buf.append(HexToBin[str.charAt(j)-'0']);
					}
				}
				
				str = buf.toString();
				for(int j=0; j<buf.length(); j++) {
					map[i][j] = str.charAt(j)-48;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=M*4-1; j>=55; j--) {
					if(map[i][j]==1) {
						int scale = calcScale(i, j);
						ans+=secretCheck(i,j,scale);
						j-=56*scale;
					}
				}
			}
			
			System.out.println("#"+testcase+" "+ans);
			
		}
	}
	
	static int calcScale(int i, int j) {
		int cnt=0;
		int inverseCnt=0;
		int value=1;
		while(inverseCnt<4) {
			if(map[i][j]!=value) {
				inverseCnt++;
				if(value==1)
					value=0;
				else
					value=1;
			}
			cnt++;
			j--;
		}
		cnt--;
		return cnt/7;
	}
	
	static int secretCheck(int i, int j, int scale) {
		int evenSum=0, oddSum=0; 
		int idx=j;
		int value=1;
		int key, cnt;
		
		for(int k=idx; k>idx-56*scale; k-=14*scale) {
			key=0;
			cnt=0;
			value=map[i][k-7*scale+1];
			//Â¦¼ö
			
			for(int l=k-7*scale+1; l<=k; l++) {
				
				if(map[i][l]!=value) {
					key=key*10+cnt/scale;
					value=map[i][l];
					cnt=0;
				}
				cnt++;
				
			}
			key=key*10+cnt/scale;
			for(int v=0; v<10; v++) {
				if(key==KEY[v]) {
					evenSum+=v;
					break;
				}
			}
			//evenSum+=KEY[key];
			
			key=0;
			cnt=0;
			value=map[i][k-14*scale+1];
			for(int l=k-14*scale+1;  l<=k-7*scale; l++) {
				if(map[i][l]!=value) {
					key=key*10+cnt/scale;
					value=map[i][l];
					cnt=0;
				}
				cnt++;
			}
			key=key*10+cnt/scale;
			for(int v=0; v<10; v++) {
				if(key==KEY[v]) {
					oddSum+=v;
					break;
				}
			}
			//oddSum+=KEY[key];
			
		}
		
		for(int x=i; x<N; x++) {
			if(map[x][idx]!=1) {
				x=N;
				break;
			}
			for(int y=idx; y>idx-56*scale; y--) {
				map[x][y]=0;
			}	
		}
		
		if((oddSum*3+evenSum)%10!=0)
			return 0;
		else
			return oddSum+evenSum;
	}
	
}