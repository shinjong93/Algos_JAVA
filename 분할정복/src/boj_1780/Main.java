package boj_1780;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int length;
    static int[][] numbers;
    static int[] ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        numbers = new int[length+1][length+1];
        ans = new int[4];
        String[] s;
        for(int y = 1; y < length+1; y++){
            s = br.readLine().split(" ");
            for(int x = 1; x < length+1; x++){
                numbers[y][x] = Integer.parseInt(s[x-1]);
            }
        }
        solve(1,1,length);
        for(int i = 0; i < 3; i++){
            System.out.println(ans[i]);
        }

    }
    static void solve(int x, int y, int size){
        boolean flag = check(x,y,size);
        if(!flag){
            solve(x,y,size/3);
           solve(x,y+size/3,size/3 );
           solve(x,y +(size/3)*2,size/3);
            solve(x+size/3,y,size/3);
            solve(x+size/3,y+size/3,size/3 );
            solve(x+size/3,y +(size/3)*2,size/3);
            solve(x+(size/3)*2,y,size/3);
            solve(x+(size/3)*2,y+size/3,size/3 );
            solve(x+(size/3)*2,y +(size/3)*2,size/3);
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
        int index = numbers[x][y] + 1;
        ans[index] += 1;
        return true;
    }
}
