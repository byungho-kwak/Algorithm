import java.util.Scanner;

public class Solution {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int t=0; t<TC; t++) {
			
			int daily = sc.nextInt();
			int monthly = sc.nextInt();
			int tmonthly = sc.nextInt();
			int yearly = sc.nextInt();

			int[] fee = new int[13];
			int[] dailyFee = new int[13];
			int[] result = new int[13];
			
			for(int i=1; i<=12; i++)
				fee[i] = sc.nextInt();
			
			// daily calc
			for(int i=1; i<=12; i++) 
				result[i]=fee[i]*daily;
			
			//monthly calc
			for(int i=1; i<=12; i++) {
				if(result[i]>monthly)
					result[i]=monthly;
			}
			
			//tmonthly calc
			for(int i=1; i<=12; i++) {
				if(i==1) {
					if(result[i]>tmonthly)
						result[i]=tmonthly;
				}
				else if(i==2 || i==3) {
					if(result[i-1]+result[i]>tmonthly)
						result[i]=tmonthly;
					else
						result[i]+=result[i-1];
				}
				else
					result[i] = Math.min(tmonthly+result[i-3], result[i]+result[i-1]);
			}
			
			if(result[12]>yearly)
				result[12] = yearly;
			
			System.out.println("#"+(t+1)+ " "+result[12]);
		}
	}
}