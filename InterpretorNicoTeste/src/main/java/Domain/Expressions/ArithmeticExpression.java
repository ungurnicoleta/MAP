package Domain.Expressions;

import Domain.ADTs.IDictionary;
import Exception.MyException;

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
    public int evalExpr(IDictionary<String, Integer> symTable) throws MyException {
        if(this.op.equals("+")) return this.e1.evalExpr(symTable) + this.e2.evalExpr(symTable);
        if(this.op.equals("-")) return this.e1.evalExpr(symTable) - this.e2.evalExpr(symTable);
        if(this.op.equals("*")) return this.e1.evalExpr(symTable) * this.e2.evalExpr(symTable);
        if(this.op.equals("/") && this.e2.evalExpr(symTable)!=0)
            return this.e1.evalExpr(symTable) / this.e2.evalExpr(symTable);
            else
                if (this.e2.evalExpr(symTable)==0)
                    throw new MyException("Division by zero exception!");
        throw new MyException("You can not perform this operation!");
    }

    @Override
    public String toString() {
        return this.e1.toString() + " " + this.op + " " + this.e2.toString();
    }

    public String getOp(){return this.op;}

    public Expression getE1(){return this.e1;}

    public Expression getE2(){return this.e2;}
}
