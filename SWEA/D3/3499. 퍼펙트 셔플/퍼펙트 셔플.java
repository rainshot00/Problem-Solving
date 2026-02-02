import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int testcase = 1; testcase <= t; testcase++) {
			int n = sc.nextInt();
			int len1 = 0, len2 = 0;
			
			if (n % 2 == 0) {
				len1 = n / 2; len2 = n / 2;
			}
			else {
				len1 = n / 2 + 1; len2 = n / 2;
			}
			

			String[] arr1 = new String[len1];
			String[] arr2 = new String[len2];
			
			for(int i = 0; i < len1; i++) {
				arr1[i] = sc.next();
			}
			
			for(int i = 0; i < len2; i++) {
				arr2[i] = sc.next();
			}
			
			System.out.print("#" + testcase + " ");
			int idx1 = 0, idx2 = 0;
			for(int i = 0; i < n; i++) {
				if(i % 2 == 0) {
					System.out.print(arr1[idx1] + " ");
					idx1++;
				}
				else {
					System.out.print(arr2[idx2] + " ");
					idx2++;
				}
			}
			System.out.println();
		}
		
		sc.close();
	}
}