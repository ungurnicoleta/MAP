package View;

import Controller.Controller;
import Exception.MyException;

public class RunExample extends Command {
    private Controller ctrl;

    public RunExample(String key, String desc, Controller ctr) {
        super(key, desc);
        this.ctrl = ctr;
    }

    @Override
    public void execute() throws MyException {
        try {
            ctrl.allSteps();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
}
}
