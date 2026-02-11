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

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] arr1 = new String[n];
		String[] arr2 = new String[n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			arr1[i] = br.readLine().trim();
		}

		for (int i = 0; i < n; i++) {
			arr2[i] = br.readLine().trim();
		}

		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				for (int k = j + 1; k < m; k++) {
					Set<String> s = new HashSet<>();
					boolean flag = true;

					for (int x = 0; x < arr1.length; x++) {
						s.add("" + arr1[x].charAt(i) + arr1[x].charAt(j) + arr1[x].charAt(k));
					}

					for (int x = 0; x < arr2.length; x++) {
						if (s.contains("" + arr2[x].charAt(i) + arr2[x].charAt(j) + arr2[x].charAt(k))) {
							flag = false;
							break;
						}
					}

					if (flag)
						ans++;
				}
			}
		}

		System.out.println(ans);
	}

}
