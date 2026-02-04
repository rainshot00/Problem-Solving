import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int ans = -1;

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n - 1; i++) {
				for (int k = i + 1; k < n; k++) {
					int sum = arr[i] + arr[k];

					if (sum <= m)
						ans = Math.max(ans, sum);
				}
			}

			System.out.println("#" + testcase + " " + ans);
		}
	}

}
