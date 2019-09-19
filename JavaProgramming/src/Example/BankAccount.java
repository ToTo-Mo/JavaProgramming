package Example;

public class BankAccount
{
    private int accountNUmber;
    private String owner;
    private int balance;

    public void balance(int value)
    {
        balance = value;
    }

    public int balance()
    {
        return balance;
    }

    public void deposit(int value)
    {
        balance += value;
    }

    public void withdraw(int value)
    {
        balance -= value;
    }

    public void print()
    {
        System.out.println("잔액은 : " + balance + "입니다.");
    }

    public static void program()
    {
        BankAccount account = new BankAccount();

        account.balance(0);
        account.deposit(10000);
        account.print();
        account.withdraw(8000);
        account.print();
    }
}