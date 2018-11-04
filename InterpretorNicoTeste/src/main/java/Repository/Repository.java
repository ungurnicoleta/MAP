package Repository;

import Domain.ADTs.MyList;
import Domain.ProgramState;

import java.util.LinkedList;
import java.util.Queue;


public class Repository implements IRepository {
    private Queue<ProgramState> repo;

    public Repository(){
        this.repo = new LinkedList<>();
    }

    @Override
    public void addProgram(ProgramState newProgram) {
        this.repo.add(newProgram);
    }

    @Override
    public ProgramState getCurrentPrg() {
        return this.repo.poll();
    }
}
