import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static int[][] dp;

	static int recursion(int y, int x) {
		if (y == 0 || x == n - 1) {
			return dp[y][x];
		}

		if (dp[y][x] != -1) {
			return dp[y][x];
		}

		return dp[y][x] = Math.min(recursion(y - 1, x), recursion(y, x + 1)) + arr[y][x];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][n - 1] = arr[0][n - 1];

		for (int i = 1; i < n; i++) {
			dp[i][n - 1] = dp[i - 1][n - 1] + arr[i][n - 1];
		}

		for (int k = n - 2; k >= 0; k--) {
			dp[0][k] = dp[0][k + 1] + arr[0][k];
		}

		System.out.println(recursion(n - 1, 0));
	}

}
