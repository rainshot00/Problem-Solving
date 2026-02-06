import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int dp[];

	static int fibonacci(int n) {
		if (n == 1 || n == 2)
			return 1;

		if (dp[n] != 0)
			return dp[n];

		return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];

		System.out.println(fibonacci(n));
	}
}
