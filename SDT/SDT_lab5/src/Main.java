import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.push(4);
        stack2.push(5);
        stack2.push(6);
        stack2.push(7);

        System.out.println("Stack1 before swap: " + stack1);
        System.out.println("Stack2 before swap: " + stack2);

        Stack<Integer> tempStack1 = stack1.stream().collect(Collectors.toCollection(Stack::new));
        Stack<Integer> tempStack2 = stack2.stream().collect(Collectors.toCollection(Stack::new));

        stack1.clear();
        stack2.clear();

        tempStack2.stream().forEachOrdered(item -> stack1.push(item));
        tempStack1.stream().forEachOrdered(item -> stack2.push(item));

        System.out.println("Stack1 after swap: " + stack1);
        System.out.println("Stack2 after swap: " + stack2);
    }
}
