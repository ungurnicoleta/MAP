package Domain.ADTs;

import javax.management.openmbean.KeyAlreadyExistsException;
import Exception.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface IHeap <V>{
    //adds a new value into the heap(on nextFree location in memory)
    Integer add(V value) throws NullPointerException, KeyAlreadyExistsException;

    //updates a value on a given location in heap memory
    void update(Integer id, V value)throws NullPointerException, HeapException;


    //removes a given key from the memory (with its value)
    void remove(Integer key) throws HeapException;

    // gives the value of a given location from memory
    V lookUp (Integer id) throws HeapException;


    //tells if a given location in memory has a value or is empty
    boolean isDefined(Integer id);

    //gives a collection of the value from memory(all the values)
    Collection<V> values();

    //gives a set of the keys from memory(all the key values)
    Set<Integer> keys();

    //stringify the heap
    String toString();

    Map<Integer, V> getContent();
    void setContent(Map<Integer, V> heap);
}
