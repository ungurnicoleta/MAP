package Domain.Expressions;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IHeap;
import Exception.MyException;

public class VarExpression extends Expression{
    private String id;

    public VarExpression(String id){
        this.id = id;
    }

    @Override
    public int evalExpr(IDictionary<String, Integer> symTable, IHeap<Integer> hp) throws MyException {
        return symTable.lookUp(this.id);
    }

    @Override
    public String toString() {
        return this.id;
    }

    public String getId() {
        return this.id;
    }
}
