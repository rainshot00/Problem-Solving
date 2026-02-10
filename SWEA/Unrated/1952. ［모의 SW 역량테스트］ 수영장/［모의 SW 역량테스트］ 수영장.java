import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int ans;
	static int[] price = new int[4];
	static int[] plan = new int[12];

	static void recursion(int month, int sum) {
		if (month > 12) {
			ans = Math.min(ans, sum);
			return;
		}

		if (sum >= ans)
			return;

		if (plan[month - 1] == 0)
			recursion(month + 1, sum);

		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				recursion(month + 1, sum + price[0] * plan[month - 1]);
			} else if (i == 1) {
				recursion(month + 1, sum + price[1]);
			} else if (i == 2) {
				recursion(month + 3, sum + price[2]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			ans = price[3]; // oneYear

			recursion(1, 0);

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}
}
