package Domain.ADTs;

import Exception.MyException;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Collection;
import java.util.Set;

public interface IDictionary<T1,T2> {
    void add(T1 t1, T2 t2) throws NullPointerException, KeyAlreadyExistsException;
    void update(T1 t1, T2 t2)throws NullPointerException, MyException;
    T2 lookUp (T1 id) throws MyException;
    Collection<T2> values();
    Set<T1> keys();
    boolean isDefined(T1 id);
    String toString();
    void remove(T1 key) throws MyException;
}
