import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int ans = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '(' && str.charAt(i + 1) == '(') {
                for (int k = i + 2; k < str.length() - 1; k++) {
                    if (str.charAt(k) == ')' && str.charAt(k + 1) == ')') {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}