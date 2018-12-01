package Domain.Expressions;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IHeap;
import Exception.*;

public class rHExpression extends Expression {
    private String varName;

    public rHExpression(String varName) {
        this.varName = varName;
    }

    @Override
    public int evalExpr(IDictionary<String, Integer> symTable, IHeap<Integer> hp) throws MyException, HeapException {
        int poz = symTable.lookUp(this.varName);
        return hp.lookUp(poz);
    }

    @Override
    public String toString() {
        return "rH( "+ this.varName + " )";
    }
}
