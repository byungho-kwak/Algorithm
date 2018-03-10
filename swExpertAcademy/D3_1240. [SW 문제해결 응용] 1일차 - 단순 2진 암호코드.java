
/*
 * 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
 * 단순 구현 문제
*/

import java.util.Scanner;

public class Main {
	
	static String[] val = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
	static int N,M,evenSum, oddSum, ans;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		String strArr[];
		for(int testcase=1; testcase<=T; testcase++) {
			evenSum=0;
			oddSum=0;
			ans=0;
			N = sc.nextInt();
			M = sc.nextInt();
			sc.nextLine();
			strArr = new String[N];
			for(int i=0; i<N; i++) 
				strArr[i] = sc.nextLine();
			
			for(int i=0; i<N; i++) {
				if(!isZero(strArr[i])) {
					String secret = strArr[i]; 
					int idx=M-1;
					while((secret.charAt(idx)-48)!=1) {
						idx--;
					}
					
					int evevStartIdx=0, evenEndIdx=0, oddStartIdx=0, oddEndIdx=0;;
					String oddStr, evenStr;

					for(int j=0; j<=3; j++) {
						oddEndIdx = (idx+1)-7 - 14*j;
						oddStartIdx = oddEndIdx-7;
						
						evenEndIdx = oddEndIdx+7;
						evevStartIdx = evenEndIdx-7;
						
						oddStr = secret.substring(oddStartIdx, oddEndIdx);
						evenStr = secret.substring(evevStartIdx, evenEndIdx);
						
						for(int k=0; k<val.length; k++) {
							if(val[k].equals(oddStr)) {
								oddSum+=k;
							}
							if(val[k].equals(evenStr)) {
								evenSum+=k;
							}
						}
					}
					
					ans=oddSum+evenSum;
					if((oddSum*3+evenSum)%10!=0) 
						ans=0;
					System.out.println("#"+testcase+" "+ans);
					break;
				}
			}
		}
	}
	static boolean isZero(String str) {
		for(int i=0; i<M; i++) {
			if(str.charAt(i)-48!=0)
				return false;
		}
		return true;
	}
}