package Domain.ADTs;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.*;

import Exception.*;

public class Heap<V> implements IHeap<V> {
    private Integer firstEmpty;
    private HashMap<Integer, V> heap;
    private int capacity =100;
    private int[] nextFree = new int[capacity]; //the next free positions


    public Heap(){
        this.firstEmpty = 1;
        this.heap = new HashMap<>();
        for(int i=0; i < this.capacity; i++)
            this.nextFree[i] = i+1;
        this.nextFree[this.capacity-1] = -1;
    }

    @Override
    public Integer add(V value) throws NullPointerException, KeyAlreadyExistsException {
        if(firstEmpty == -1)
            realloc();
        this.heap.put(firstEmpty,value);
        Integer poz = firstEmpty;
        firstEmpty= nextFree[firstEmpty];
        return poz;
    }

    private void realloc() {
        this.nextFree = Arrays.copyOf(this.nextFree,capacity*2);
        for(int i = capacity - 1; i< this.capacity * 2; i++)
            this.nextFree[i] = i+1;
        this.nextFree[capacity*2 - 1] = -1;
        this.firstEmpty = capacity - 1;
        this.capacity = this.capacity * 2;
    }

    @Override
    public void update(Integer id, V value) throws NullPointerException, HeapException {
        if(!isDefined(id))
            throw new HeapException("Invalid address");
        this.heap.put(id, value);

    }

    @Override
    public void remove(Integer key) throws HeapException {
        if(key < 0)
            throw new HeapException("The position cannot be negative!");
        this.heap.remove(key);
        int currentFree = this.firstEmpty;
        this.firstEmpty = key;
        this.nextFree[this.firstEmpty] = currentFree;
    }

    @Override
    public V lookUp(Integer id) throws HeapException {
        if(!isDefined(id))
            throw new HeapException("This object does not exist in the heap!");
        return this.heap.get(id);
    }

    @Override
    public boolean isDefined(Integer id) {
        return this.heap.containsKey(id);
    }

    @Override
    public Collection<V> values() {
        return this.heap.values();
    }

    @Override
    public Set<Integer> keys() {
        return this.heap.keySet();
    }

    @Override
    public String toString() {
        return this.heap.toString();
    }

    public Map<Integer, V> getContent() {
        return this.heap;
    }

    public void setContent(Map<Integer, V> heap) {
        this.heap = (HashMap<Integer, V>)heap;

    }
}
