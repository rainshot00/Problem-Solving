import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static long ans;

	static void next(long n, long res) {
		if (n == 2) {
			ans = Math.min(ans, res);
			return;
		}

		long sqrt = (long) Math.sqrt(n);
		if (sqrt * sqrt == n) {
			next(sqrt, res + 1);
		} else {
			next((sqrt + 1) * (sqrt + 1), res + (sqrt + 1) * (sqrt + 1) - n);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			long n = Long.parseLong(br.readLine());

			ans = Long.MAX_VALUE;
			next(n, 0);

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}
