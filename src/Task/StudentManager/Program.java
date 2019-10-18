package Task.StudentManager;

public class Program {
    public static void main(String[] args) {
        CStudentManager stdManager = new CStudentManager();

        stdManager.loadStudentFile("src/Task/StudentManager/StudentList.csv");
        stdManager.printStudent();
        stdManager.insertStudent("20091003", "대학원", "조현우", 2, "이해연", "포항시", 4.1, "영상처리");
        stdManager.insertStudent("20091004", "대학원", "이명환", 2, "김병만", "안동시", 4.05);
        stdManager.insertStudent("20100003", "학부", "오대석", 2, "김선명", "대구시", 3.8);
        stdManager.insertStudent("20100019", "학부", "티파니", 2, "김병만", "서울특별시", 4.35, "셈틀꾼");
        System.out.println("- Print Students ----------------------------------------------");
        stdManager.printStudent();
        System.out.println("- Sort By GPA ---------------------------------------------");
        stdManager.sortByGPA();
        System.out.println("- Print Students ----------------------------------------------");
        stdManager.printStudent();
        System.out.println("- Search By Advisor ------------------------------------------");
        stdManager.searchByAdvisor("이해연");
        stdManager.deleteStudent("20100002");
        stdManager.deleteStudent("20100019");
        stdManager.saveStudentFile("src/Task/StudentManager/StudentList_modify.csv");
        stdManager.clearAll();
        System.out.println("---------------------------------------------------------");
        stdManager.loadStudentFile("src/Task/StudentManager/StudentList_modify.csv");
        stdManager.printStudent();
    }
}