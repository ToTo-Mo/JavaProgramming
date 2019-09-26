package Task;

import java.util.Arrays;
import java.util.Scanner;

public class Student implements Comparable<Student>{

    //score 성적    count 학생수
    private int score;
    private static int count = 0;
    
    public Student(){

    }
    
    //Student s객체와 성적 비교
    @Override
    public int compareTo(Student s) {
        return new Integer(score).compareTo(s.Score());
    }

    public static int Count(){
        return count;
    }

    public int Score() {
        return score;
    }

    public void Score(int s){
        score = s;
        count++;
    }
}

//학생 성적 관리
class ScoreManager
{
    //입출력 클래스
    IOhandler ioh;

    //성적 정렬
    public void sortScore(Student[] students){
        Arrays.sort(students,0,Student.Count());
    }

    //성적 입력
    public void setScore(Student[] students){
        ioh = new IOhandler();

        int score = 0;
        for(int i=0; i<students.length; i++){
            score = ioh.inputInt("0과 100사이의 값을 입력(이외의 값은 종료) : ");
            if(score < 0 || score > 100)
                break;
            students[i].Score(score);
        }
    }
}

class IOhandler
{
    //int 입력
    public int inputInt(String sentence){
        System.out.print(sentence);
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    // Student 배열의 성적 출력
    public void print(Student[] students){
        for(int i=0; i<Student.Count(); i++)
            System.out.print(students[i].Score()+" ");
    }

    public void print(Student student){
        System.out.print(student.Score()+" ");
    }
}

class Program
{
    public static void main(String[] args){
        IOhandler ioh = new IOhandler();
        ScoreManager sm = new ScoreManager();
        Student[] students = new Student[100];

        for(int i=0; i<students.length; i++){
            students[i] = new Student();
        }

        sm.setScore(students);
        
        System.out.println("정렬전 성적");
        ioh.print(students);

        sm.sortScore(students);

        System.out.println("\n정렬후 성적");
        ioh.print(students);
        }
}