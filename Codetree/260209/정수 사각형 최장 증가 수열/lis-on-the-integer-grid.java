import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static int[][] dp;

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static int recursion(int y, int x) {

		if (dp[y][x] != -1)
			return dp[y][x];

		int maxLen = 1;

		for (int step = 0; step < 4; step++) {
			int yy = y + dy[step];
			int xx = x + dx[step];

			if (yy < 0 || yy >= n || xx < 0 || xx >= n) {
				continue;
			}

			if (arr[yy][xx] <= arr[y][x]) {
				continue;
			}

			maxLen = Math.max(maxLen, recursion(yy, xx) + 1);
		}

		return dp[y][x] = maxLen;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		int ans = -1;

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				ans = Math.max(ans, recursion(i, k));
			}
		}

		System.out.println(ans);
	}

}
