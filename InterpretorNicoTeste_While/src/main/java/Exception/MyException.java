package Exception;

public class MyException extends Exception {
    private static final long serialVersionUID = 1L;

    public MyException(String MyMessage)
    {
        super(MyMessage);
    }
}
