import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[4][n];
		long ans = 0;

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int k = 0; k < n; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				int sum = arr[0][i] + arr[1][k];

				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				int sum = arr[2][i] + arr[3][k];

				if (map.containsKey(-sum)) {
					ans += map.get(-sum);
				}
			}
		}

		System.out.println(ans);
	}

}
