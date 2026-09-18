class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty())
        {
            return;
        }
        int top=st.pop();
        reverseStack(st);
        insertAtBottom(st,top);
    }
    private static void insertAtBottom(Stack<Integer> s, int x){
        if(s.isEmpty()){
            s.push(x);
            return;
        }
        int temp=s.pop();
        insertAtBottom(s,x);
        s.push(temp);
    }
}
