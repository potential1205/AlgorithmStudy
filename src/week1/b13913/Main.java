package week1.b13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,k;
    static int[] visit;
    static final int MAX = 100001;
    static class State{
        int x;
        int time;

        State(int x, int time){
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit = new int[MAX];
        Arrays.fill(visit,-1);

        bfs();
    }

    static void bfs(){
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(n,0));

        while(!queue.isEmpty()){
            State s = queue.poll();

            if(s.x==k){
                System.out.println(s.time);
                printPath();
                return;
            }

            if(isInRange(s.x-1) && visit[s.x-1]==-1){
                queue.offer(new State(s.x-1,s.time+1));
                visit[s.x-1] = s.x;
            }
            if(isInRange(s.x+1) && visit[s.x+1]==-1){
                queue.offer(new State(s.x+1,s.time+1));
                visit[s.x+1] = s.x;
            }
            if(isInRange(s.x*2) && visit[s.x*2]==-1){
                queue.offer(new State(s.x*2,s.time+1));
                visit[s.x*2] = s.x;
            }
        }
    }

    static void printPath(){
        ArrayList<Integer> path = new ArrayList<>();

        int next = k;

        while(next!=n){
            path.add(next);
            next = visit[next];
        }

        path.add(n);

        int size = path.size();

        for(int i=0; i<size; i++){
            System.out.print(path.get(size - 1 - i) + " ");
        }
    }

    static boolean isInRange(int x){
        return 0<=x && x<MAX;
    }
}
