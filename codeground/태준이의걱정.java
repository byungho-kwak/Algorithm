import java.util.Scanner;

class Main {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			
			int go = sc.nextInt();
			int back = sc.nextInt();
			int distance = sc.nextInt();
			int move=0;
			int time=0;
			
			while(true) {
				move+=go;
				if(move>=distance) {
					time++;
					break;
				}
				else {
					move-=back;
					time++;
				}
				
			}
			System.out.println("Case #"+(test_case+1));
			System.out.println(time);
		}
	}
}