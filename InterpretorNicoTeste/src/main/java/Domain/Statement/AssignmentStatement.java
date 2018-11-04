package Domain.Statement;

import Domain.ADTs.IDictionary;
import Domain.Expressions.ConstantExpression;
import Domain.Expressions.Expression;
import Domain.ProgramState;
import Exception.MyException;

public class AssignmentStatement implements IStatement {
    private String id;
    private Expression expr;

    public AssignmentStatement(char c, ConstantExpression constantExpression, CompStatement compStatement){}

    public AssignmentStatement(String id, Expression expr){
        this.id = id;
        this.expr = expr;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IDictionary<String,Integer> symTable = state.getSymTable();
        int val = this.expr.evalExpr(symTable);
        if(symTable.isDefined(id))
            symTable.update(id, val);
        else
            symTable.add(id, val);
        return state;
    }

    @Override
    public String toString() {
        return this.id + " = " + this.expr.toString();
    }
}
