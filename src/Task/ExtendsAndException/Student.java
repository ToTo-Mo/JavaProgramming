package Task.ExtendsAndException;

public class Student{
    String name,professor,address;
    int year;
    
    public Student(String name, int year, String professor, String address) {
        this.name = name;
        this.professor = professor;
        this.address = address;
        this.year = year;
    }

    public String Name() {
        return name;
    }

    public void Name(String name) throws MyException{
        if(name == null || name == "")
            throw new MyException(-400,"Null Object Error");
        this.name = name;
    }

    public String Professor() {
        return professor;
    }

    public void Professor(String professor) throws MyException{
        if(professor == null | professor == "")
            throw new MyException(-400,"Null Object Error");
        this.professor = professor;
    }

    public String Address() {
        return address;
    }

    public void Address(String address) throws MyException{
        if(address == null | address == "")
            throw new MyException(-400,"Null Object Error");
        this.address = address;
    }

    public int Year() {
        return year;
    }

    public void Year(int year){
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", year=" + year + ", professor=" + professor + ", address=" + address + "]";
    }
}