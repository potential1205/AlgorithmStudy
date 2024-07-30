package week2.b2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] stairs, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i<=N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if(N==1){
            System.out.println(stairs[1]);
        } else if(N==2){
            System.out.println(stairs[1]+stairs[2]);
        } else{
            dp[1] = stairs[1];
            dp[2] = stairs[1]+stairs[2];

            for(int i=3; i<=N; i++){
                dp[i] = Math.max(dp[i-2]+stairs[i], dp[i-3]+stairs[i-1]+stairs[i]);
            }

            System.out.println(dp[N]);
        }

    }
}
