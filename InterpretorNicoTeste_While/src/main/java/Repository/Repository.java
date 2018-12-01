package Repository;

import Domain.ADTs.MyList;
import Domain.ProgramState;
import Exception.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Repository implements IRepository {
    private MyList<ProgramState> repo;
    private String logFilePath;


    public Repository(String logFilePath, ProgramState prg){
        this.repo = new MyList<>();
        this.logFilePath = logFilePath;
        this.addProgram(prg);
    }

    @Override
    public void addProgram(ProgramState newProgram) {
        this.repo.add(newProgram);
    }

    public ProgramState getCurrentPrg1() {
        return this.repo.get(0);
    }

    public void logPrgStateExec(ProgramState prg) throws IOException{
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(this.logFilePath, true)));
            logFile.write(prg.toFileString());
            logFile.close();
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
        catch (HeapException h) {
            System.out.println("Heap exception!!");
        }
    }
}
