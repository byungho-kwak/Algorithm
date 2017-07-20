import java.util.Arrays;
import java.util.Scanner;

import java.util.Stack;

public class Main {
	  
    public int height(int num, int[][] data, int len){
    	int maxheight = 0 ;
    	
    	maxheight = Math.max(data[num][2] - data[num][1], data[num][3] - data[num][1]);
    	int temp=0;
    	
    	for(int i=2; i<=len-2; i++) {
    		temp = data[num][i+2] - data[num][i];
    		if(maxheight < temp)
    			maxheight = temp; 
    	}
    	
    	temp = data[num][len] - data[num][len-1];
    	if(maxheight < temp)
			maxheight = temp; 
    	
    	return maxheight;
    }

	
	public static void main(String[] args) {
		
		int[][] input;
		int TC;
		int[] inputCnt;
		
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		input = new int[TC+1][10001];
		inputCnt = new int[TC+1];
		
		for(int i=1; i<=TC; i++) {
			inputCnt[i] = sc.nextInt();
			for(int j=1; j<=inputCnt[i]; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		int maxHeight=0;
		Main H = new Main();
		for(int i=1; i<=TC; i++) {

			Arrays.sort(input[i], 1, inputCnt[i]+1);
			for(int j=1; j<=inputCnt[i]; j++)
				System.out.print(input[i][j]+" ");
			
			System.out.println();
			maxHeight = H.height(i, input, inputCnt[i]);
			
			System.out.println(maxHeight);
		}
	}
}
