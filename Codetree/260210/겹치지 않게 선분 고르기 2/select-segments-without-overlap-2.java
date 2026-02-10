import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int n, m, ans = 1;
	static int[][] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		for (int i = 1; i < n; i++) {
			for (int k = 0; k < i; k++) {
				if (arr[i][0] > arr[k][1]) {
					dp[i] = Math.max(dp[i], dp[k] + 1);
				}
			}

			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}

}
