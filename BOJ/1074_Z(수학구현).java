import java.util.Scanner;
public class Main {
	static int n,r,c, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		r=sc.nextInt()+1;
		c=sc.nextInt()+1;
		ans=0;
		int size = (int)Math.pow(2, n);
		int center=0;
		
		for(int i=size; i>=2; i=i/2) {
			center=i/2;
			if(r>center && c<=center) {
				ans+=center*center*2;
				r=r-center;
			}
			else if(c>center && r<=center) {
				ans+=center*center;
				c=c-center;
			}
			else if(r>center && c>center) {
				ans+=center*center*3;
				r=r-center;
				c=c-center;
			}
		}
		
		if(r==1 && c==2)
			ans+=1;
		else if(r==2 && c==1)
			ans+=2;
		else if(r==2 && c==2)
			ans+=3;
		
		System.out.println(ans);
	}
}