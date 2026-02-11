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

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			map.put(num, map.getOrDefault(num, i + 1));
		}

		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Entry<Integer, Integer> now = it.next();
			System.out.println(now.getKey() + " " + now.getValue());
		}
	}

}
