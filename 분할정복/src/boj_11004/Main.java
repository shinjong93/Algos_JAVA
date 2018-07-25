package boj_11004;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] ar;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ar = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(0, ar.length - 1);
        System.out.println(answer);
    }

    public static void quickSort(int low, int high) {
        if (low < high) {
            long pivot = ar[high];
            int left = low - 1;
            int right = high;

            while (true) {
                while (ar[++left] < pivot);
                while (right > low && ar[--right] > pivot);

                if (left >= right) break;
                swap(left, right);
            }

            swap(left, high);

            if (left > K - 1) {
                quickSort(low, left - 1);
            } else if (left < K - 1) {
                quickSort(left + 1, high);
            } else {
                answer = ar[left];
            }
        } else if (low == high && low == K - 1) {
            answer = ar[low];
        }
    }

    public static void swap(int left, int right) {
        int tmp = ar[left];
        ar[left] = ar[right];
        ar[right] = tmp;
    }
}
