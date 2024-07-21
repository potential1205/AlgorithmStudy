package week1.b7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int L,T;
    static int sy,sx;
    static int ey,ex;
    static int[] dy = {-2,-2,-1,-1, 1, 2,2,1};
    static int[] dx = {-1, 1,-2, 2,-2,-1,1,2};
    static boolean[][] visit;

    static class State{
        int y;
        int x;
        int cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int t=0; t<T; t++) {
            L = sc.nextInt();
            sy = sc.nextInt();
            sx = sc.nextInt();
            ey = sc.nextInt();
            ex = sc.nextInt();

            System.out.println(bfs());
        }
    }

    public static int bfs() {
        visit = new boolean[L][L];
        Queue<State> queue = new LinkedList<State>();
        State init = new State();
        init.y = sy;
        init.x = sx;
        init.cnt = 0;

        queue.offer(init);

        while(!queue.isEmpty()) {

            State s = queue.poll();
            int y = s.y;
            int x = s.x;

            if(y==ey && x==ex) return s.cnt;

            for(int i=0; i<8; i++) {
                int ky = y+dy[i];
                int kx = x+dx[i];

                if(ky<0 || kx<0 || ky>=L || kx>=L || visit[ky][kx]==true) continue;

                State newState = new State();
                newState.y = ky;
                newState.x = kx;
                newState.cnt = s.cnt+1;
                visit[ky][kx] = true;

                queue.offer(newState);
            }
        }

        return -1;
    }


}
