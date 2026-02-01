import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		for (int firstY = 0; firstY < n; firstY++) {
			for (int firstX = 0; firstX < n - 2; firstX++) {
				int firstCoin = arr[firstY][firstX] + arr[firstY][firstX + 1] + arr[firstY][firstX + 2];

				for (int secondY = 0; secondY < n; secondY++) {
					for (int secondX = 0; secondX < n - 2; secondX++) {
						if (firstY == secondY && !(firstX + 2 < secondX || secondX + 2 < firstX))
							continue;

						int secondCoin = arr[secondY][secondX] + arr[secondY][secondX + 1] + arr[secondY][secondX + 2];

						ans = Math.max(ans, firstCoin + secondCoin);
					}
				}
			}
		}

		System.out.println(ans);

		br.close();
	}
}
