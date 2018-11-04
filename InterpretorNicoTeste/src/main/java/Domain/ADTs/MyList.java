package Domain.ADTs;

import java.util.Iterator;
import java.util.LinkedList;
import Exception.MyException;

public class MyList<T1> implements IList<T1>, Iterable<T1> {
    private LinkedList<T1> lista;

    public MyList(){
        this.lista = new LinkedList<T1>();
    }

    @Override
    public void add(T1 elem){
        this.lista.add(elem);
    }

    @Override
    public void delete(T1 elem) throws MyException {
        if(this.lista.isEmpty())
            throw new MyException("The list is empty!");
            this.lista.remove(elem);
    }

    @Override
    public int size() {
        return this.lista.size();
    }

    @Override
    public T1 get(int index) {
        return this.lista.get(index);
    }

    @Override
    public String toString() {
        String printList = "";
        for (T1 element : this.lista){
            printList = printList + "Element: " + element.toString() + "\n";
        }
        return printList;
    }

    @Override
    public Iterator<T1> iterator() {
        return this.lista.iterator();
    }
}
