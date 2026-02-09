import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static int[][] dp;

	static int recursion(int y, int x) {
		if (y == 0 || x == 0) {
			return dp[y][x];
		}

		if (dp[y][x] != 0) {
			return dp[y][x];
		}

		return dp[y][x] = Math.max(recursion(y - 1, x), recursion(y, x - 1)) + arr[y][x];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = arr[0][0];

		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];
		}

		for (int k = 1; k < n; k++) {
			dp[0][k] = dp[0][k - 1] + arr[0][k];
		}

		System.out.println(recursion(n - 1, n - 1));
	}

}
