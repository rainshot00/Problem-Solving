import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> map = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine().trim();

			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Entry<String, Integer> e = it.next();
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}

}
