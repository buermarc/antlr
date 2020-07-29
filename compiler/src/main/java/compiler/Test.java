import java.util.Stack;

public class Test{
    public static void main(String[] args) {
        Stack<Integer[]> s1 = new Stack<Integer[]>();
        Integer[] a = {1};
        s1.push(a);

        Integer[] i  =  s1.peek();
        System.out.println(i[0]);
        i[0]++;
        System.out.println(i[0]);
        i = s1.peek();
        System.out.println(i[0]);
        s1.pop();
        System.out.println(i[0]);
        s1.pop();
        System.out.println(i[0]);
    }
}
