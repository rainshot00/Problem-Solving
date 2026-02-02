import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i <= 10; i++) {
			int testcase = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			
			for(int k = 0; k < 8; k++) {
				q.add(sc.nextInt());
			}
			
			int sub = 1;
			while (true) {
				if (sub > 5) {
					sub = 1;
				}
				
				int first = q.poll();
				
				if(first - sub <= 0) {
					q.add(0);
					break;
				}
				else {
					q.add(first - sub);
					sub++;
				}
			}
			
			System.out.print("#" + testcase + " ");
			for (int k = 0; k < 8; k++) {
				System.out.print(q.poll() + " ");
			}
            System.out.println();
		}
		
		sc.close();
	}
}