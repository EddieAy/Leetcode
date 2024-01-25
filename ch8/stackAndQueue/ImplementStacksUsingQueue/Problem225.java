package ch8.stackAndQueue.ImplementStacksUsingQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem225 {
    public static void main(String[] args) {

    }
}

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> temp;
        temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public void push2(int x){
        int n = q1.size();
        q1.offer(x);
        for (int i = 0; i < n; i++) {
            q1.offer(q1.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
