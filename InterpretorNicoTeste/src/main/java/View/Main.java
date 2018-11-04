package View;

import Controller.Controller;
import Domain.ADTs.*;
import Domain.Expressions.ArithmeticExpression;
import Domain.Expressions.ConstantExpression;
import Domain.Expressions.VarExpression;
import Domain.ProgramState;
import Domain.Statement.*;
import Repository.Repository;

import java.util.Scanner;

public class Main {
    static Repository repository = new Repository();
    static Controller ctrl = new Controller(repository);

    public static void main(String[] args) {
        IStatement originalProgram1 = new IfStatement(new ConstantExpression(10),
                new CompStatement(new AssignmentStatement("v", new ConstantExpression(5)),
                        new PrintStatement(new ArithmeticExpression("/", new VarExpression("v"),
                                new ConstantExpression(3)))),
                new PrintStatement(new ConstantExpression(100)));
        IStatement originalProgram2 = new CompStatement(new AssignmentStatement("a", new ArithmeticExpression("-",
                new ConstantExpression(2), new ConstantExpression(2))),
                new CompStatement(new IfStatement(new VarExpression("a"),new AssignmentStatement("v",new ConstantExpression(2)), new
                        AssignmentStatement("v", new ConstantExpression(3))), new PrintStatement(new VarExpression("v"))));


        IStack<IStatement> exeStack = new MyStack<IStatement>();
        //exeStack.push(originalProgram);
        IDictionary<String, Integer> symTable = new Dictionary<String, Integer>();
        IList<Integer> out = new MyList<Integer>();
        System.out.println("Choose a program: ");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int cmd = new Integer(command);
        switch (cmd) {
            case 1: {
                ProgramState myPrgState = new ProgramState(exeStack, symTable, out, originalProgram1);
                ctrl.addProgram(myPrgState);
                ctrl.allSteps();
            }
            case 2: {
                ProgramState myPrgState = new ProgramState(exeStack, symTable, out, originalProgram2);
                ctrl.addProgram(myPrgState);
                ctrl.allSteps();
            }
            default:
            {
                System.out.println("Choose another program... ");
            }
        }
    }
}
