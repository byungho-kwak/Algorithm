import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		StringBuilder[] A = new StringBuilder[T+1];
		StringBuilder[] B = new StringBuilder[T+1];
		
		String input;
		
		for(int i=1; i<=T; i++) {
			
			input = sc.next();
			
			A[i] = new StringBuilder(input);
			
			input = sc.next();
			
			B[i] = new StringBuilder(input);
			
			sc.nextLine();
			
		}
	
		int idx=0;
		int offset=0;
		int moveCnt=0;
		char temp;
		
		for(int i=1; i<=T; i++) {
			
			while(A[i].length()-1 >= idx) {
	
				if(A[i].charAt(idx) != B[i].charAt(idx)) {
					
					while(B[i].charAt(idx+offset) != A[i].charAt(idx))
							offset++;
					
					temp = B[i].charAt(idx+offset);
					B[i].setCharAt(idx+offset, B[i].charAt(idx));
					B[i].setCharAt(idx, temp);
				}
				
				idx++;
				moveCnt+=offset;
				offset=0;
			}
			
			System.out.println(moveCnt);
			idx=0;
			moveCnt=0;
		}
	}
}
