import java.util.Scanner;
import java.util.Stack;

/*
	Ʋ�� ���̽� : (()((()))(()()(())))
	��踦 ������ * �� �������� �� �κп��� ���� �ִ� ���� ������ ���� ����
	(��谡 ** ���������� �ִ� ���, �� ��������ϴµ� �׷��� ���ߴ�)
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
					// �� �κп��� �����̾���. 
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
