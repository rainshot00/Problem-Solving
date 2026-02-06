import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int dp[];

	static int stair(int n) {
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;

		if (dp[n] != 0)
			return dp[n];

		return dp[n] = stair(n - 2) + stair(n - 3);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];

		System.out.println(stair(n));
	}
}
