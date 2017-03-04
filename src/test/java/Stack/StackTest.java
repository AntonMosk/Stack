package Stack;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit test for simple Stack.
 */
public class StackTest {

    @Test
    public void pushPopTest() {
        Stack stack = new Stack();
        System.out.println(stack);
        stack.push(0.0);
        stack.push(1.5);
        stack.push(-15.17);
        assertEquals(3, stack.getSize());
        System.out.println(stack);
        assertEquals(-15.17, stack.pop());
        assertEquals(1.5, stack.pop());
        assertEquals(0.0, stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        assertEquals(0, stack.getSize());
        System.out.println(stack);
    }
}
