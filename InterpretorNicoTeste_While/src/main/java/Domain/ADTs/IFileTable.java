package Domain.ADTs;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.Set;

public interface IFileTable<K, V> {

    void add(K key, V value);
    boolean isDefined(K key);
    V lookUp(K key);
    void remove(K key);
    Collection<V> values();
    Set<K> keys();
    String toString();
}
