package ch8stackAndQueue.ImplementQueueUsingStacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Problem232 {
    public static void main(String[] args) {

    }
}

/*class MyQueue{
    //队列 先进 先出
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(!s2.isEmpty()){
            return s2.pop();
        }else {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }else {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }

    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());
    }
}*/

class MyQueue {

    Deque<Integer> s1;
    Deque<Integer> s2;

    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        process();
        return s2.pop();
    }

    public int peek() {
        process();
        return s2.peek();
    }

    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());
    }

    public void process(){
        if (!s2.isEmpty()) return;
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
