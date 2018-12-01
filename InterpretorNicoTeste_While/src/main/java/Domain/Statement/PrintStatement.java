package Domain.Statement;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IHeap;
import Domain.ADTs.IList;
import Domain.ADTs.IStack;
import Domain.Expressions.Expression;
import Domain.ProgramState;
import Exception.*;

public class PrintStatement implements IStatement{

    private Expression expr;
    public PrintStatement() {}

    public PrintStatement(Expression expr) { this.expr = expr; }

    @Override
    public ProgramState execute(ProgramState state) throws MyException, HeapException {

        IList<Integer> out = state.getOut();
        IDictionary<String,Integer> symTable = state.getSymTable();
        IHeap<Integer> heap = state.getHeap();

        out.add(this.expr.evalExpr(symTable,heap));

        System.out.println(toString() + "\n");
        System.out.println(state.toString());

        return state;
    }

    @Override
    public String toString() {
        return "Print: (" + this.expr.toString() + ")";
    }
}
