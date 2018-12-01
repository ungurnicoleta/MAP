package Domain.Statement;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IHeap;
import Domain.ADTs.IStack;
import Domain.Expressions.Expression;
import Domain.ProgramState;
import Exception.*;
import java.io.IOException;


public class WhileStatement implements IStatement {

    private Expression expr;
    private IStatement stm;

    public WhileStatement(Expression expr,IStatement stm){
        this.expr = expr; this.stm = stm;}



    @Override
    public ProgramState execute(ProgramState state) throws MyException, SymTableException, OpenFileException, ReadFileException, CloseFileException, IOException, HeapException {
        IStack<IStatement> exeStack = state.getExeStack();
        IDictionary<String,Integer> symTable = state.getSymTable();
        IHeap<Integer> heap = state.getHeap();


        if(this.expr.evalExpr(symTable,heap) != 0) {
            exeStack.push(new WhileStatement(this.expr,this.stm));
            exeStack.push(this.stm);
        }

        return state;
    }

    @Override
    public String toString() {
        return "(while("+ this.expr.toString() + ")" + this.stm.toString() + ")";
    }
}
