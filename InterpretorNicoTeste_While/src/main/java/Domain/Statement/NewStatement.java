package Domain.Statement;

import Domain.Expressions.Expression;
import Domain.ProgramState;

import java.io.IOException;
import Exception.*;

public class NewStatement implements IStatement{
    private String varName;
    private Expression expr;

    public NewStatement(String var, Expression ex){
        this.varName = var;
        this.expr = ex;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException, HeapException {

        int v = this.expr.evalExpr(state.getSymTable(), state.getHeap());
        int poz = state.getHeap().add(v);

        state.getSymTable().add(this.varName, poz);

        return state;
    }

    @Override
    public String toString(){
        return "new( "+ this.varName + "," + this.expr.toString() +" )";
    }
}
