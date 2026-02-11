import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		Set<Integer> S = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}

		for (int num : A) {
			if (!B.contains(num))
				S.add(num);
		}

		for (int num : B) {
			if (!A.contains(num))
				S.add(num);
		}

		System.out.println(S.size());
	}

}
