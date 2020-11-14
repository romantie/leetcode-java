package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter933 {

    Queue<Integer> q;

    public RecentCounter933() {
        q=new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek()<t-3000){
            q.poll();

        }
        return q.size();

    }


    public static void main(String[] args) {

    }
}
