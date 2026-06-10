//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException, InvalidPinException {
        Account U1 = new Account("Hariom Yadav", 123456789, 2000, "New Mandi Etawah", "2126", "8859321534", "26/12/2005");
        Account U2 = new Account("Rishi", 56789012, 2500, "New Mandi Jamnagar", "1111", "8859321531", "26/12/2006");
        Account U3 = new Account("Harry", 456789012, 3000, "New Mandi Agra", "2612", "8859321532", "26/12/2007");
        Account U4 = new Account("Raj", 234567890, 1000, "New Mandi Guna", "2005", "8859321533", "26/12/2008");

        Bank bank = new Bank();

        bank.CreateAccount(U1);
        bank.CreateAccount(U2);
        bank.CreateAccount(U3);
        bank.CreateAccount(U4);
        bank.ViewAccount(123456789);
        bank.ViewAccount(999999);
        bank.Deposit(500, 123456789);
        bank.ViewAccount(123456789);

        bank.Withdraw(123456789, 1000, "2126");
        bank.ViewAccount(123456789);

        bank.Withdraw(123456789, 500, "0000");

        bank.ViewAccount(123456789);
        bank.ViewAccount(56789012);

        bank.Transfer(123456789, 56789012, 500);

        bank.ViewAccount(123456789);
        bank.ViewAccount(56789012);

        bank.DeleteAccount(456789012);

        bank.ViewAccount(456789012);

        bank.SearchAccount(234567890);
    }
}