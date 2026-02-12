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
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int k = 0; k < n; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}

			int start = 1;
			int nowY = -1;
			int nowX = -1;
			int[] dy = { 1, 0, 0, -1 };
			int[] dx = { 0, 1, -1, 0 };
			int roomNum = Integer.MAX_VALUE, maxLen = -1;

			while (start <= n * n) {
				for (int i = 0; i < n; i++) {
					boolean flag = false;

					for (int k = 0; k < n; k++) {
						if (arr[i][k] == start) {
							nowY = i;
							nowX = k;
							flag = true;
							break;
						}
					}

					if (flag)
						break;
				}

				int end = start;
				while (true) {
					boolean flag = false;

					for (int step = 0; step < 4; step++) {
						int yy = nowY + dy[step];
						int xx = nowX + dx[step];

						if (yy < 0 || yy >= n || xx < 0 || xx >= n)
							continue;

						if (arr[yy][xx] == arr[nowY][nowX] + 1) {
							end++;
							nowY = yy;
							nowX = xx;
							flag = true;
							break;
						}
					}

					if (!flag) {
						break;
					}
				}

				if (end - start + 1 > maxLen) {
					maxLen = Math.max(maxLen, end - start + 1);
					roomNum = start;
				}

				start = end + 1;
			}

			sb.append("#" + testcase + " " + roomNum + " " + maxLen + "\n");
		}

		System.out.println(sb.toString());
	}

}
