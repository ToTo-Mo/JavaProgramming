package Task.StudentManager;

public class Under extends Student {
    String circle;

    public Under(String number, String course,String name, int year,String professor, String address,double GPA,String circle) {
        super(number, course,name,  year, professor,address, GPA);
        this.circle = circle != null ? circle : null;
    }

    public Under(String number, String course,String name, int year,String professor, String address,double GPA) {
        super(number, course,name,  year, professor,address, GPA);
    }

    public String Circle() {
        return circle;
    }

    public void Circle(String circle){
        this.circle = circle;
    }

    @Override
    public void show() {
        System.out.println(String.format("%s,%s,%s,%d,%s,%s,%2f", number, course, name, year, professor, address,
        GPA) + (circle == null ? "" : ","+circle)); 
    }
}