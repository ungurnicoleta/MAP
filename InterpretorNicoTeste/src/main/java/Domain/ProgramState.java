package Domain;

import Domain.ADTs.IDictionary;
import Domain.ADTs.IList;
import Domain.ADTs.IStack;
import Domain.Statement.IStatement;

public class ProgramState {
    private IStack<IStatement> exeStack;
    private IDictionary<String,Integer> symTable;
    private IList<Integer> out;
    private IStatement originalProgram;

    public ProgramState(IStack<IStatement> exeStack,
                        IDictionary<String,Integer> symTable,
                        IList<Integer> out,
                        IStatement originalProgram){
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        this.originalProgram = originalProgram;
        this.exeStack.push(this.originalProgram);
    }

    public IStack<IStatement> getExeStack() {
        return this.exeStack;
    }

    public void setExeStack(IStack<IStatement> exeStack) {
        this.exeStack = exeStack;
    }

    public IDictionary<String, Integer> getSymTable() {
        return this.symTable;
    }

    public void setSymTable(IDictionary<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public IList<Integer> getOut() {
        return this.out;
    }

    public void setOut(IList<Integer> out) {
        this.out = out;
    }

    public IStatement getOriginalProgram() {
        return this.originalProgram;
    }

    public void setOriginalProgram(IStatement originalProgram) {
        this.originalProgram = originalProgram;
    }

    public String toString(){
        return "ExeStack: " + this.exeStack.toString() + "\nSymTable: " + this.symTable.toString() +
                "\nPrint Output Table: " + this.out.toString() ;
    }
}
