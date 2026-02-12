import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		TreeSet<Integer> s = new TreeSet<>((a, b) -> Integer.compare(b, a));

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			s.add(num);
		}

		Iterator<Integer> it = s.iterator();
		for (int i = 0; i < k; i++) {
			sb.append(it.next() + " ");
		}

		System.out.println(sb.toString());
	}

}
