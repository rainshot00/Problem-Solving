import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int ans = 987654321;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int tmp = 0;

            for (int k = 0; k < n; k++) {
                tmp += (arr[k] * Math.abs(k - i));
            }

            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);
    }
}