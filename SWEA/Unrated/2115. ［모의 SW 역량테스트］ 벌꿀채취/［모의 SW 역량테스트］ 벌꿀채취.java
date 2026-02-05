import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, m, c, maxTmp;
	static int[][] arr;
	static int[][] maxVal;

	public static void calcul(int y, int x, int weight, int val, int len) {
		if (weight > c)
			return;

		if (len == m) {
			maxTmp = Math.max(maxTmp, val);
			return;
		}

		calcul(y, x, weight + arr[y][x + len], val + (arr[y][x + len] * arr[y][x + len]), len + 1);
		calcul(y, x, weight, val, len + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			arr = new int[n][n];
			maxVal = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < n; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int k = 0; k <= n - m; k++) {
					maxTmp = 0;
					calcul(i, k, 0, 0, 0);
					maxVal[i][k] = maxTmp;
				}
			}

			int ans = 0;
			for (int y1 = 0; y1 < n; y1++) {
				for (int x1 = 0; x1 <= n - m; x1++) {
					for (int y2 = 0; y2 < n; y2++) {
						for (int x2 = 0; x2 <= n - m; x2++) {
							if (y1 == y2 && Math.abs(x1 - x2) < m)
								continue;

							ans = Math.max(ans, maxVal[y1][x1] + maxVal[y2][x2]);
						}
					}
				}
			}

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}
