import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int dp[];

	static int fill(int n) {
		if (n <= 2)
			return n;

		if (dp[n] != -1)
			return dp[n];

		return dp[n] = (fill(n - 1) + fill(n - 2)) % 10_007;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		Arrays.fill(dp, -1);

		System.out.println(fill(n));
	}
}
