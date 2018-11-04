package Domain.Expressions;

import Domain.ADTs.IDictionary;
import Exception.MyException;

public class ConstantExpression extends Expression{
    private int number;

    public ConstantExpression(){}

    public ConstantExpression(int number){this.number = number;}
    @Override
    public int evalExpr(IDictionary<String, Integer> symTable) throws MyException {
        return this.number;
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }

    public int getNumber() {
        return this.number;
    }
}
