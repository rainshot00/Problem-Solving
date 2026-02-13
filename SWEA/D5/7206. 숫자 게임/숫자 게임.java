import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	static int[] dp = new int[100000];

	static int split(String n) {
		if (n.length() < 2) {
			return 0;
		}

		if (dp[Integer.parseInt(n)] != -1) {
			return dp[Integer.parseInt(n)];
		}

		int ans = 0;

		for (int i = 1; i < (1 << (n.length() - 1)); i++) {
			int idx = 0;
			List<Integer> l = new ArrayList<>();

			for (int k = 0; k < (n.length() - 1); k++) {
				if ((i & (1 << k)) != 0) {
					String tmp = n.substring(idx, k + 1);
					l.add(Integer.parseInt(tmp));

					idx = k + 1;
				}
			}
			l.add(Integer.parseInt(n.substring(idx)));

			int num = 1;
			for (int now : l) {
				num *= now;
			}

			ans = Math.max(ans, split(String.valueOf(num)) + 1);
		}

		return dp[Integer.parseInt(n)] = ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			String n = br.readLine().trim();

			Arrays.fill(dp, -1);

			sb.append("#" + testcase + " " + split(n) + "\n");
		}

		System.out.println(sb.toString());
	}

}
