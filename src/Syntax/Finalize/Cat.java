package Syntax.Finalize;

public class Cat {
    int size;
    String name;

    public Cat() {
        this("영순이", 50);
    }

    public Cat(String n, int s) {
        name = n;
        size = s;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Cat [name=" + name + ", size=" + size + "]";
    }

    public void finalize() throws Throwable {
        System.out.println(name + " 고양이가 소멸됨");

    }

    public static void program() {
        Cat c = new Cat("이쁜이", 45);
        Cat c2 = new Cat();

        System.out.println(c.toString());
        System.out.println(c2.toString());

        try {
            // 객체 할당 반환
            c.finalize();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 소멸자
        try {
            c2.finalize();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 소멸자
    }
}
