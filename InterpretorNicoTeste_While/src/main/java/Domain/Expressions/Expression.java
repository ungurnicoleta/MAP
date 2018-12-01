package Domain.Expressions;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IHeap;
import Exception.*;

public abstract class Expression {
    public abstract int evalExpr(IDictionary<String,Integer> symTable, IHeap<Integer> hp) throws MyException, HeapException;
    public abstract String toString();
}
