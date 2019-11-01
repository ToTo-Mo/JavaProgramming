package Syntax.Process;

public class program {
    public static void main(String[] args) {
        try {
            String[] command = { "notepad.exe" };
            ProcessBuilder probuilder = new ProcessBuilder(command);

            Process process = probuilder.start();
            System.out.println("notepad 프로그램 실행 시작 ...");

            // 종료 시까지 대기
            process.waitFor();
            System.out.println("notepad 프로그램 실행 종료 ...");
            // 종료 시 exit 값 확인
            System.out.println("notepad 프로그램 반환 값 : " + process.exitValue());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
