import java.io.*;
import java.util.Arrays;

public class Main {

	static int[] dp;

	static int tile(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 3;

		if (dp[n] != -1)
			return dp[n];

		return dp[n] = (tile(n - 1) + 2 * tile(n - 2)) % 10_007;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		Arrays.fill(dp, -1);

		System.out.println(tile(n));
	}
}
