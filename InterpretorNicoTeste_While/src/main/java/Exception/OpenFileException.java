package Exception;

public class OpenFileException extends Exception{

    private String message;
    public OpenFileException(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return "OpenFileException " + this.message;
    }
}
