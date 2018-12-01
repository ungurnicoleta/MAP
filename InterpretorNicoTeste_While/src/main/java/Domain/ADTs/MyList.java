package Domain.ADTs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Exception.MyException;

public class MyList<T1> implements IList<T1>, Iterable<T1> {
    private List<T1> myLista;

    public MyList(){
        this.myLista = new ArrayList<T1>();
    }

    @Override
    public void add(T1 elem){
        this.myLista.add(elem);
    }

    @Override
    public void delete(T1 elem) throws MyException {
        if(this.myLista.isEmpty())
            throw new MyException("The list is empty!");
            this.myLista.remove(elem);
    }

    @Override
    public int size() {
        return this.myLista.size();
    }

    @Override
    public T1 get(int index) {
        return this.myLista.get(index);
    }

    @Override
    public String toString() {
        String printList = "";
        for (T1 element : this.myLista){
            printList = printList + "Element: " + element.toString() + "\n";
        }
        return printList;
    }

    @Override
    public Iterator<T1> iterator() {
        return this.myLista.iterator();
    }
}
