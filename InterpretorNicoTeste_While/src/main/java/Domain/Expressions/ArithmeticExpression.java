package Domain.Expressions;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IHeap;
import Exception.*;

public class ArithmeticExpression extends Expression{
    private Expression e1, e2;
    private String op;

    public ArithmeticExpression(){}

    public ArithmeticExpression(String op, Expression e1, Expression e2){
        this.op = op;
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public int evalExpr(IDictionary<String, Integer> symTable, IHeap<Integer> hp) throws MyException, HeapException {
        if(this.op.equals("+")) return this.e1.evalExpr(symTable,hp) + this.e2.evalExpr(symTable,hp);
        if(this.op.equals("-")) return this.e1.evalExpr(symTable,hp) - this.e2.evalExpr(symTable,hp);
        if(this.op.equals("*")) return this.e1.evalExpr(symTable,hp) * this.e2.evalExpr(symTable,hp);
        if(this.op.equals("/") && this.e2.evalExpr(symTable, hp)!=0)
            return this.e1.evalExpr(symTable,hp) / this.e2.evalExpr(symTable,hp);
            else
                if (this.e2.evalExpr(symTable,hp)==0)
                    throw new MyException("Division by zero exception!");
        throw new MyException("You can not perform this operation!");
    }

    @Override
    public String toString() {
        return this.e1.toString() + " " + this.op + " " + this.e2.toString();
    }

}
