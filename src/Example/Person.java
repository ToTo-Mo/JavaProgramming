package Example;

public class Person{
    String name;
    int age;
    int gender;

    Person(String n, int a, int g){
        name = n;   age = a;    gender = g;
    }

    Person(){}

    public String Name() {
        return name;
    }

    public void Name(String name) {
        this.name = name;
    }

    public int Age() {
        return age;
    }

    public void Age(int age) {
        this.age = age;
    }

    public int Gender() {
        return gender;
    }

    public void Gender(int gender) {
        this.gender = gender;
    }

}

class Employee extends Person{
    int number;
    int salary;

    Employee(String n, int a, int g, int num, int s){
        super(n,a,g);
        number =num;
        salary = s;
    }

    public void Number(int value){number= value;}
    public int Number(){return number;}

    public void Salary(int value){salary = value;}
    public int Salary(){return salary;}

    public void display() {
        System.out.println("이름\t나이\t성별\t학번\t\t연봉\t");
        System.out.println(name+"\t"+age+"\t"+(gender == 1 ? "남성":"여성")+"\t"+number+"\t"+salary);
    }

    public static void main(String[] agrs){
        Employee e = new Employee("최범휘", 23, 1, 20161213, 3000);
        e.display();
    }
}

