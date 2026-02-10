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

		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String oper = st.nextToken().trim();

			if (oper.equals("add")) {
				int k = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				map.put(k, v);
			} else if (oper.equals("remove")) {
				int k = Integer.parseInt(st.nextToken());

				map.remove(k);
			} else {
				int k = Integer.parseInt(st.nextToken());

				if (map.containsKey(k)) {
					sb.append(map.get(k) + "\n");
				} else {
					sb.append("None\n");
				}
			}
		}

		System.out.println(sb.toString());
	}

}
