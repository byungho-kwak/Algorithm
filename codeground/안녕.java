import java.util.Scanner;

public class Main {
	static int Answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();
		for (int test_case = 0; test_case < T; test_case++) {
			Answer=0;

			String hello = sc.nextLine();
			
			int h=0;
			int e=0;
			int l=0;
			int o=0;
			
			for(int i=0; i<hello.length(); i++) {
				if(hello.charAt(i)=='h')
					h++;
				else if(hello.charAt(i)=='e')
					e++;
				else if(hello.charAt(i)=='l')
					l++;
				else if(hello.charAt(i)=='o')
					o++;
			}
			
			while(h>0 && e>0 && l>1 && o>0) {
				h--;
				e--;
				l=l-2;
				o--;
				Answer++;
			}
	
			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
			
			}
		}
}
