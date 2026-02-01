import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] dx = { 1, 0, -1, 1, -1, 1, 0, -1 };
	static String[] arr;

	static int n, m, ans = 0;

	public static void check(int y, int x, int direction) {
		int yy = y + dy[direction];
		int xx = x + dx[direction];

		int yyy = yy + dy[direction];
		int xxx = xx + dx[direction];

		if (yyy < 0 || yyy >= n || xxx < 0 || xxx >= m)
			return;

		if (arr[yy].charAt(xx) == 'E' && arr[yyy].charAt(xxx) == 'E')
			ans++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().trim();
		}

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < m; k++) {
				if (arr[i].charAt(k) == 'L') {
					for (int step = 0; step < 8; step++) {
						check(i, k, step);
					}
				}
			}
		}

		System.out.println(ans);

		br.close();
	}
}
