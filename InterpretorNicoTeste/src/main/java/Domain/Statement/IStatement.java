package Domain.Statement;

import Domain.ProgramState;
import Exception.MyException;

public interface IStatement {
    ProgramState execute(ProgramState state) throws MyException;
    String toString();
}
