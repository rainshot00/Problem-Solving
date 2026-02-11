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
		Map<Integer, Integer> map = new HashMap<>();
		long ans = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map.put(x, Math.min(map.getOrDefault(x, Integer.MAX_VALUE), y));
		}

		for (int y : map.values()) {
			ans += y;
		}

		System.out.println(ans);
	}

}
