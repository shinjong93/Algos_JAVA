package boj_2749;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 1000000;
        int p = mod/10*15;
        int[] fibo = new int[p];
        fibo[0] = 0;
        fibo[1] = 1;
        long index = Long.parseLong(br.readLine());
        for(int i = 2; i < p; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
            fibo[i] %= mod;
        }
        System.out.println(fibo[(int)(index%p)]);
    }
}
