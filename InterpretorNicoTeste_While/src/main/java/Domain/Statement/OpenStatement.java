package Domain.Statement;
import Domain.ADTs.IFileTable;
import Domain.ADTs.Tuple;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import Domain.ProgramState;
import Domain.Statement.IStatement;
import Exception.*;

public class OpenStatement implements IStatement {

    public static int current = 1;
    private String varFileId;
    private String fileName;

    public OpenStatement(String var, String fileName){
        this.varFileId = var;
        this.fileName = fileName;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException, IOException {
        IFileTable<Integer, Tuple<String, BufferedReader>> fileTable = state.getFileTable();

        for(Tuple<String, BufferedReader> value: fileTable.values())
            if(value.getFirst().equals(this.fileName))
                throw new MyException("The file"+ this.fileName + "is already open!");
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(this.fileName));
            fileTable.add(OpenStatement.current,new Tuple<>(this.fileName,buffer));
            state.getSymTable().add(this.varFileId,OpenStatement.current++);
        }
        catch (FileNotFoundException ex){
            throw new IOException("The file "+ this.fileName + " does not exist!");
        }

        System.out.println(toString() + "\n");
        System.out.println(state.toString());
        return state;
    }

    @Override
    public String toString(){
        return "openFile("+this.varFileId + ","+ this.fileName + ")";
    }
}