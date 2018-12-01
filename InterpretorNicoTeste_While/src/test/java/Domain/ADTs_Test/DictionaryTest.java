package Domain.ADTs_Test;

import Domain.ADTs.Dictionary;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.management.openmbean.KeyAlreadyExistsException;

import java.util.HashMap;

public class DictionaryTest {
    private Dictionary<String, Integer> dictionary = new Dictionary<String, Integer>();

    @Test
    public void add() {
        this.dictionary.add("map", 10);
        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals(new Integer(10), this.dictionary.lookUp("map")));
        Assertions.assertThrows(NullPointerException.class, () -> this.dictionary.update(null, null));
        Assertions.assertThrows(KeyAlreadyExistsException.class, () -> this.dictionary.add("map", 10));

    }

    @Test
    public void update() {
        this.dictionary.add("map", 10);
        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals(new Integer(10), this.dictionary.lookUp("map")));
        Assertions.assertDoesNotThrow(() -> this.dictionary.update("map",20));
        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals(new Integer(20), this.dictionary.lookUp("map")));
        Assertions.assertThrows(NullPointerException.class, () -> this.dictionary.update(null, null));
        //Assertions.assertThrows(Exception.class, () -> this.dictionary.update("fp", 10));
    }

    @Test
    public void lookUp() {
        this.dictionary.add("map", 10);
        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals(new Integer(10), this.dictionary.lookUp("map")));
    }

    @Test
    public void isDefined() {
        this.dictionary.add("map", 10);
        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals(true, this.dictionary.isDefined("map")));
    }

    @Test
    public void toStringTest() {
        this.dictionary.add("map", 10);
        Assertions.assertDoesNotThrow(() -> Assertions.assertEquals("Key: map, Value: 10\n", this.dictionary.toString()));

    }

}