package boj_5052;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
        int Case = Integer.parseInt(s[0]);
        StringBuilder sb = new StringBuilder();


        while(Case --> 0){
            s = in.readLine().split(" ");
            int number = Integer.parseInt(s[0]);
            String[] Array = new String[number];
            boolean flag = true;

            for(int i = 0; i < number; i++){
                s = in.readLine().split(" ");
                Array[i] = s[0];
            }
            Arrays.sort(Array);

            for(int i = 0; i < Array.length-1; i++){
                int current = Integer.parseInt(Array[i]);
                int next = Integer.parseInt(Array[i+1]);

                if(current < next){
                    if(Array[i+1].indexOf(Array[i]) > -1){
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                sb.append("YES\n");
            } else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }
}
