package Exception;


public class ReadFileException extends Exception {
    private String message;

    public ReadFileException(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return "ReadFileException " + this.message;
    }
}