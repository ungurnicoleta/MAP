package Domain.ADTs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class FileTable<K, V> implements IFileTable<K, V> {
    private HashMap<K,V> fileTable;

    public FileTable(){
        this.fileTable = new HashMap<K, V>();
    }

    @Override
    public void add(K key, V value){
        this.fileTable.put(key, value);
    }

    @Override
    public boolean isDefined(K key){
        return this.fileTable.containsKey(key);
    }

    @Override
    public V lookUp(K key){
        //todo exception thrown
        return this.fileTable.get(key);
    }

    @Override
    public void remove(K key){
        this.fileTable.remove(key);
    }

    @Override
    public Collection<V> values(){
        return this.fileTable.values();
    }

    @Override
    public Set<K> keys(){
        return this.fileTable.keySet();
    }

    @Override
    public String toString(){
        return fileTable.toString();
    }
}