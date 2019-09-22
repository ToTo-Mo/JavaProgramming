package Example;

public class Date
{
    private int year;
    private int month;
    private int day;

    public Date(int y,int m,int d){
        year =y;
        month =m;
        day =d;
    }

    public Date(int y){
        this(y,1,1);
    }

    public Date() {
        this(2010,1,1);
    }

    public int year(){
        return year;
    }

    public void year(int value){
        year =value;
    }

    public int month(){
        return month;
    }

    public void month(int value){
        month = value;
    }

    public int day(){
        return day();
    }

    public void day(int value){
        day = value;
    }

    public void print(){
        System.out.println(year + "년 " + month+"월 "+day+"일");
    }

    public static void program(){
        Date date1 = new Date(2009,3,2);
        Date date2 = new Date(2009);
        Date date3 = new Date();

        date1.print();
        date2.print();
        date3.print();
    }
}