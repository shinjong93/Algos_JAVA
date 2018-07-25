package boj_1992;

/*쿼드트리 -> 분할정복 문제.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int size;
    static int[][] numbers;
    static String ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        numbers = new int[65][65];
        ans = "";
        for(int i = 1; i <= size; i++){
            String[] s = br.readLine().split("");
            for(int j = 1; j<= size; j++){
                numbers[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        solve(1,1,size);
        System.out.println(ans);

    }
    static void solve(int x, int y, int size){

        boolean flag = check(x,y,size);
        if(!flag){
            ans += "(";
            solve(x,y,size/2);
            solve(x,y +size/2,size/2);
            solve(x + size/2,y,size/2);
            solve(x + size/2,y + size/2,size/2);
            ans += ")";
        }


    }




    static boolean check(int x, int y, int size){
        int current = numbers[x][y];
        for(int i = x; i < x + size;i++){
            for(int j = y; j < y+ size; j++){
                if(current != numbers[i][j])
                    return false;
            }
        }
        ans += current;
        return true;
    }
}
