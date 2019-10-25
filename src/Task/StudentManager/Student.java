package Task.StudentManager;

public abstract class Student implements Comparable<Student>{
    String number,course,name,professor,address;
    int year;
    double GPA;
        
    public Student(String number, String course, String name, String professor, int year, String address, double GPA) {
        this.number = number;
        this.course = course;
        this.name = name;
        this.professor = professor;
        this.address = address;
        this.year = year;
        this.GPA = GPA;
    }

    public String Name(){
        return name;
    }

    public void Name(String name) throws MyException {
        if (name == null || name == "")
            throw new MyException(-400, "Null Object Error");
        this.name = name;
    }

    public String Professor() {
        return professor;
    }

    public void Professor(String professor) throws MyException {
        if (professor == null | professor == "")
            throw new MyException(-400, "Null Object Error");
        this.professor = professor;
    }

    public String Address() {
        return address;
    }

    public void Address(String address) throws MyException {
        if (address == null | address == "")
            throw new MyException(-400, "Null Object Error");
        this.address = address;
    }

    public int Year() {
        return year;
    }

    public void Year(int year) {
        this.year = year;
    }

    public String Number() {
        return number;
    }

    public void Number(String number) throws MyException {
        if (number == null | number == "")
            throw new MyException(-400, "Null Object Error");
        this.number = number;
    }

    public String Course() {
        return course;
    }

    public double GPA() {
        return GPA;
    }

    public void GPA(double GPA) {
        this.GPA = GPA;
    }

    public void Course(String course) throws MyException {
        if (course == null | course == "")
            throw new MyException(-400, "Null Object Error");
        this.course = course;
    }

    public abstract void show();

    @Override
    public int compareTo(Student s) {
        if(this.GPA < s.GPA())
            return 1;
        else if (this.GPA > s.GPA())
            return -1;
        else 
            return 0;
    }

    @Override
    public boolean equals(Object obj){
        return this.number == ((Student)obj).Number();
    }
}