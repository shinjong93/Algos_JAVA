package boj_5639;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] valueArray = new int[10001];
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(valueArray,-1);
        String line;
        while((line=in.readLine())!=null){
            int tmp = Integer.parseInt(line);
            solve(1,tmp);
        }
        print(1);
  }

    public static void solve(int index, int Data){
        if(valueArray[index] == -1){
            valueArray[index] = Data;
        }

        if(valueArray[index] > Data){
            solve(index*2, Data);
        } else if(valueArray[index] < Data){
            solve(index*2 + 1, Data);
        }
    }

    public static void print(int index){
        if(valueArray[index * 2] != -1)
            print(index*2);
        if(valueArray[index*2+1] != -1)
            print(index*2+1);
        System.out.println(valueArray[index]);
    }
}

