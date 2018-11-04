package Controller;

import Domain.ADTs.IStack;
import Domain.ProgramState;
import Domain.Statement.IStatement;
import Repository.IRepository;
import Exception.MyException;

public class Controller {
    private IRepository repo;

    public Controller(IRepository repo){this.repo = repo;}

    public void addProgram(ProgramState prg){
        this.repo.addProgram(prg);
    }

    public ProgramState oneStep(ProgramState currentProgramState) throws MyException {
            IStack<IStatement> exeStack = currentProgramState.getExeStack();
            if(exeStack.isEmpty())
                throw new MyException("Exe stack is empty");
            IStatement crtStmt = exeStack.pop();
            return crtStmt.execute(currentProgramState);
        }

    public void allSteps(){
        ProgramState currentProgram = this.repo.getCurrentPrg(); // repo is the controller field of type
        // MyRepoInterface
        try{
            while(true){

                System.out.println(currentProgram.toString());
                oneStep(currentProgram);                //here you can display the prg state
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}

