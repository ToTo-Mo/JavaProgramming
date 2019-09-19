package Example;

public class Date
{
    private int year;
    private int month;
    private int day;

    public int year()
    {
        return year;
    }

    public void year(int value)
    {
        year =value;
    }

    public int month()
    {
        return month;
    }

    public void month(int value)
    {
        month = value;
    }

    public int day()
    {
        return day();
    }

    public void day(int value)
    {
        day = value;
    }

    public void print()
    {
        System.out.println(year + "년 " + month+"월 "+day+"일");
    }

    public static void program()
    {
        Date date = new Date();
        date.year(2010);
        date.month(1);
        date.day(20);

        date.print();
    }



}