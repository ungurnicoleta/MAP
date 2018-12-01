package Domain.ADTs_Test;

import Domain.ADTs.MyList;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class MyListTest {
    private MyList<Integer> lista = new MyList<>();
    @Test
    public void add() {
        this.lista.add(1);
        this.lista.add(2);
        Assertions.assertDoesNotThrow(()->assertEquals(2,this.lista.size()));
        this.lista.add(3);
        Assertions.assertDoesNotThrow(()->assertEquals(3,this.lista.size()));

    }

    @Test
    public void delete() {
        this.lista.add(1);
        this.lista.add(2);
        Assertions.assertDoesNotThrow(()->assertEquals(2,this.lista.size()));
        Assertions.assertDoesNotThrow(() -> this.lista.delete(2));
        //Assertions.assertThrows(Exception.class, () -> this.lista.delete(2));
        Assertions.assertDoesNotThrow(()->assertEquals(1,this.lista.size()));
    }

    @Test
    public void size() {
        this.lista.add(1);
        this.lista.add(2);
        Assertions.assertEquals(2,this.lista.size());
    }

    @Test
    public void get() {
        this.lista.add(1);
        this.lista.add(2);
        Assertions.assertEquals(new Integer(1),this.lista.get(0));
    }


    @Test
    public void iterator() {
        this.lista.add(1);
        this.lista.add(2);
        assertEquals(1,this.lista.iterator().next().intValue());
    }
}