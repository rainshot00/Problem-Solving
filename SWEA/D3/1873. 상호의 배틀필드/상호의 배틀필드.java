import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int h, w, nowY, nowX;
	static char[][] arr;

	static void battleField(char c) {
		if (c == 'U') {
			arr[nowY][nowX] = '^';

			int yy = nowY - 1;
			int xx = nowX;

			if (yy < 0 || yy >= h || xx < 0 || xx >= w)
				return;

			if (arr[yy][xx] == '.') {
				arr[yy][xx] = '^';
				arr[nowY][nowX] = '.';

				nowY = yy;
				nowX = xx;
			}
		} else if (c == 'D') {
			arr[nowY][nowX] = 'v';

			int yy = nowY + 1;
			int xx = nowX;

			if (yy < 0 || yy >= h || xx < 0 || xx >= w)
				return;

			if (arr[yy][xx] == '.') {
				arr[yy][xx] = 'v';
				arr[nowY][nowX] = '.';

				nowY = yy;
				nowX = xx;
			}
		} else if (c == 'L') {
			arr[nowY][nowX] = '<';

			int yy = nowY;
			int xx = nowX - 1;

			if (yy < 0 || yy >= h || xx < 0 || xx >= w)
				return;

			if (arr[yy][xx] == '.') {
				arr[yy][xx] = '<';
				arr[nowY][nowX] = '.';

				nowY = yy;
				nowX = xx;
			}
		} else if (c == 'R') {
			arr[nowY][nowX] = '>';

			int yy = nowY;
			int xx = nowX + 1;

			if (yy < 0 || yy >= h || xx < 0 || xx >= w)
				return;

			if (arr[yy][xx] == '.') {
				arr[yy][xx] = '>';
				arr[nowY][nowX] = '.';

				nowY = yy;
				nowX = xx;
			}
		} else {
			if (arr[nowY][nowX] == '^') {
				for (int y = nowY - 1; y >= 0; y--) {
					if (arr[y][nowX] == '*') {
						arr[y][nowX] = '.';
						break;
					} else if (arr[y][nowX] == '#') {
						break;
					}
				}
			} else if (arr[nowY][nowX] == 'v') {
				for (int y = nowY + 1; y < h; y++) {
					if (arr[y][nowX] == '*') {
						arr[y][nowX] = '.';
						break;
					} else if (arr[y][nowX] == '#') {
						break;
					}
				}
			} else if (arr[nowY][nowX] == '<') {
				for (int x = nowX - 1; x >= 0; x--) {
					if (arr[nowY][x] == '*') {
						arr[nowY][x] = '.';
						break;
					} else if (arr[nowY][x] == '#') {
						break;
					}
				}
			} else {
				for (int x = nowX + 1; x < w; x++) {
					if (arr[nowY][x] == '*') {
						arr[nowY][x] = '.';
						break;
					} else if (arr[nowY][x] == '#') {
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr = new char[h][w];

			for (int i = 0; i < h; i++) {
				String str = br.readLine().trim();

				for (int k = 0; k < w; k++) {
					arr[i][k] = str.charAt(k);

					if (arr[i][k] == '^' || arr[i][k] == 'v' || arr[i][k] == '<' || arr[i][k] == '>') {
						nowY = i;
						nowX = k;
					}
				}
			}

			int n = Integer.parseInt(br.readLine());
			String operation = br.readLine().trim();

			for (int i = 0; i < n; i++) {
				battleField(operation.charAt(i));
			}

			sb.append("#" + testcase + " ");

			for (int i = 0; i < h; i++) {
				for (int k = 0; k < w; k++) {
					sb.append(arr[i][k]);
				}
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}
