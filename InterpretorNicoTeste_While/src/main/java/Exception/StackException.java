package Exception;

public class StackException extends  Exception{

    private String message;

    public StackException(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return "StackException " + this.message;
    }
}
