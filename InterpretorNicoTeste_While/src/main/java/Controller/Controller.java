package Controller;

import Domain.ADTs.IHeap;
import Domain.ADTs.IStack;
import Domain.ADTs.Tuple;
import Domain.ProgramState;
import Domain.Statement.IStatement;
import Repository.IRepository;
import Exception.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    private IRepository repo;

    public Controller(IRepository repo){this.repo = repo;}

    public void addProgram(ProgramState prg){
        this.repo.addProgram(prg);
    }

//    private void conservativeGarbageCollector(ProgramState state) throws HeapException{
//        Set<Integer> heapKeys = state.getHeap().keys();
//        Collection<Integer> symValues = state.getSymTable().values();
//
//        for (Integer key : heapKeys)
//            if(!symValues.contains(key)) {
//                state.getHeap().remove(key);
//                System.out.println("Eliminat");
//            }
//    }

        Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues,
                                                      Map<Integer,Integer> heap){
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public ProgramState oneStep(ProgramState currentProgramState) throws MyException, SymTableException, ReadFileException, CloseFileException, IOException, OpenFileException, HeapException {
            IStack<IStatement> exeStack = currentProgramState.getExeStack();

            if(exeStack.isEmpty())
                throw new MyException("Exe stack is empty");
            IStatement crtStmt = exeStack.pop();

            return crtStmt.execute(currentProgramState);
        }

    public void allSteps() throws IOException {
        ProgramState currentProgram = this.repo.getCurrentPrg1(); // repo is the controller field of type
        try{
            while(true){

                System.out.println(currentProgram.toString());

                oneStep(currentProgram);//here you can display the prg state
                currentProgram.getHeap().setContent(conservativeGarbageCollector(
                        currentProgram.getSymTable().values(),
                        currentProgram.getHeap().getContent()));
                //conservativeGarbageCollector(repo.getCurrentPrg1());
                this.repo.logPrgStateExec(currentProgram);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        finally {
            closeAllFiles(this.repo.getCurrentPrg1());
            System.out.println("FileTable: " + this.repo.getCurrentPrg1().getFileTable().toString());
        }
    }

    private void closeAllFiles(ProgramState state) throws IOException{
        Set<Integer> keys = state.getFileTable().keys();
        Collection <Tuple<String, BufferedReader>> values = state.getFileTable().values();

        for(Tuple<String,BufferedReader> t : values)
            t.getSecond().close();

        for(Integer key : keys) {
            state.getFileTable().remove(key);
        }
    }
}

