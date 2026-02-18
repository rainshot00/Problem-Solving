import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int[][] psum = new int[N + 1][N + 1];
		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < N; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int k = 1; k <= N; k++) {
				psum[i][k] = psum[i - 1][k] + psum[i][k - 1] - psum[i - 1][k - 1] + arr[i - 1][k - 1];
			}
		}

		for (int i = K; i <= N; i++) {
			for (int k = K; k <= N; k++) {
				ans = Math.max(ans, psum[i][k] - psum[i - K][k] - psum[i][k - K] + psum[i - K][k - K]);
			}
		}

		System.out.println(ans);
	}
}
