import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void check(int number, int length) {
		if (length == n) {
			sb.append(number).append("\n");
			return;
		}

		for (int i = 1; i < 10; i++) {
			int next = number * 10 + i;
			boolean flag = true;

			for (int k = 2; k * k <= next; k++) {
				if (next % k == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				check(next, length + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int[] digit = { 2, 3, 5, 7 };

		for (int d : digit) {
			check(d, 1);
		}

		System.out.print(sb.toString());
	}

}
