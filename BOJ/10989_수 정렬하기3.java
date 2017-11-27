import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/*
 Scanner�� System.out.println�� �ð��� ���� ��Ƹ���
 bufferReader �� outputStream ��� �� ������� ����
*/
public class Main {
	static int Answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		
		int[] a = new int[10001];
		
		int temp=0;
		
		for(int i=0; i<n; i++) {
			temp = Integer.parseInt(br.readLine().trim());
			a[temp]++;
		}
		
		
		OutputStream os = new BufferedOutputStream(System.out);

		for(int i=1; i<=10000; i++) {
			if(a[i]!=0) {
				for(int j=1; j<=a[i]; j++)
					os.write((i + "\n").getBytes());
			}
		}
		os.flush();
	}
}
