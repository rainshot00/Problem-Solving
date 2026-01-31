import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int sum = 0, ans = 987654321;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                int nowSum = sum - arr[i] - arr[k];

                if (ans > Math.abs(s - nowSum)) {
                    ans = Math.abs(s - nowSum);
                }
            }
        }

        System.out.println(ans);
    }
}