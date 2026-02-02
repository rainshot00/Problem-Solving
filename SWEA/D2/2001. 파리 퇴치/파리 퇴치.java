import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
 
        for (int testcase = 1; testcase <= t; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            int ans = -1;
 
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
 
                for (int k = 0; k < n; k++) {
                    arr[i][k] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int y = 0; y <= n - m; y++) {
                for (int x = 0; x <= n - m; x++) {
                    int sum = 0;
 
                    for (int i = 0; i < m; i++) {
                        for (int k = 0; k < m; k++) {
                            sum += arr[y + i][x + k];
                        }
                    }
 
                    ans = Math.max(ans, sum);
                }
            }
 
            System.out.println("#" + testcase + " " + ans);
        }
    }
 
}