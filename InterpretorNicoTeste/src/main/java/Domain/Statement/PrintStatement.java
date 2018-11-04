package Domain.Statement;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IList;
import Domain.ADTs.IStack;
import Domain.Expressions.Expression;
import Domain.ProgramState;
import Exception.MyException;

public class PrintStatement implements IStatement{

    private Expression expr;
    public PrintStatement() {}

    public PrintStatement(Expression expr) { this.expr = expr; }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IList<Integer> lista = state.getOut();
        IDictionary<String,Integer> symTable = state.getSymTable();
        lista.add(this.expr.evalExpr(symTable));
        return state;
    }

    @Override
    public String toString() {
        return "Print: (" + this.expr.toString() + ")";
    }
}
