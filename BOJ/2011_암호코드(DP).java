import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long mod = 1000000;
		String input = sc.nextLine();
		long[] DP = new long[input.length()+1];
		
		DP[0] = 1;
		
		if(input.charAt(0) == '0')
			DP[1] = 0;
		else
			DP[1] = 1;
		
		for(int i=1; i<=input.length()-1; i++) {
			
			if(input.charAt(i) == '0'){
					if(input.charAt(i-1)=='1' || input.charAt(i-1)=='2')
						DP[i+1] = DP[i-1]%mod;
					else
						DP[i+1] = DP[i];
			}
			else {
		
				// 肋给 内爹沁带 家胶
//				if((input.charAt(i)> '0' && input.charAt(i)<='6') && 
//						(input.charAt(i-1)=='1' || input.charAt(i-1)=='2'))
//							DP[i+1] = (DP[i] + DP[i-1])%mod;
				
				
				if((input.charAt(i-1)=='1' && input.charAt(i)>'0') || 
						(input.charAt(i-1)=='2' && (input.charAt(i)>'0' && input.charAt(i) <='6')))
							DP[i+1] = (DP[i] + DP[i-1])%mod;
		
				else if((input.charAt(i)> '0' && input.charAt(i)<='6') && DP[i] == 0)
					DP[i+1] = 1;
				else
					DP[i+1] = DP[i]%mod;
			}
			
		}
		
		System.out.println(DP[input.length()]);
	}
}
