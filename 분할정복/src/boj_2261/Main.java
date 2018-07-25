package boj_2261;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/* 가장 가까운 두점 -> 분할정복 문제 */
public class Main {
    static int MIN = 987654321;
    static point[] board;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Case = Integer.parseInt(br.readLine());
        board = new point[100001];
        for(int i = 1; i <= Case; i++){
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            board[i] = new point(x,y);
        }

        for(int i = 1; i < Case; i++){
            int ix = board[i].x;
            int iy = board[i].y;
            for(int j = i+1; j <= Case; j++){
                int jx = board[j].x;
                int jy = board[j].y;
                check(ix,iy,jx,jy);
            }
        }

        System.out.println(MIN);
    }
    static void check(int ix, int iy, int jx, int jy){
        int cal = (int)(powered(ix,jx) + powered(iy,jy));
        if(cal < MIN)
            MIN = cal;
    }

    static double powered(int a, int b){
        return Math.pow(a-b,2);
    }

    static class comparatorSet implements Comparator<point>{
        public int compare(point p1, point p2){
            if(p1.y == p2.y){
                if(p1.x < p2.x){
                    return -1;
                } else if(p1.x == p2.x){
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return p1.y < p2.y ? 1: -1;
            }
        }
    }

    static class point implements Comparable<point>{
        int x;
        int y;
        public point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(point p){
            return x < p.y && y > p.y ? 1 : -1;
        }
    }
}
