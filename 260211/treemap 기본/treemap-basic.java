import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String operator = st.nextToken().trim();

			if (operator.equals("add")) {
				int key = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				map.put(key, value);
			} else if (operator.equals("remove")) {
				int key = Integer.parseInt(st.nextToken());
				map.remove(key);
			} else if (operator.equals("find")) {
				int key = Integer.parseInt(st.nextToken());
				if (map.containsKey(key)) {
					sb.append(map.get(key) + "\n");
				} else {
					sb.append("None\n");
				}
			} else {
				if (map.isEmpty())
					sb.append("None\n");
				else {
					Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();

					while (it.hasNext()) {
						sb.append(it.next().getValue() + " ");
					}
					sb.append("\n");
				}
			}
		}

		System.out.println(sb.toString());
	}

}
