import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine().trim();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		List<Character> l = new ArrayList<>();
		Map<Character, Integer> one = new HashMap<>();
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			if (m.getValue() == 1) {
				one.put(m.getKey(), 1);
				l.add(m.getKey());
			}
		}

		if (l.size() == 0) {
			System.out.println("None");
		} else if (l.size() == 1) {
			System.out.println(l.get(0));
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (one.containsKey(str.charAt(i))) {
					System.out.println(str.charAt(i));
					break;
				}
			}
		}
	}

}
