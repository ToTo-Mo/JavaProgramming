package Example;

class ParentA{
    protected int n;

    ParentA(){n = 0;}
    ParentA(int n){this.n = n;}

    public void N(int n){this.n = n;}
    public int N(){return n;}
}

class ParentB{
    protected double f;

    ParentB(){f = 0;}
    ParentB(double f){
        this.f = f;
    }

    public void F(double value){f = value;}
    public double F(){return f;}
}

interface ParentB_I{
    public void F(double value);
    public double F();
}

class Child extends ParentA implements ParentB_I{
    private ParentB B = new ParentB();

    Child(){}
    Child(int n, double f){
        super(n);
        F(f);
    }

    @Override
    public String toString() {
        return "Child [ n : "+n+" f :"+F()+"]";
    }

    public double F() {
        return B.F();
    }

    public void F(double value) {
        B.F(value);
    }

    public static void main(String[] args){
        Child A = new Child();
        Child B = new Child(3,1.74);


        System.out.println(A.toString());
        System.out.println(B.toString());

    }
}