package Task.ExtendsAndException;

public class Graduate extends Student {
    String major;

    public Graduate(String name, int year, String professor, String address, String major) {
        super(name, year, professor, address);
        this.major = major;
    }

    public String Major() {
        return major;
    }

    public void Major(String major) throws MyException {
        if (major == null | major == "")
            throw new MyException(-100, "Major Name - Empty Error");

        this.major = major;
    }

    @Override
    public String toString() {
        return "Graduate [course=Graduate" + ", name=" + name + ", year=" + year + ", professor=" + professor
                + ", address=" + address + ", major=" + major + "]";
    }

}