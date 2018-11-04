package Repository;

import Domain.ProgramState;

public interface IRepository {
    void addProgram(ProgramState newProgram);
    ProgramState getCurrentPrg();
}
