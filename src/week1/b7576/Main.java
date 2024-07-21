package week1.b7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] board;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int blankCnt = 0, initTomatoCnt = 0;
    static boolean[][] visit;
    static class State{
        int y;
        int x;
        int time;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Queue<int[]> tomato = new LinkedList<>();
        board = new int[N][M];

        for(int i=0; i<N; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j]==-1) {
                    blankCnt += 1;
                } else if(board[i][j]==1) {
                    initTomatoCnt += 1;
                    tomato.offer(new int[] {i,j,0});
                }
            }
        }

        if(initTomatoCnt==N*M-blankCnt) {
            System.out.println(0);
        } else {
            System.out.println(bfs(tomato));
        }

    }

    static int bfs(Queue<int[]> tomato) {
        visit = new boolean[N][M];

        int cnt = 0;

        while(!tomato.isEmpty()) {
            int[] now = tomato.poll();
            int y = now[0];
            int x = now[1];
            int time = now[2];

            for(int i=0; i<4; i++) {
                int ky = now[0]+dy[i];
                int kx = now[1]+dx[i];

                if(ky<0 || kx<0 || ky>=N || kx>=M || visit[ky][kx]==true || board[ky][kx]==-1) continue;

                if(board[y][x]==1 && board[ky][kx]==0) {
                    board[ky][kx] = 1;
                    visit[ky][kx] = true;

                    int[] next = new int[] {ky,kx,time+1};
                    tomato.offer(next);
                    cnt+=1;
                    if(cnt==N*M-blankCnt-initTomatoCnt) {
                        return time+1;
                    }

                }

            }

        }


        return -1;
    }

}
