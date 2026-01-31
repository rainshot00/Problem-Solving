import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (str.charAt(i) == 'C' && str.charAt(j) == 'O' && str.charAt(k) == 'W') {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}