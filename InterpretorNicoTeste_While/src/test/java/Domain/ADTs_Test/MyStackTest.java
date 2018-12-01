package Domain.ADTs_Test;

import Domain.ADTs.MyStack;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class MyStackTest {
    private MyStack<Integer> myStack;
    @Before
    public void setUp() throws Exception {
        myStack = new MyStack<>();
        this.myStack.push(1);
        this.myStack.push(2);
    }

    @Test
    public void push() {
        Assertions.assertEquals(2,this.myStack.size());
        this.myStack.push(3);
        Assertions.assertEquals(3,this.myStack.size());
    }

    @Test
    public void pop() {
        Assertions.assertEquals(2,this.myStack.size());
        this.myStack.pop();
        Assertions.assertEquals(1,this.myStack.size());
    }

    @Test
    public void isEmpty() {
        Assertions.assertEquals(false, this.myStack.isEmpty());
    }

    @Test
    public void size() {
        Assertions.assertEquals(2,this.myStack.size());
        this.myStack.push(3);
        Assertions.assertEquals(3,this.myStack.size());
    }
}