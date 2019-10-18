package Task.StudentManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CStudentManager {

    ArrayList<Student> StudentList;

    public CStudentManager() {
        StudentList = new ArrayList<Student>();
    }

    public void insertStudent(String number, String course, String name, int year, String professor, String address,
            double GPA, String circleOrMajor) {
        if (course.equals("학부"))
            StudentList.add(new Under(number, course, name, professor, year, address, GPA, circleOrMajor));
        else if (course.equals("대학원"))
            StudentList.add(new Graduate(number, course, name, professor, year, address, GPA, circleOrMajor));
    }

    public void insertStudent(String number, String course, String name, int year, String professor, String address,
            double GPA) {
        if (course.equals("학부"))
            StudentList.add(new Under(number, course, name, professor, year, address, GPA));
        else if (course.equals("대학원"))
            StudentList.add(new Graduate(number, course, name, professor, year, address, GPA));
    }

    public void insertStudent(Student newStudnet) {
    }

    public void deleteStudent(String number) {
        for (int i = 0; i < StudentList.size(); i++) {
            if (StudentList.get(i).Number().equals(number)) {
                StudentList.remove(i);
                break;
            }
        }
    }

    public void clearAll() {
        StudentList = new ArrayList<Student>();
    }

    public void sortByGPA() {
        Collections.sort(StudentList);
    }

    public void printStudent() {
        for (int i = 0; i < StudentList.size(); i++) {
            System.out.println(StudentList.get(i).toString());
        }
    }

    public void searchByAdvisor(String advisorName) {
        for (Student std : StudentList) {
            if (std.Professor().equals(advisorName))
                System.out.println(std.toString());
        }
    }

    public void loadStudentFile(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));

            ArrayList<String[]> studentList = new ArrayList<String[]>();
            String line = "";
            while ((line = in.readLine()) != null) {
                String[] content = line.split(",");
                studentList.add(content);
            }

            for (String[] content : studentList) {
                if (content[1].equals("학부") || content[1].equals("대학원")) {
                    if (content.length == 8)
                        this.insertStudent(content[0], content[1], content[2], Integer.parseInt(content[3]), content[4],
                                content[5], Double.parseDouble(content[6]), content[7]);

                    if (content.length == 7)
                        this.insertStudent(content[0], content[1], content[2], Integer.parseInt(content[3]), content[4],
                                content[5], Double.parseDouble(content[6]));

                } else if (content[1].equals("산업대학원")) {
                    StudentList.add(new IndustryGraduate(content[0], content[1], content[2],
                            Integer.parseInt(content[3]), content[4], content[5], Double.parseDouble(content[6]),
                            content[7], content[8], content[9], content[10]));
                }

                in.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveStudentFile(String fileName) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

            for (Student s : StudentList) {
                if (s.Course().equals("학부") | s.Course().equals("대학원")) {
                    out.write(String.format("%s,%s,%s,%s,%s,%s,%s", s.Number(), s.Course(), s.Name(),
                            Integer.toString(s.Year()), s.Professor(), s.Address(), Double.toString(s.GPA())));

                    if (s.Course().equals("학부") && ((Under) s).Circle() != null)
                        out.write(String.format(",%s", ((Under) s).Circle()));

                    if (s.Course().equals("대학원") && ((Graduate) s).Major() != null)
                        out.write(String.format(",%s", ((Graduate) s).Major()));

                    out.newLine();
                }

                else if (s.Course().equals("산업대학원")) {
                    IndustryGraduate is = (IndustryGraduate) s;

                    out.write(String.format("%s,%s,%s,%s,%s,%s,%s", is.Number(), is.Course(), is.Name(),
                            Integer.toString(is.Year()), is.Professor(), is.Address(), Double.toString(is.GPA())));

                    if (is.Major() != null)
                        out.write(String.format(",%s", is.Major()));

                    out.write(String.format(",%s,%s,%s", is.Company(), is.Department(), is.Position()));

                    out.newLine();
                }

            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
