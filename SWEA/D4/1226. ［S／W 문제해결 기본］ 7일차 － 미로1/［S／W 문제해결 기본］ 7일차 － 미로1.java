import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class Solution
{
	static int[][] arr = new int[16][16];
	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, 1, -1, 0 };
	static int flag = 0;

	public static void check(int nowY, int nowX, int endY, int endX) {
		if (nowY == endY && nowX == endX) {
			flag = 1;
		}

		for (int step = 0; step < 4; step++) {
			int yy = nowY + dy[step];
			int xx = nowX + dx[step];

			if (yy < 0 || yy >= 16 || xx < 0 || xx >= 16)
				continue;

			if (arr[yy][xx] == 1 || arr[yy][xx] == -1)
				continue;

			arr[nowY][nowX] = -1;
			check(yy, xx, endY, endX);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int testcase = Integer.parseInt(br.readLine());
			int startY = 0, startX = 0, endY = 0, endX = 0;

			for (int i = 0; i < 16; i++) {
				String str = br.readLine().trim();

				for (int k = 0; k < 16; k++) {
					arr[i][k] = Integer.parseInt("" + str.charAt(k));

					if (arr[i][k] == 2) {
						startY = i;
						startX = k;
					} else if (arr[i][k] == 3) {
						endY = i;
						endX = k;
					}
				}
			}

			flag = 0;
			check(startY, startX, endY, endX);
			System.out.println("#" + testcase + " " + flag);
		}
	}

}
