import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int ans = -987654321;
		int[][] arr = new int[n + 1][n + 1];
		int[][] psum = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 1; k <= n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= n; k++) {
				psum[i][k] = psum[i - 1][k] + psum[i][k - 1] - psum[i - 1][k - 1] + arr[i][k];
			}
		}

		for (int y1 = 1; y1 <= n; y1++) {
			for (int x1 = 1; x1 <= n; x1++) {
				for (int y2 = y1; y2 <= n; y2++) {
					for (int x2 = x1; x2 <= n; x2++) {
						ans = Math.max(ans, psum[y2][x2] - psum[y1 - 1][x2] - psum[y2][x1 - 1] + psum[y1 - 1][x1 - 1]);
					}
				}
			}
		}

		System.out.println(ans);
	}

}
