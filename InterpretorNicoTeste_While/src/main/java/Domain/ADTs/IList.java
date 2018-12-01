package Domain.ADTs;

import Exception.MyException;

public interface IList<T1> {
    void add(T1 elem);
    void delete(T1 elem) throws MyException;
    int size();
    T1 get(int index);
    String toString();
}
