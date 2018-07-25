package boj_1065;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int number = Integer.parseInt(s);
        System.out.println(cal(number));
    }
    public static int cal(int number) {
        int result = 0;
        if (number < 111 && number >= 100)
            return 99;
        else if(number <= 99)
            return number;
        else {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    if (i * 100 + j * 10 + (2 * j - i) > number)
                        return result + 99;
                    if (2 * j - i < 10 && 2 * j - i >= 0)
                        result++;
                }
            }
            return result + 99;
        }
    }
}
