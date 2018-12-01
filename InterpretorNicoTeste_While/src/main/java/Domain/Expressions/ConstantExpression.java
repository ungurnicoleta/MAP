package Domain.Expressions;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IHeap;
import Exception.MyException;

public class ConstantExpression extends Expression{
    private int number;

    public ConstantExpression(){}

    public ConstantExpression(int number){this.number = number;}

    @Override
    public int evalExpr(IDictionary<String, Integer> symTable, IHeap<Integer> hp) throws MyException {
        return this.number;
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }

}
