package week1.b1726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] board;
    static int[] start = new int[3];
    static int[] end = new int[3];
    static boolean[][][] visit;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    static class State{
        int y,x,d,cnt;

        State(int y, int x, int d, int cnt){
            this.y=y;
            this.x=x;
            this.d=d;
            this.cnt=cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        start[0] = Integer.parseInt(st.nextToken())-1;
        start[1] = Integer.parseInt(st.nextToken())-1;
        start[2] = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(bf.readLine());
        end[0] = Integer.parseInt(st.nextToken())-1;
        end[1] = Integer.parseInt(st.nextToken())-1;
        end[2] = Integer.parseInt(st.nextToken())-1;

        visit = new boolean[N][M][4];

        bfs();
    }

    static void bfs(){
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(start[0],start[1],start[2],0));

        while(!queue.isEmpty()){
            State s = queue.poll();

            if(s.y==end[0] && s.x==end[1] && s.d==end[2]){
                System.out.println(s.cnt);
                return;
            }

            for(int i=0; i<3; i++){
                int ky = s.y + dy[s.d] * (i+1);
                int kx = s.x + dx[s.d] * (i+1);

                if(ky<0 || kx<0 || ky>=N || kx>=M || board[ky][kx]==1){
                    break;
                }

                if(!visit[ky][kx][s.d]){
                    queue.offer(new State(ky,kx,s.d,s.cnt+1));
                    visit[ky][kx][s.d] = true;
                }
            }

            int[] direction = check(s.d);

            if(!visit[s.y][s.x][direction[0]]){
                queue.offer(new State(s.y,s.x,direction[0],s.cnt+1));
                visit[s.y][s.x][direction[0]] = true;
            }

            if(!visit[s.y][s.x][direction[1]]){
                queue.offer(new State(s.y,s.x,direction[1],s.cnt+1));
                visit[s.y][s.x][direction[1]] = true;
            }

        }
    }

    static int[] check(int d){
        int[] direction = new int[2];

        if(d==0){
            direction[0] = 3;
            direction[1] = 2;
        } else if(d==1){
            direction[0] = 2;
            direction[1] = 3;
        } else if(d==2){
            direction[0] = 0;
            direction[1] = 1;
        } else if(d==3){
            direction[0] = 1;
            direction[1] = 0;
        }
        return direction;
    }

}
