import java.util.Stack;

class MinStack {

    Stack<Long> st;
    long mini;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {

        // First element
        if (st.isEmpty()) {
            mini = value;
            st.push((long) value);
        }
        // Normal value
        else if (value >= mini) {
            st.push((long) value);
        }
        // New minimum found
        else {
            st.push(2L * value - mini); // store encoded value
            mini = value;
        }
    }

    public void pop() {

        if (st.isEmpty()) return;

        long top = st.pop();

        // Encoded value detected
        if (top < mini) {
            mini = 2 * mini - top; // restore previous minimum
        }
    }

    public int top() {

        long top = st.peek();

        // Normal value
        if (top >= mini) {
            return (int) top;
        }

        // Encoded value => actual top is current minimum
        return (int) mini;
    }

    public int getMin() {
        return (int) mini;
    }
}