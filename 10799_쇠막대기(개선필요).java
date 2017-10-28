import java.util.Scanner;
import java.util.Stack;

/*
	틀린 케이스 : (()((()))(()()(())))
	경계를 나누는 * 가 없어져야 할 부분에서 남아 있는 것이 문제의 오답 원인
	(경계가 ** 연속적으로 있는 경우, 다 없애줘야하는데 그러지 못했다)
*/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		
		int i=0;
		int nowLaser=0;
		int result=0;
		Stack<Character> s = new Stack<Character>();
		Stack<Integer> laser = new Stack<Integer>();
		
		while(i<a.length()) {

			if((a.charAt(i)!=')' && a.charAt(i)!='(') || (s.isEmpty() && a.charAt(i)==')')) {
				break;
			}
			else if(i+1<a.length() && (a.charAt(i)=='(' && a.charAt(i+1)==')')) {
				if(!s.isEmpty())
					nowLaser++;
				i++;
			}
			else if(nowLaser!=0 && a.charAt(i)=='(') {
				s.push('*');
				s.push('(');
				laser.push(nowLaser);
				nowLaser=0;
			}
			else if(!s.isEmpty() && a.charAt(i)==')') {
				
				if(s.peek()=='*') {
					// 이 부분에서 말썽이었다. 
					while(s.peek()=='*') {
						s.pop();
						nowLaser+=laser.pop();
					}
				}
				result+=nowLaser+1;
				s.pop();
				if(s.isEmpty())
					nowLaser=0;
			}
			else if(a.charAt(i)=='(')
				s.push(a.charAt(i));
			
			i++;
		}

			System.out.println(result);

	}
}
