package Repository;

import Domain.ProgramState;

import java.io.IOException;

public interface IRepository {
    void addProgram(ProgramState newProgram);
    //ProgramState getCurrentPrg();
    ProgramState getCurrentPrg1();
    void logPrgStateExec(ProgramState prg) throws IOException;
}
