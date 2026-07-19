import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    } 

    /** Pushes element x to the top of the stack. */
    public void push(int x) {
        queue.add(x);
        // Rotate the queue to bring the new element to the front
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    /** Removes the element on the top of the stack and returns it. */
    public int pop() {
        return queue.remove();
    }

    /** Returns the element on the top of the stack. */
    public int top() {
        return queue.peek();
    }

    /** Returns true if the stack is empty, false otherwise. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
