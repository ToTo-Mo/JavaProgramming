package Syntax.Serializable;

import java.io.*;
import java.util.*;

public class Program {

    public final static String FILENAME = "src/Syntax/Serializable/Student.txt";

    public static void main(String[] args) throws ClassNotFoundException {
        Student s1 = new Student(2011, "홍길동", "경북 구미시");
        Student s2 = new Student(2011, "장길산", "서울 도봉구");

        Vector students = new Vector();
        students.add(s1);
        students.add(s2);

        try {
            FileOutputStream fileWriter = new FileOutputStream(new File(FILENAME));
            ObjectOutputStream ObjectWriter = new ObjectOutputStream(fileWriter);

            ObjectWriter.writeObject(students);
            System.out.println("성공적으로 저장됨");


            students = new Vector();

            FileInputStream fileReader = new FileInputStream(new File(FILENAME));
            ObjectInputStream ObejctReader = new ObjectInputStream(fileReader);
            students = (Vector) ObejctReader.readObject(); // 직렬화된 Student 읽기
            Iterator ite = students.iterator();
            
            while (ite.hasNext()) {
                Student s = (Student) ite.next();
                System.out.println(s.getID()+" "+ s.getName()+" " + s.getAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}