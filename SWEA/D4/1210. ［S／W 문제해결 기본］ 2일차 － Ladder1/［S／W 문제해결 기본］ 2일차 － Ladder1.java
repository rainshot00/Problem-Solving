import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr = new int[100][100];
	static int[] dx = { 1, -1 };
	static int testcase;

	public static void ladder(int y, int x) {
		if (y == 0) {
			System.out.println("#" + testcase + " " + x);
			return;
		}

		for (int step = 0; step < 2; step++) {
			int xx = x + dx[step];

			if (xx < 0 || xx >= 100)
				continue;

			if (arr[y][xx] == 1) {
				while (true) {
					xx += dx[step];

					if (xx < 0 || xx >= 100)
						break;

					if (arr[y][xx] == 0)
						break;
				}

				ladder(y - 1, xx - dx[step]);
				return;
			}

		}

		ladder(y - 1, x);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			testcase = Integer.parseInt(br.readLine());
			int y = -1, x = -1;

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 100; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
					if (arr[i][k] == 2) {
						y = i;
						x = k;
					}
				}
			}

			ladder(y, x);

		}
	}

}
