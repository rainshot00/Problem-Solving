import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int n, maxConnected, minLength;
	static int[][] arr;
	static List<int[]> cell;

	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };

	static void connect(int cellIdx, int connected, int length) {
		if (cellIdx == cell.size()) {
			if (connected > maxConnected) {
				maxConnected = connected;
				minLength = length;
			} else if (connected == maxConnected) {
				minLength = Math.min(minLength, length);
			}

			return;
		}

		int[] pos = cell.get(cellIdx);
		int y = pos[0];
		int x = pos[1];

		for (int i = 0; i < 4; i++) {
			boolean flag = true;
			int yy = y;
			int xx = x;

			while (true) {
				yy += dy[i];
				xx += dx[i];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n)
					break;

				if (arr[yy][xx] != 0) {
					flag = false;
					break;
				}
			}

			if (!flag) {
				continue;
			}

			yy = y;
			xx = x;

			while (true) {
				yy += dy[i];
				xx += dx[i];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n)
					break;

				arr[yy][xx] = -1;
				length++;
			}

			connect(cellIdx + 1, connected + 1, length);

			yy = y;
			xx = x;

			while (true) {
				yy += dy[i];
				xx += dx[i];

				if (yy < 0 || yy >= n || xx < 0 || xx >= n)
					break;

				arr[yy][xx] = 0;
				length--;
			}
		}

		connect(cellIdx + 1, connected, length);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			cell = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int k = 0; k < n; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());

					if (arr[i][k] == 1) {
						cell.add(new int[] { i, k });
					}
				}
			}

			maxConnected = -1;
			minLength = Integer.MAX_VALUE;
			connect(0, 0, 0);

			sb.append("#" + testcase + " " + minLength + "\n");
		}

		System.out.println(sb.toString());
	}

}
