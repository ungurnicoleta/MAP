package Domain.Expressions;

import Domain.ADTs.IDictionary;
import Exception.MyException;

public abstract class Expression {
    public abstract int evalExpr(IDictionary<String,Integer> symTable) throws MyException;
    public abstract String toString();
}
