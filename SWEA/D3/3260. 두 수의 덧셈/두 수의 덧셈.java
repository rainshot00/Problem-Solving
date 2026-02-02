import java.util.Scanner;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		Stack<Integer> result = new Stack<>();

		int t = sc.nextInt();
        
		for (int testcase = 1; testcase <= t; testcase++) {
			String str1 = sc.next(), str2 = sc.next();

			for (int i = 0; i < str1.length(); i++) {
				s1.push(str1.charAt(i));
			}

			for (int i = 0; i < str2.length(); i++) {
				s2.push(str2.charAt(i));
			}

			boolean tenth = false;
			while (!(s1.isEmpty() && s2.isEmpty())) {
				char c1 = '0', c2 = '0';

				if (!s1.isEmpty()) {
					c1 = s1.pop();
				}
				if (!s2.isEmpty()) {
					c2 = s2.pop();
				}

				int tmp = tenth ? (c1 - '0' + c2 - '0' + 1) : (c1 - '0' + c2 - '0');

				if (tmp >= 10) {
					tenth = true;
					tmp -= 10;
				} else {
					tenth = false;
				}

				result.push(tmp);
			}

			if (tenth) {
				result.push(1);
			}
			
            System.out.print("#" + testcase + " ");
			while (!result.isEmpty()) {
				System.out.print(result.pop());
			}
            System.out.println();
		}
		
		sc.close();
	}
}