package boj_2231;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public  static final int INF = 987654321;
    public static int smallest = INF;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int target = Integer.parseInt(s);

        for(int i = 1 ; i < 1000001; i++){
           if(target == cal(i) && smallest > cal(i)) {
               smallest = i;
           }
        }
        if(smallest != INF)
            System.out.println(smallest);
        else
            System.out.println("0");
    }
    public static int cal(int num){
        int result = num;
        while(num > 0){
            result += num %10;
            num /= 10;
        }
        return result;
    }
}
