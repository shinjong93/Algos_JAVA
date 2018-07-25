package boj_2740;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] A;
    static int[][] B;
    static int[][] AB;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int ax = Integer.parseInt(s[0]) ;
        int ay = Integer.parseInt(s[1]) ;

        A = new int[101][101];
        for(int i=1; i <= ax; i++){
            s = br.readLine().split(" ");
            for(int j = 1; j <= ay; j++){
                A[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        s = br.readLine().split(" ");
        int bx = Integer.parseInt(s[0]) ;
        int by = Integer.parseInt(s[1]) ;
        B = new int[101][101];
        for(int i=1; i <= bx; i++){
            s = br.readLine().split(" ");
            for(int j = 1; j <= by; j++){
                B[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        AB = new int[101][101];

        for(int i=1; i <= ax; i++){
            for(int j = 1; j <= by; j++){
                for(int k = 1; k <= bx; k++){
                    AB[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for(int i = 1; i <= ax; i++){
            for(int j = 1; j <= by; j++){
                System.out.print(AB[i][j] + " ");
            }
            System.out.println();
        }
    }
}
