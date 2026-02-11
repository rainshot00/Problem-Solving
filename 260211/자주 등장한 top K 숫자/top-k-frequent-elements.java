import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> l = new ArrayList<>(map.entrySet());

		l.sort((a, b) -> {
			if (a.getValue().equals(b.getValue()))
				return b.getKey() - a.getKey();
			return b.getValue() - a.getValue();
		});

		for (int i = 0; i < k; i++) {
			sb.append(l.get(i).getKey() + " ");
		}

		System.out.println(sb.toString());
	}

}
