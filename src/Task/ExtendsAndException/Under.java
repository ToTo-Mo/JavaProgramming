package Task.ExtendsAndException;

public class Under extends Student {
    String circle;

    public Under(String name, int year, String professor, String address, String circle) {
        super(name, year, professor, address);
        this.circle = circle;
    }

    public String Circle() {
        return circle;
    }

    public void Circle(String circle) throws MyException {
        if (circle == null | circle == "")
            throw new MyException(-200, "Circle Name - Empty Error");

        this.circle = circle;
    }

    @Override
    public String toString() {
        return "Under [name=" + name + ", year=" + year + ", professor=" + professor + ", address=" + address
                + ", circle=" + circle + "]";
    }
}