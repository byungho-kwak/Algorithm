import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] start = new int[2];
		int[] end = new int[2];
		int n;
		int x,y,r;
		int SdisX, SdisY;
		int EdisX, EdisY;
		int ans;
		int tc = sc.nextInt();
		for(int t=0; t<tc; t++) {
			ans=0;
			start[0] = sc.nextInt();
			start[1] = sc.nextInt();
			end[0] = sc.nextInt();
			end[1] = sc.nextInt();
			
			n = sc.nextInt();
			for(int i=0; i<n; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				r = sc.nextInt();
				
				SdisX = (int)Math.pow(start[0]-x, 2);
				SdisY = (int)Math.pow(start[1]-y, 2);
				
				EdisX = (int)Math.pow(end[0]-x, 2);
				EdisY = (int)Math.pow(end[1]-y, 2);
				
				if(SdisX+SdisY>r*r && EdisX+EdisY<r*r
					|| SdisX+SdisY<r*r && EdisX+EdisY>r*r) 
					ans++;
			}
			System.out.println(ans);
		}
	}
}