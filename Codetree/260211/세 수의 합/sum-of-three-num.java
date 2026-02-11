import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ans = 0;

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			Map<Integer, Integer> map = new HashMap<>();

			for (int j = i + 1; j < n; j++) {
				int num = k - arr[i] - arr[j];

				if (map.containsKey(num))
					ans += map.get(num);

				map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
			}
		}

		System.out.println(ans);
	}

}
