import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, ans;
	static int[][] atom;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= t; testcase++) {
			n = Integer.parseInt(br.readLine());
			atom = new int[n][5];
			ans = 0;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int k = 0; k < 4; k++) {
					atom[i][k] = Integer.parseInt(st.nextToken());
				}

				atom[i][0] = (atom[i][0] + 1000) * 2;
				atom[i][1] = (atom[i][1] + 1000) * 2;
				atom[i][4] = 1;
			}

			int[][] coordinate = new int[4001][4001];
			int step = 0;
			while (step < 4000) {
				boolean remain = false;

				for (int i = 0; i < n; i++) {
					if (atom[i][4] == -1)
						continue;

					int direction = atom[i][2];

					atom[i][0] += dx[direction];
					atom[i][1] += dy[direction];

					if (atom[i][0] < 0 || atom[i][0] > 4000 || atom[i][1] < 0 || atom[i][1] > 4000) {
						atom[i][4] = -1;
						continue;
					}

					coordinate[atom[i][1]][atom[i][0]]++;
					remain = true;
				}

				if (!remain) {
					break;
				}

				for (int i = 0; i < n; i++) {
					if (atom[i][4] == -1)
						continue;

					if (coordinate[atom[i][1]][atom[i][0]] > 1) {
						atom[i][4] = -1;
						ans += atom[i][3];
					}
				}

				for (int i = 0; i < n; i++) {
					if (atom[i][0] < 0 || atom[i][0] > 4000 || atom[i][1] < 0 || atom[i][1] > 4000)
						continue;

					coordinate[atom[i][1]][atom[i][0]] = 0;
				}

				step++;
			}

			sb.append("#" + testcase + " " + ans + "\n");
		}

		System.out.println(sb.toString());
	}

}
