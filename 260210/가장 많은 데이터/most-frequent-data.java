import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String key = br.readLine().trim();

			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		int ans = 0;
		for (int num : map.values()) {
			ans = Math.max(ans, num);
		}

		System.out.println(ans);
	}

}
