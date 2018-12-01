package Domain.Statement;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IHeap;
import Domain.ADTs.IStack;
import Domain.Expressions.Expression;
import Domain.ProgramState;
import Exception.*;

public class IfStatement implements IStatement {

    private Expression expr;
    private IStatement thenS;
    private IStatement elseS;


    public IfStatement(Expression expr, IStatement thenS, IStatement elseS) {
        this.expr = expr;
        this.thenS = thenS;
        this.elseS = elseS;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException, HeapException {
        IStack<IStatement> exeStack = state.getExeStack();
        IDictionary<String,Integer> symTable = state.getSymTable();
        IHeap<Integer> heap = state.getHeap();

        if (this.expr.evalExpr(symTable, heap) != 0)
                exeStack.push(thenS);
            else
                exeStack.push(elseS);

        System.out.println(toString() + "\n");
        System.out.println(state.toString());

        return state;
    }

    @Override
    public String toString() {
        return "IF(" + this.expr.toString() + ") THEN(" + this.thenS.toString()
                + ")ELSE(" + this.elseS.toString() + ")";
    }


}
