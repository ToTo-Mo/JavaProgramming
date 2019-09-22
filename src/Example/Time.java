package Example;

public class Time {

    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);

    }
    public Time(){
        setTime(0, 0, 0);
    }
    private void setTime(int hour, int minute,int second){
        this.hour = 0 <= hour && hour < 24 ? hour : 0;
        this.minute = 0 <= minute && minute < 60 ? minute : 0;
        this.second = 0 <= second && second < 60 ? second : 0;

    }
    public void print(){
        System.out.println(hour + ":" +minute + ":" +second + ":" );
    }

    public static void program()
    {
        Time time1 = new Time();
        System.out.print("기본 생성자 호출 후 시간 ");
        time1.print();

        Time time2 = new Time(12,27,6);
        System.out.print("두번째 생성자 호출 후 시간 ");
        time2.print();

        Time time3 = new Time(99,66,77);
        System.out.print("올바르지 않은 시간 설정 후 시간 ");
        time3.print();
    }

}