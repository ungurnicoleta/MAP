package Domain.Statement;

import Domain.ADTs.IStack;
import Domain.ProgramState;
import Exception.MyException;

public class CompStatement implements IStatement{
    private IStatement first;
    private IStatement second;

    public CompStatement() {}

    public CompStatement(IStatement first, IStatement second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IStack<IStatement> exeStack = state.getExeStack();
        exeStack.push(this.second);
        exeStack.push(this.first);
        return state;
    }

    @Override
    public String toString() {
        return  "(" + this.first.toString() + ";" + this.second.toString()+")";
    }
}
