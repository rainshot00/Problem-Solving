import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int n, ans;
	static int y1, y2, y3, y4, x1, x2, x3, x4;
	static int[][] arr;

	static void check() {
		Set<Integer> s = new HashSet<>();
		int y, x;

		// top to left
		s.add(arr[y1][x1]);
		y = y1;
		x = x1;
		for (int i = y1 + 1; i <= y2; i++) {
			y++;
			x--;

			if (s.contains(arr[y][x])) {
				return;
			}
			s.add(arr[y][x]);
		}

		// top to right
		y = y1;
		x = x1;
		for (int i = y1 + 1; i <= y3; i++) {
			y++;
			x++;

			if (s.contains(arr[y][x])) {
				return;
			}
			s.add(arr[y][x]);
		}

		// left to bottom
		y = y2;
		x = x2;
		for (int i = y2 + 1; i < y4; i++) {
			y++;
			x++;

			if (s.contains(arr[y][x])) {
				return;
			}
			s.add(arr[y][x]);
		}

		// right to bottom

		y = y3;
		x = x3;
		for (int i = y3 + 1; i <= y4; i++) {
			y++;
			x--;

			if (s.contains(arr[y][x])) {
				return;
			}
			s.add(arr[y][x]);
		}

		ans = Math.max(ans, s.size());
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			ans = -1;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int k = 0; k < n; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}

			// top
			for (y1 = 0; y1 < n; y1++) {
				for (x1 = 0; x1 < n; x1++) {
					y2 = y1 + 1;
					x2 = x1 - 1;

					// left
					while (x2 >= 0 && y2 < n) {
						y3 = y1 + 1;
						x3 = x1 + 1;

						// right
						while (x3 < n && y3 < n) {
							// bottom
							y4 = y3 + y2 - y1;
							x4 = x3 + x2 - x1;

							if (0 <= y4 && y4 < n && 0 <= x4 && x4 < n) {

								check();
							}

							y3++;
							x3++;
						}

						y2++;
						x2--;
					}
				}
			}

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}
