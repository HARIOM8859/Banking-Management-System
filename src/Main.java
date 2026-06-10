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

// ================================
// TEST 1: View Existing Account
// ================================
        try {
            bank.ViewAccount(123456789);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 2: Account Not Found
// ================================
        try {
            bank.ViewAccount(999999999);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 3: Valid Deposit
// ================================
        try {
            bank.Deposit(500, 123456789);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 4: Invalid Deposit Amount
// ================================
        try {
            bank.Deposit(-500, 123456789);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 5: Valid Withdraw
// ================================
        try {
            bank.Withdraw(123456789, 500, "2126");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 6: Invalid PIN
// ================================
        try {
            bank.Withdraw(123456789, 500, "0000");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 7: Insufficient Balance
// ================================
        try {
            bank.Withdraw(123456789, 100000, "2126");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 8: Valid Transfer
// ================================
        try {
            bank.Transfer(123456789, 56789012, 500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            bank.ViewAccount(123456789);
            bank.ViewAccount(56789012);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 9: Transfer To Invalid Account
// ================================
        try {
            bank.Transfer(123456789, 99999999, 500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 10: Delete Existing Account
// ================================
        try {
            bank.DeleteAccount(456789012);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 11: Verify Delete
// ================================
        try {
            bank.ViewAccount(456789012);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 12: Search Existing Account
// ================================
        try {
            bank.SearchAccount(234567890);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// ================================
// TEST 13: Search Non Existing Account
// ================================
        try {
            bank.SearchAccount(111111111);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}