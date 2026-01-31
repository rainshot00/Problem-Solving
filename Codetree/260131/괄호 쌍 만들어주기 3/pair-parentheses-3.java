import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                for (int k = i + 1; k < str.length(); k++) {
                    if (str.charAt(k) == ')') {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}