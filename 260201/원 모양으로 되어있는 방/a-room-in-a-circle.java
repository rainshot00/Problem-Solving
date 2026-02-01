import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int ans = 987654321;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int start = 0; start < n; start++) {
			int tmp = 0;

			for (int room = 0; room < n; room++) {
				if (start <= room) {
					tmp += ((room - start) * arr[room]);
				} else {
					tmp += ((room + n - start) * arr[room]);
				}
			}

			ans = Math.min(ans, tmp);
		}

		System.out.println(ans);

		br.close();
	}
}
