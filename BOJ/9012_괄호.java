import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<tc; i++) {
			String input = sc.nextLine();
			boolean result=true;
			Stack<Character> s = new Stack<>();
			for(int idx=0; idx<input.length(); idx++) {
				
				if(input.charAt(idx)=='(')
					s.push(input.charAt(idx));
				else {
					if(s.isEmpty()) {
						result=false;
						break;
					}
					else s.pop();
				}
			}
			if(!s.isEmpty())
				result=false;
			System.out.println(result ? "Yes" : "No");
		}
	}
}
