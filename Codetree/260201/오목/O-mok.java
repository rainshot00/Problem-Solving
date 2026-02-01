import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] dx = { 1, 0, -1, 1, -1, 1, 0, -1 };
	static int[][] arr;

	public static void check(int y, int x, int direction) {
		int yy = y;
		int xx = x;

		for (int i = 0; i < 4; i++) {
			yy += dy[direction];
			xx += dx[direction];

			if (yy < 0 || yy >= 19 || xx < 0 || xx >= 19)
				return;
			if (arr[yy][xx] != arr[y][x])
				return;
		}

		System.out.println(arr[y][x]);
		System.out.println((y + 2 * dy[direction] + 1) + " " + (x + 2 * dx[direction] + 1));
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[19][19];

		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 0; k < 19; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 19; i++) {
			for (int k = 0; k < 19; k++) {
				if (arr[i][k] == 0)
					continue;

				for (int step = 0; step < 8; step++) {
					check(i, k, step);
				}
			}
		}

		System.out.println(0);

		br.close();
	}
}
