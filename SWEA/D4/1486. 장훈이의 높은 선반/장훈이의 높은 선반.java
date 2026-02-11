import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int ans = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < (1 << n); i++) {
				int sum = 0;

				for (int k = 0; k < n; k++) {
					if ((i & (1 << k)) != 0) {
						sum += arr[k];
					}
				}

				if (sum >= b) {
					ans = Math.min(ans, sum);
				}
			}

			sb.append("#" + testcase + " " + (ans - b) + "\n");
		}

		System.out.println(sb.toString());
	}

}
