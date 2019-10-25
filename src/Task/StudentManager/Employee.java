package Task.StudentManager;

public class Employee implements IEmployee {
    String name, address, company, department, position;

    public Employee(String name, String address, String company, String department, String position) {
        this.name = name;
        this.address = address;
        this.company = company;
        this.department = department;
        this.position = position;
    }

    public Employee(String company, String department, String position) {
        this(null, null, company, department, position);
    }

    public String Name() {
        return name;
    }

    public void Name(String name) throws MyException {
        if (name == null | name == "")
            throw new MyException(-400, "Null Object Error");
        this.name = name;
    }

    public String Address() {
        return address;
    }

    public void Address(String address) throws MyException {
        if (address == null | address == "")
            throw new MyException(-400, "Null Object Error");
        this.address = address;
    }

    public String Company() {
        return company;
    }

    public void Company(String company) throws MyException {
        if (company == null | company == "")
            throw new MyException(-400, "Null Object Error");
        this.company = company;
    }

    public String Department() {
        return department;
    }

    public void Department(String department) throws MyException {
        if (department == null | department == "")
            throw new MyException(-400, "Null Object Error");
        this.department = department;
    }

    public String Position() {
        return position;
    }

    public void Position(String position) throws MyException {
        if (position == null | position == "")
            throw new MyException(-300, "Position Name - Empty Error");

        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", company=" + company + ", address=" + address + ", department=" + department
                + ", position=" + position + "]";
    }
}

interface IEmployee {
    public String Company();

    public void Company(String company) throws MyException;

    public String Department();

    public void Department(String department) throws MyException;

    public String Position();

    public void Position(String position) throws MyException;
    /// 인터페이스에 메소드들을 올린다. 이렇게 한경우 산업대학원생까지 영향을 미침
}

class IndustryGraduate extends Graduate implements IEmployee {
    Employee e;

    public IndustryGraduate(String number, String course, String name, int year, String professor, String address,
            double GPA, String major, String company, String department, String position) {
        super(number, course, name, professor, year, address, GPA, major);
        e = new Employee(company, department, position);
    }

    //// 이렇게 구현을 한다 즉 직접적인 구현이라기 보다 인터페이스로 연결되어 이미 선언된 메소드를 가져온다 진짜 자바 병신 ㅇㅈ? ㅇ ~
    //// ㅇㅈㅇㅈ
    public String Company() {
        return e.Company();
    }

    public void Company(String company) throws MyException {
        if (address == null | address == "")
            throw new MyException(-400, "Null Object Error");
        e.Address(address);
    }

    public String Department() {
        return e.Department();
    }

    public void Department(String department) throws MyException {
        if (department == null | department == "")
            throw new MyException(-400, "Null Object Error");
        e.Department(department);
    }

    public String Position() {
        return e.Position();
    }

    public void Position(String position) throws MyException {
        if (position == null | position == "")
            throw new MyException(-300, "Position Name - Empty Error");
        e.Position(position);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d,%s,%s,%2f", number, course, name, year, professor, address,
                GPA) + (major != null ? ","+major : null)
                + String.format(",%s,%s,%s", e.Company(), e.Department(), e.Position());
    }
}