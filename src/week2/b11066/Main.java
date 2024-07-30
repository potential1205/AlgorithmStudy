package week2.b11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T;

    public static void solution(int[] arr, int K){
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int val : arr){
            queue.offer(val);
        }

        int val1 = queue.poll();
        int val2 = queue.poll();
        int cum = val1+val2;

        while(queue.size()>1){
            int val = queue.poll();

            cum = cum + (cum+val);
        }

        System.out.println(cum);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(bf.readLine());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[K];
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<K; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            solution(arr, K);
        }
    }
}
