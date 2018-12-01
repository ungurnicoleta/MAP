package Domain;

import Domain.ADTs.*;
import Domain.Statement.IStatement;
import Exception.*;

import java.io.BufferedReader;

public class ProgramState {
    private IStack<IStatement> exeStack;
    private IDictionary<String,Integer> symTable;
    private IList<Integer> out;
    private IStatement originalProgram;
    private IFileTable<Integer, Tuple<String, BufferedReader>> fileTable;
    private IHeap<Integer> heap;

    public ProgramState(IStack<IStatement> exeStack,
                        IDictionary<String,Integer> symTable,
                        IList<Integer> out,IFileTable<Integer, Tuple<String, BufferedReader>> fileTable,
                        IHeap<Integer> heap,
                        IStatement originalProgram){
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        this.fileTable = fileTable;
        this.heap = heap;
        this.originalProgram = originalProgram;
        this.exeStack.push(originalProgram);
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

    public IFileTable<Integer, Tuple<String,BufferedReader>> getFileTable() {return this.fileTable;}

    public void setFileTable(IFileTable fileTable) { this.fileTable = fileTable; }

    public IHeap<Integer> getHeap() { return heap; }

    public void setHeap(IHeap<Integer> heap) { this.heap = heap; }


    public String toString(){
        return "ExeStack: " + this.exeStack.toString() +
                "\n\nSymTable: " + this.symTable.toString() +
                "\n\nPrint Output Table: \n" + this.out.toString() +
                "\nFileTable: " + this.fileTable.toString()+
                "\nHeapTable: " + this.heap.toString()+"\n\n\n";
    }

    public String toFileString() throws MyException, HeapException {
        MyStack<IStatement> stack2 = new MyStack<>();

        String output = "ExeStack:\n";
        IStatement stmt;
        while(!this.exeStack.isEmpty()){
            stmt = this.exeStack.pop();
            stack2.push(stmt);
            output= output +  stmt.toString() + "\n";
        }

        while(!stack2.isEmpty()){
            stmt = stack2.pop();
            this.exeStack.push(stmt);
        }
        output += "SymTable:\n";

        for(String key : this.symTable.keys())
            output = output + key + "-->" + this.symTable.lookUp(key) + "\n";

        output = output + "Out:\n\n";

        for (int i=0;i<this.out.size();i++)
            output = output + this.out.get(i) + "\n";

        output += "FileTable: \n";

        for(int key: fileTable.keys())
            output = output + key + "-->" + fileTable.lookUp(key).getFirst() + "\n";

        output += "Heap: \n";

        for(int key: this.heap.keys())
            output = output + key + "-->" + this.heap.lookUp(key) + "\n";

        return output;
    }
}
