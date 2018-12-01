package Domain.Statement;

import Domain.ProgramState;
import Exception.*;

import java.io.IOException;

public interface IStatement {
    ProgramState execute(ProgramState state) throws MyException, SymTableException, OpenFileException, ReadFileException, CloseFileException, IOException, HeapException;
    String toString();
}
