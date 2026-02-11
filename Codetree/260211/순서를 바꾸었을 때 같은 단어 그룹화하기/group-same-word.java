import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		int ans = 0;

		for (int i = 0; i < n; i++) {
			String str = br.readLine().trim();
			char[] charArr = str.toCharArray();
			Arrays.sort(charArr);
			String result = String.valueOf(charArr);

			map.put(result, map.getOrDefault(result, 0) + 1);
		}

		for (int v : map.values()) {
			ans = Math.max(ans, v);
		}

		System.out.println(ans);
	}

}
