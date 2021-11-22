package L05StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings st = new StackOfStrings();
        st.push("one");
        st.push("two");
        st.push("three");

        System.out.println(st.isEmpty());
        System.out.println(st.peek());

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
