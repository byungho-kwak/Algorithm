import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int TC;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Stack<Integer> queue = new Stack<>();
			
			long input = sc.nextInt();
			int[] a = new int[2];
			a[0]=4;
			a[1]=7;
		
			int range=2;
			int digit=1;
			int beforeRange;
			
			while(true) {
				if(range-input >= 0) {
					beforeRange=(range-2)/2;
					break;
				} 
				else {
					digit+=1;
					range=range*2+2;
				}
			}
			int idx = (int) (input-beforeRange-1);
			long reminder=0;
			int quotient=idx;
			
			while(true) {
				if(quotient==1 || quotient==0) {
					queue.add(a[quotient]);
					break;
				}
				reminder=quotient%2;
				quotient=quotient/2;
				queue.add(a[(int) reminder]);

			}
				
			if(queue.size() < digit) {
				while(true) {
					if(queue.size() == digit)
						break;
					else
						queue.add(4);
				}
			}

			System.out.println("Case #"+(test_case+1));
			while(!queue.isEmpty())
				System.out.print(queue.pop());
			
			System.out.println();
		}
		
	}
}
