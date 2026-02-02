import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= t; i++) {
			String str = sc.nextLine();
			int ans = 0;
			
			for (int idx = 0; idx < str.length() - 1; idx++) {
				if(str.charAt(idx) != str.charAt(idx + 1)) {
					ans++;
				}
			}
			
			if (str.charAt(0) == '1') {
				ans++;
			}
			
			System.out.println("#" + i + " " + ans);
		}
		sc.close();
	}
}