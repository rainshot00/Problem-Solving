import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static HashSet<Integer> set = new HashSet<>();

    static void summation(int i, int sum) {
        if (i == n) {
            set.add(sum);
            return;
        }

        summation(i + 1, sum + arr[i]);
        summation(i + 1, sum);
    }
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        summation(0, 0);

        int ans = 1;
        while(true) {
            if (set.contains(ans)) {
                ans++;
                continue;
            }

            System.out.println(ans);
            break;
        }

        br.close();
    }
}