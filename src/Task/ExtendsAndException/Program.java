package Task.ExtendsAndException;

public class Program {
    public static void main(String[] args) {
        Under underobj = new Under("이순신", 2, "김현수", "충무시", "석향");

        try {
            System.out.println(underobj.toString());
            underobj.Address("서울시");
            underobj.Circle("AIT");
            System.out.println(underobj.toString());

            System.out.println();
            underobj.Circle("");
            System.out.println(underobj.toString());

            System.out.println();
            underobj.Circle(null);
            System.out.println(underobj.toString());

        } catch (MyException e) {
            System.out.println("code " + e.Code());
            System.out.println("error " + e.Description());
            System.out.println();
        }

        try {
            Graduate graduateObj = new Graduate("장길산", 1, "김태남", "황해도", "AI");
            System.out.println(graduateObj.toString());
            graduateObj.Address("서울시");
            graduateObj.Major("PL");
            System.out.println(graduateObj.toString());

            System.out.println();
            graduateObj.Major("");
            System.out.println(graduateObj.toString());

        } catch (MyException e) {
            System.out.println("code " + e.Code());
            System.out.println("error " + e.Description());
            System.out.println();
        }

        try {
            IndustryGraduate industryGraduateObj = new IndustryGraduate("홍길동", 1, "박인용", "구미시", "AI", "삼성", "신기술",
                    "책임");

            System.out.println(industryGraduateObj.toString());
            industryGraduateObj.Address("서울시");
            industryGraduateObj.Major("PL");
            industryGraduateObj.Position("이사");
            System.out.println(industryGraduateObj.toString());

            System.out.println();
            industryGraduateObj.Position("");
            System.out.println(industryGraduateObj.toString());

        } catch (MyException e) {
            System.out.println("code " + e.Code());
            System.out.println("error " + e.Description());
            System.out.println();
        }

    }
}