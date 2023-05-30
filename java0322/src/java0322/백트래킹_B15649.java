package java0322;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//n과 m - 백트래킹 기본
public class 백트래킹_B15649 {
    static int[] arr;
    static boolean[] isUsed;
    static int m;
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = i;
        }
        isUsed = new boolean[n+1];

        nandm(0);
        bw.close();
    }

    private static void nandm(int k) throws IOException{
        if (k == m) {
            for (int i = 1; i < k+1; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i < n+1; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[k+1] = i;
                nandm(k + 1);

                isUsed[i] = false;
            }
        }
    }
}
