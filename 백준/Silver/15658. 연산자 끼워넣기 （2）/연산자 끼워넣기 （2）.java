import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static int[] arr;
	public static int[] operator;
	public static int n;

	public static void recursion(int idx, int result) {
		if (idx == n) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}

		if (operator[0] > 0) {
			operator[0]--;
			recursion(idx + 1, result + arr[idx]);
			operator[0]++;
		}
		if (operator[1] > 0) {
			operator[1]--;
			recursion(idx + 1, result - arr[idx]);
			operator[1]++;
		}
		if (operator[2] > 0) {
			operator[2]--;
			recursion(idx + 1, result * arr[idx]);
			operator[2]++;
		}
		if (operator[3] > 0) {
			operator[3]--;
			recursion(idx + 1, result / arr[idx]);
			operator[3]++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		operator = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		recursion(1, arr[0]);

		System.out.println(max);
		System.out.println(min);

		br.close();
	}
}
