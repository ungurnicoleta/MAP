package Domain.Expressions;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IHeap;

import Exception.*;

public class BooleanExpression extends Expression {
    private Expression expr1;
    private Expression expr2;
    private String op;

    @Override
    public int evalExpr(IDictionary<String, Integer> symTable, IHeap<Integer> hp) throws MyException, HeapException {
        switch (this.op){
            case "==":
            {
                if(this.expr1.evalExpr(symTable,hp) == this.expr2.evalExpr(symTable,hp))
                    return 1;
                return 0;
            }

            case "<=":
            {
                if(this.expr1.evalExpr(symTable,hp) <= this.expr2.evalExpr(symTable,hp))
                    return 1;
                return 0;
            }

            case ">=":
            {
                if(this.expr1.evalExpr(symTable,hp) >= this.expr2.evalExpr(symTable,hp))
                    return 1;
                return 0;
            }

            case "<":
            {
                if(this.expr1.evalExpr(symTable,hp) < this.expr2.evalExpr(symTable,hp))
                    return 1;
                return 0;
            }

            case ">":
            {
                if(this.expr1.evalExpr(symTable,hp) > this.expr2.evalExpr(symTable,hp))
                    return 1;
                return 0;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.expr1.toString() + " " + this.op + " " + this.expr2.toString();
    }
}
