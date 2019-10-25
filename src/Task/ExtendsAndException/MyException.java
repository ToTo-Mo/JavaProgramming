package Task.ExtendsAndException;

public class MyException extends Exception{
    int code;
    String description;

    public MyException(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public MyException(){
    }

    public int Code() {
        return code;
    }

    public void Code(int code) {
        this.code = code;
    }

    public String  Description() {
        return description;
    }

    public void Description(String description) {
        this.description = description;
    }
}