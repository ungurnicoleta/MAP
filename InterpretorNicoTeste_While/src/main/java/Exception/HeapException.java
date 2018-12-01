package Exception;

public class HeapException extends Exception{

    private String message;

    public HeapException(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return "HeapException " + this.message;
    }
}
