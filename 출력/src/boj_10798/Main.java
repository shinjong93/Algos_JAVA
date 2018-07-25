package boj_10798;

import java.util.*;
import java.io.*;

public class Main{
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static String[][] board;
    
    public static void main(String[] args) throws Exception{
        String[] s;
        String result = "";
        board = new String[5][15];
        for(int i = 0; i < 5; i++){
            s = in.readLine().split("");
            for(int j = 0; j < 15; j++){
                if(j > s.length -1)
                       board[i][j] = "NULL";
                else
                       board[i][j] = s[j];
            }
            
        }
        for(int j = 0; j<15;j++)
            for(int i = 0; i<5; i++){
                if(board[i][j] == "NULL")
                    continue;
                else
                    result = result + board[i][j];
            }
        System.out.print(result);
    }
    
}
