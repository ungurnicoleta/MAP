package Domain.Expressions;

import Domain.ADTs.IDictionary;
import Exception.MyException;

public class VarExpression extends Expression{
    private String id;

    public VarExpression(){}

    public VarExpression(String id){
        this.id = id;
    }

    @Override
    public int evalExpr(IDictionary<String, Integer> symTable) throws MyException {
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
