package Exception;

public class SymTableException extends  Exception{

    private String message;

    public SymTableException(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return "SymTableException " + this.message;
    }
}
