import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m, ans = -1;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < m; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = 1;

		for (int y = 1; y < n; y++) {
			for (int x = 1; x < n; x++) {
				for (int yy = 0; yy < y; yy++) {
					for (int xx = 0; xx < x; xx++) {
						if (dp[yy][xx] != -1 && arr[yy][xx] < arr[y][x])
							dp[y][x] = Math.max(dp[y][x], dp[yy][xx] + 1);
					}
				}

				ans = Math.max(ans, dp[y][x]);
			}
		}

		System.out.println(ans);
	}

}
