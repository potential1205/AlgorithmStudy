package week1.b2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] board;
    static boolean[][][] visit;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    static class State{
        int y,x,cnt;
        boolean drill;

        State(int y, int x, int cnt, boolean drill){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.drill = drill;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit =  new boolean[N][M][2];

        for(int i=0; i<N; i++) {
            String line = bf.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = line.charAt(j)-'0';
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0,0,0,false));

        while(!queue.isEmpty()) {
            State s = queue.poll();

            if(s.y == N-1 && s.x == M-1) {
                System.out.println(s.cnt+1);
                return;
            }

            for(int i=0; i<4; i++) {
                int ky = s.y+dy[i];
                int kx = s.x+dx[i];

                if(ky<0 || kx<0 || ky>=N || kx>=M) {
                    continue;
                }

                if(board[ky][kx]==0 && !s.drill && !visit[ky][kx][0]){ // 벽이 아니고, 벽을 부순 적 없고, 벽을 부수지 않은 상태에서 방문한적 없음
                    queue.offer(new State(ky,kx,s.cnt+1,false));
                    visit[ky][kx][0] = true;
                }

                if(board[ky][kx]==0 && s.drill && !visit[ky][kx][1]){ // 벽이 아니고, 벽을 부순 적 있고, 벽을 부순 상태에서 방문한적 없음
                    queue.offer(new State(ky,kx,s.cnt+1,true));
                    visit[ky][kx][1] = true;
                }

                if(board[ky][kx]==1 && !s.drill && !visit[ky][kx][0]) { // 벽이고, 벽을 부순적 없고, 벽을 부수지 않은 상태에서 방문한적 없음
                    queue.offer(new State(ky,kx,s.cnt+1,true));
                    visit[ky][kx][0] = true;
                }

            }
        }
        System.out.println(-1);
    }

}
