import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];
		int ans = 0;

		for (int paper = 0; paper < n; paper++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = y; i < y + 10; i++) {
				for (int k = x; k < x + 10; k++) {
					arr[i][k] = 1;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int k = 0; k < 100; k++) {
				if (arr[i][k] == 1)
					ans++;
			}
		}

		System.out.println(ans);
	}

}
