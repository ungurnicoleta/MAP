package View;

import Controller.Controller;
import Domain.ADTs.*;
import Domain.Expressions.ArithmeticExpression;
import Domain.Expressions.ConstantExpression;
import Domain.Expressions.VarExpression;
import Domain.Expressions.rHExpression;
import Domain.ProgramState;
import Domain.Statement.*;
import Repository.Repository;

import java.io.BufferedReader;
import java.util.Scanner;

class Interpreter {

    public static void main(String[] args) {
        //System.out.println("Insert the repository file: ");
        //Scanner scanner = new Scanner(System.in);
        //String logFilePath = scanner.nextLine();


        IStatement originalProgram1 = new IfStatement(
                                                new ConstantExpression(10),
                                                        new CompStatement(
                                                                new AssignmentStatement("v",
                                                                        new ConstantExpression(5)),
                                                new PrintStatement(new ArithmeticExpression("/",
                                                        new VarExpression("v"),
                                                        new ConstantExpression(3)))),
                                                new PrintStatement(new ConstantExpression(100)));




        IStatement originalProgram2 = new CompStatement(
                                                new AssignmentStatement(
                                                        "a",
                                                        new ArithmeticExpression(
                                                                "-",
                                                                new ConstantExpression(2),
                                                                new ConstantExpression(2))),
                                                new CompStatement(
                                                        new IfStatement(
                                                            new VarExpression("a"),
                                                                new AssignmentStatement(
                                                                        "v",
                                                                        new ConstantExpression(2)),
                                                                new AssignmentStatement(
                                                                        "v",
                                                                        new ConstantExpression(3))),
                                                        new PrintStatement(new VarExpression("v"))));





        IStatement originalProgram3 = new CompStatement(
                                new OpenStatement("var_f", "new.txt"),
                                new CompStatement(new ReadStatement
                                                    (new VarExpression("var_f"), "var_c"),
                                                new CompStatement(new PrintStatement(new VarExpression("var_c")),
                                new CompStatement(new IfStatement(new VarExpression("var_c"),
                                                new CompStatement(new ReadStatement(new VarExpression("var_f"), "var_c"),
                                                    new PrintStatement(new VarExpression("var_c"))),
                                                            new PrintStatement(new ConstantExpression(0))),
                                                            new CloseStatement(new VarExpression("var_f"))))));




        IStatement originalProgram4 = new CompStatement(
                new OpenStatement("var_f", "new.txt"),
                new CompStatement(
                        new ReadStatement(new VarExpression("var_f"), "c"),
                        new CompStatement(
                                new AssignmentStatement(new VarExpression("d").toString(),
                                        new ArithmeticExpression("*",
                                                new VarExpression("c"),
                                                new ConstantExpression(5))),
                                new CompStatement(
                                        new IfStatement(new VarExpression("c"),
                                                new PrintStatement(
                                                        new VarExpression("c")),
                                                new PrintStatement(new VarExpression("d"))),
                                        new CloseStatement(new VarExpression("var_f"))))));





        IStatement originalProgram5 = new CompStatement(
                new AssignmentStatement("v", new ConstantExpression(10)),
                new CompStatement(
                        new NewStatement("v", new ConstantExpression(20)),
                        new CompStatement(
                                new NewStatement("a", new ConstantExpression(22)),
                                new CompStatement(
                                        new wHStatement("a",new ConstantExpression(30)),
                                        new CompStatement(
                                                new PrintStatement(new VarExpression("a")),
                                                new CompStatement(
                                                        new PrintStatement(new rHExpression("a")),
                                                        new AssignmentStatement("a", new ConstantExpression(0))

                                                )
                                        )
                                )

                        )
                )
        );



        IStatement originalProgram6 = new CompStatement(
                new AssignmentStatement("v",new ConstantExpression(6)),
                new CompStatement(
                        new WhileStatement(
                                new ArithmeticExpression("-", new VarExpression("v"), new ConstantExpression(4)),
                                new CompStatement(
                                        new PrintStatement(new VarExpression("v")),
                                        new AssignmentStatement(
                                                "v",
                                                new ArithmeticExpression(
                                                        "-",
                                                        new VarExpression("v"),
                                                        new ConstantExpression(1)
                                                )
                                        )
                                )
                        ),
                        new PrintStatement(new VarExpression("v"))
                )
        );


        IStack<IStatement> exeStack1 = new MyStack<IStatement>();
        IStack<IStatement> exeStack2 = new MyStack<IStatement>();
        IStack<IStatement> exeStack3 = new MyStack<IStatement>();
        IStack<IStatement> exeStack4 = new MyStack<IStatement>();



        IDictionary<String, Integer> symTable1 = new Dictionary<String, Integer>();
        IDictionary<String, Integer> symTable2 = new Dictionary<String, Integer>();
        IDictionary<String, Integer> symTable3 = new Dictionary<String, Integer>();
        IDictionary<String, Integer> symTable4 = new Dictionary<String, Integer>();



        FileTable<Integer,Tuple<String,BufferedReader>> fileTable1 = new FileTable<>();
        FileTable<Integer,Tuple<String,BufferedReader>> fileTable2 = new FileTable<>();
        FileTable<Integer,Tuple<String,BufferedReader>> fileTable3 = new FileTable<>();
        FileTable<Integer,Tuple<String,BufferedReader>> fileTable4 = new FileTable<>();


        IList<Integer> out1 = new MyList<>();
        IList<Integer> out2 = new MyList<>();
        IList<Integer> out3 = new MyList<>();
        IList<Integer> out4 = new MyList<>();


        IHeap<Integer> heap1 = new Heap<>();
        IHeap<Integer> heap2 = new Heap<>();
        IHeap<Integer> heap3 = new Heap<>();
        IHeap<Integer> heap4 = new Heap<>();


        ProgramState myPrgState1 = new ProgramState(exeStack1, symTable1, out1, fileTable1,heap1 ,originalProgram1);
        ProgramState myPrgState2 = new ProgramState(exeStack2, symTable2, out2, fileTable2,heap2 ,originalProgram5);
        ProgramState myPrgState3 = new ProgramState(exeStack3, symTable3, out3, fileTable3,heap3 ,originalProgram4);
        ProgramState myPrgState4 = new ProgramState(exeStack4, symTable4, out4, fileTable4,heap4 ,originalProgram6);


        Repository repository1 = new Repository("log1.txt", myPrgState1);
        Repository repository2 = new Repository("log2.txt", myPrgState2);
        Repository repository3 = new Repository("log3.txt", myPrgState3);
        Repository repository4 = new Repository("log4.txt", myPrgState4);



        Controller ctrl1 = new Controller(repository1);
        Controller ctrl2 = new Controller(repository2);
        Controller ctrl3 = new Controller(repository3);
        Controller ctrl4 = new Controller(repository4);



        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",originalProgram1.toString(),ctrl1));
        menu.addCommand(new RunExample("2",originalProgram5.toString(),ctrl2));
        menu.addCommand(new RunExample("3",originalProgram4.toString(),ctrl3));
        menu.addCommand(new RunExample("4",originalProgram6.toString(),ctrl4));
        menu.show();


    }

}

