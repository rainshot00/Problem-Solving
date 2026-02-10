import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<Integer, String> intToString = new HashMap<>();
		Map<String, Integer> stringToInt = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String str = br.readLine().trim();

			intToString.put(i, str);
			stringToInt.put(str, i);
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine().trim();

			try {
				int key = Integer.parseInt(str);

				sb.append(intToString.get(key) + "\n");
			} catch (Exception e) {
				sb.append(stringToInt.get(str) + "\n");
			}
		}

		System.out.println(sb.toString());
	}

}
