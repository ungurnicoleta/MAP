package Domain.Statement;

import Domain.Expressions.Expression;
import Domain.ProgramState;
import Exception.*;

import java.io.BufferedReader;
import java.io.IOException;


public class ReadStatement implements IStatement {
    private Expression expFileId;
    private String varName;


    public ReadStatement(Expression expr, String varName) {
        this.expFileId = expr;
        this.varName = varName;
    }


    @Override
    public ProgramState execute(ProgramState state) throws MyException, ReadFileException, IOException, HeapException {
        int evalExpr = this.expFileId.evalExpr(state.getSymTable(), state.getHeap());

        if (!state.getFileTable().isDefined(evalExpr))
            throw new ReadFileException("The file you try to read from is not opened!");


        BufferedReader buffer = state.getFileTable().lookUp(evalExpr).getSecond();
        String line = buffer.readLine();
        int value;

        if (line == null)
            throw new ReadFileException("Reached the end of file...");
        else if (line.length() == 0)
            state.getSymTable().add(this.varName, 0);
        else
        {
            value = Integer.parseInt(line);
            state.getSymTable().add(this.varName, value);
        }


        //System.out.println(toString() + "\n");
        //System.out.println(state.toString() + "\n");
        return state;
    }

    @Override
    public String toString() {
        return "ReadStatement(" +
                 this.expFileId.toString() +
                "," + this.varName +
                ')';
    }
}
