package app;

import java.util.Stack;

public class Rec5 {
    public static void main(String[] args) throws Exception {

    }

    // 1.a) Write a program that recursively finds the average of an array of
    // integers. Is this method tail recursive?
    public double arg(int[] arr, int index, int sum, int count) {
        if (index < arr.length && index >= 0)
            return arg(arr, index + 1, sum + arr[index], count + 1);
        else
            return count == 0 ? 0 : ((double) sum) / count;
    }

    // 1.b) write a recursive method that returns the value of 2^n (using a double
    // argument, n){
    public static double twoToThePower(double n) {
        if (n == 0.0)
            return 1.0;
        else
            return (2 * twoToThePower(n - 1));
    }

    // 2) Write a recursive method that takes an integer argument, n and returns the
    // nth term in a Fibonacci sequence
    public static int fib(int n) {
        if (n <= 1)
            return n;
        else
            return fib(n - 2);
    }

    // 3) Implement Binary Search on an array with positive integers. Return -1 if
    // the target is not found
    public int bnsrch(int[] arr, int goal, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (lo > hi)
            return -1;
        else if (arr[mid] == goal)
            return mid;
        else if (arr[mid] > goal)
            return bnsrch(arr, goal, lo, mid - 1);
        else // (arr[mid] < goal)
            return bnsrch(arr, goal, mid + 1, hi);

    }

    // 4) Write a recursive method that searches through a stack of positive
    // integers for a target value, removes it, and rebuilds the stack. If the value
    // does not exist return -1
    public static int findNum(Stack<Integer> pile, int target) throws Exception {
        if (pile.size() == 0) {
            throw new Exception("Stack is empty");
        }
        int result, lastNum;
        if (pile.peek() == target)
            return pile.pop();
        else {
            lastNum = pile.pop();
            result = findNum(pile, target);
            pile.push(lastNum);
            return result;
        }
    }

    // 5) Write a recursive method that prints every in a string backwards. Is this
    // method tail recursive?
    // he may make a question on exam about converting recursion to tail recursion.
    private static void printBackW(String s, int index) {
        if (index == -1)
            return;
        else {
            System.out.println(s.charAt(index));
            printBackW(s, index - 1);
        }

    }

    // 5.b) Write a recursive method tha tprints every letter in the alpabet
    // starting from 'a' up to the given argument (lower case only) Is this method
    // tail recursive?
    public static void printUpTo(char c) {
        if (c == 'a')
            System.out.print(c);
        else
            printUpTo((char) (c - 1));
        System.out.print(c);
    }

    // 6) Write the mothods for insert, delete, and get for aLinked List
    // recursively. Which of these methods are tail-recursive? How do these methods
    // differ from the usual ones and which are better for linked lists?
    // this method will not compile because it needs a whole linked list system
    // made. In theory it works, though
    /*
     * public void insert(Node t, int val){ if(t== null){ head = new Node(val); }
     * else if(t.getNext() == null)){ t.setNext(new Node(val)); } else
     * insert(t.getNext(), val); }
     * 
     * public void remove(Node t, int val) { if (t == null) return; else if
     * (t.getData() == val) { if (t.getPrev() == null && t.getNext() == null) { head
     * = tail = null; return; } if (t.getPrev() != null)
     * t.getPrev().setNext(t.getNext()); if (t.getnext() != null)
     * t.getNext().setPrev(t.getPrev()); else remove(t.getNext(), val); }
     * 
     * }
     * 
     * public void get(Node t, int index) { if (t == null) throw Empty; if (index ==
     * 0) return t.getData(); return get(t.getNext(), index - 1); }
     */
}
