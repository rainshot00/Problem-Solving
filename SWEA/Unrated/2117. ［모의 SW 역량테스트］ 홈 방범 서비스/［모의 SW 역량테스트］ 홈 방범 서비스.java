import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, m, ans;
	static int[][] arr;

	static void check(int size, int y, int x) {
		boolean[][] v = new boolean[n][n];
		int cnt = 0;
		int plus = 1;
		int res = 0;
		for (int i = y - size + 1; i <= y + size - 1; i++) {
			if (i < 0 || i >= n) {
				cnt += plus;
				continue;
			}

			for (int k = x - cnt; k <= x + cnt; k++) {
				if (k < 0 || k >= n)
					continue;

				if (arr[i][k] == 1) {
					v[i][k] = true;
					res++;
				}
			}

			if (cnt == size - 1) {
				plus *= -1;
			}

			cnt += plus;
		}

		if (m * res >= (size * size + (size - 1) * (size - 1))) {
			ans = Math.max(ans, res);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < n; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}

			ans = -1;
			for (int size = 1; size <= n + 1; size++) {
				for (int i = 0; i < n; i++) {
					for (int k = 0; k < n; k++) {
						check(size, i, k);
					}
				}
			}

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}