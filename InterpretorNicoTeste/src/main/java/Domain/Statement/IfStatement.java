package Domain.Statement;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IStack;
import Domain.Expressions.Expression;
import Domain.ProgramState;
import Exception.MyException;

public class IfStatement implements IStatement {

    private Expression expr;
    private IStatement thenS;
    private IStatement elseS;

    public IfStatement() {
    }

    public IfStatement(Expression expr, IStatement thenS, IStatement elseS) {
        this.expr = expr;
        this.thenS = thenS;
        this.elseS = elseS;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IStack<IStatement> exeStack = state.getExeStack();
        IDictionary<String,Integer> symTable = state.getSymTable();
        if(this.expr.evalExpr(symTable)!=0)
            exeStack.push(thenS);
        else
            exeStack.push(elseS);
        return state;
    }

    @Override
    public String toString() {
        return "IF(" + this.expr.toString() + ") THEN(" + this.thenS.toString()
                + ")ELSE(" + this.elseS.toString() + ")";
    }


}
