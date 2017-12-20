import java.util.Scanner;

public class Main {
	static int[] a;
	static int ans;
	static String A;
	static String B;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			A = sc.next();
			B = sc.next();
			ans = A.length();
			String temp;
			int i = 0;
			for (; i <= A.length() - B.length();) {
				temp = A.substring(i, i + B.length());
				if(temp.equals(B)) {
					ans-=(B.length()-1);
					i+=B.length();
				} else
					i++;
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}