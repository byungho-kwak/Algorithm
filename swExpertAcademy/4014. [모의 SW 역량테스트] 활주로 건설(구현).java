import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int ans;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int x = sc.nextInt();
			
			map = new int[N][N];
			ans=0;
			
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					map[i][j] = sc.nextInt();
			
			// → 
			for(int i=0; i<N; i++) {
				boolean isSlopeRoad = true;
				// 라인 마다 경사로 체크 표시
				boolean[] isChecked = new boolean[N];
				Arrays.fill(isChecked, false);
				for(int j=0; j<N-1; j++) {
					int gap = map[i][j]-map[i][j+1];
					if(gap==0) 
						continue;
					else if (gap==-1) {
						for(int k=j; k>j-x+1; k--) {
							// 범위 체크 및 가능성 확인
							if(k-1>=0) {
								int flat = map[i][k] - map[i][k-1];
								if(flat!=0 || isChecked[k] || isChecked[k-1])
									isSlopeRoad = false;
							} else {
								isSlopeRoad = false;
							}
						}
						
						if(!isSlopeRoad)
							break;
						else {
							for(int k=j; k>=j-x+1; k--) {
								isChecked[k] = true;
							}
						}
					}
					else if(gap==1){
						// 경사로 깔기 가능성 확인
						for(int k=j+1; k<j+1+x-1; k++) {
							// 범위 체크 및 가능성 확인
							if(k+1<N) {
								int flat = map[i][k] - map[i][k+1];
								if(flat!=0 || isChecked[k] || isChecked[k+1])
									isSlopeRoad = false;
							} else {
								isSlopeRoad = false;
							}
						}
						
						if(!isSlopeRoad)
							break;
						else {
							for(int k=j+1; k<=j+1+x-1; k++) {
								isChecked[k] = true;
							}
							j+=x-1;
						}
					}
					//gap>1 || gap<-1
					else {
						isSlopeRoad = false;
						break;
					}
				}
				//System.out.println(i+"줄 성공여부 : "+isSlopeRoad);
				if(isSlopeRoad)
					ans++;
			}
			//System.out.println("////////////////////");
			// ↓
			for(int j=0; j<N; j++) {
				boolean isSlopeRoad = true;
				boolean[] isChecked = new boolean[N];
				Arrays.fill(isChecked, false);
				for(int i=0; i<N-1; i++) {
					int gap = map[i][j]-map[i+1][j];
					if(gap==0) 
						continue;
					else if (gap==-1) {
						for(int k=i; k>i-x+1; k--) {
							// 범위 체크 및 가능성 확인
							if(k-1>=0) {
								int flat = map[k][j] - map[k-1][j];
								if(flat!=0 || isChecked[k] || isChecked[k-1])
									isSlopeRoad = false;
							} else {
								isSlopeRoad = false;
							}
						}
						
						if(!isSlopeRoad)
							break;
						else {
							for(int k=i; k>=i-x+1; k--) {
								isChecked[k] = true;
							}
						}
					}
					else if(gap==1){
						// 경사로 깔기 가능성 확인
						for(int k=i+1; k<i+1+x-1; k++) {
							// 범위 체크 및 가능성 확인
							if(k+1<N) {
								int flat = map[k][j] - map[k+1][j];
								if(flat!=0 || isChecked[k] || isChecked[k+1])
									isSlopeRoad = false;
							} else {
								isSlopeRoad = false;
							}
						}
						
						if(!isSlopeRoad)
							break;
						else {
							for(int k=i+1; k<=i+1+x-1; k++)  {
								isChecked[k] = true;
							}
							i+=x-1;
						}
					}
					//gap>1 || gap<-1
					else {
						isSlopeRoad = false;
						break;
					}
				}
				//System.out.println(j+"줄 성공여부 : "+isSlopeRoad);
				if(isSlopeRoad)
					ans++;
			}
			System.out.println("#"+t+" "+ans);
		}
	}

}

