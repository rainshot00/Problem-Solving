import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int ans = 987654321;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int skip = 1; skip < n - 1; skip++) {
			int tmpx = arr[skip][0];
			int tmpy = arr[skip][1];

			arr[skip][0] = arr[skip - 1][0];
			arr[skip][1] = arr[skip - 1][1];

			int tmp = 0;
			for (int i = 0; i < n - 1; i++) {
				tmp += (Math.abs(arr[i][0] - arr[i + 1][0]) + Math.abs(arr[i][1] - arr[i + 1][1]));
			}

			ans = Math.min(ans, tmp);

			arr[skip][0] = tmpx;
			arr[skip][1] = tmpy;
		}

		System.out.println(ans);

		br.close();
	}
}
