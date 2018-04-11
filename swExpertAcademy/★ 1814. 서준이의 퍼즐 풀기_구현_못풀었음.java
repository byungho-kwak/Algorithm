
/*
 * 1814. 서준이의 퍼즐 풀기
 * 유형 : 구현
 * 문제 어려워서 못풀었음(기존 DFS로직은 시간초과)
 */

import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    static int[] row, column;
    static int N;
 
    public static void main(String...msg) {

       Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
         
        for(int T = 1; T<= TestCase; T++) {
            N = sc.nextInt();

            row = new int[N];
            column = new int[N];
            int rSum=0, cSum=0;
            
            for(int i=0; i<N; i++) {
            	row[i] = sc.nextInt();
            	rSum+=row[i];
            }
            for(int i=0; i<N; i++) {
            	column[i] = sc.nextInt();
            	cSum+=column[i];
            }
            
            Arrays.sort(row);
            Arrays.sort(column);
            
            int flag = 0;
            int sum = rSum;
            
            // 퍼즐 푸는 방법이 없음
            if(rSum!=cSum) {
            	flag=1;
            }
            // 퍼즐 풀기 가능함(rSum==cSum)
            else {
            	for(int i=N-1; i>=0; i--) {
            		for(int j=N-1; j>=0; j--) {
            			if(row[i]>0 && column[j]>0) {
            				row[i]--;
            				column[j]--;
            				sum--;
            			}
            			// 퍼즐 푸는 방법이 2개 이상임
            			// row는 다 썼는데, column이 남으면, 다른 column에 점을 찍을 수 있으니 푸는 방법이 2개 이상이 되는 것임
            			else if((sum>0) && row[i]==0 && column[j]>0) {
            				flag=1;
            				i=0;
            				break;
            			}
            		}
            	}
            }
            
            String ans;
            if(flag==1)
            	ans = "No";
            else
            	ans = "Yes";
            
            System.out.println("#"+T+" "+ans);
        }
    }
}
