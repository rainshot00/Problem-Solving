import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		dp = new int[m + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = 0;

		for (int i = 1; i <= m; i++) {
			for (int k = 0; k < n; k++) {
				if (i >= arr[k]) {
					if (dp[i - arr[k]] == Integer.MAX_VALUE)
						continue;

					dp[i] = Math.min(dp[i], dp[i - arr[k]] + 1);
				}
			}
		}

		if (dp[m] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[m]);
	}

}
