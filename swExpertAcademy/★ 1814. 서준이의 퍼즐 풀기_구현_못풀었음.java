
/*
 * 1814. �������� ���� Ǯ��
 * ���� : ����
 * ���� ������� ��Ǯ����(���� DFS������ �ð��ʰ�)
 */

import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    static int[] row, column;
    static int N;
 
    public static void main(String...msg) {

       Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
         
        for(int T = 1; T<= TestCase; T++) {
            N = sc.nextInt();

            row = new int[N];
            column = new int[N];
            int rSum=0, cSum=0;
            
            for(int i=0; i<N; i++) {
            	row[i] = sc.nextInt();
            	rSum+=row[i];
            }
            for(int i=0; i<N; i++) {
            	column[i] = sc.nextInt();
            	cSum+=column[i];
            }
            
            Arrays.sort(row);
            Arrays.sort(column);
            
            int flag = 0;
            int sum = rSum;
            
            // ���� Ǫ�� ����� ����
            if(rSum!=cSum) {
            	flag=1;
            }
            // ���� Ǯ�� ������(rSum==cSum)
            else {
            	for(int i=N-1; i>=0; i--) {
            		for(int j=N-1; j>=0; j--) {
            			if(row[i]>0 && column[j]>0) {
            				row[i]--;
            				column[j]--;
            				sum--;
            			}
            			// ���� Ǫ�� ����� 2�� �̻���
            			// row�� �� ��µ�, column�� ������, �ٸ� column�� ���� ���� �� ������ Ǫ�� ����� 2�� �̻��� �Ǵ� ����
            			else if((sum>0) && row[i]==0 && column[j]>0) {
            				flag=1;
            				i=0;
            				break;
            			}
            		}
            	}
            }
            
            String ans;
            if(flag==1)
            	ans = "No";
            else
            	ans = "Yes";
            
            System.out.println("#"+T+" "+ans);
        }
    }
}
