public class Account {
    String AccountHolderName;
    long AccountNumber;
    double Balance;
    String Address;
    String PIN;
    String PhoneNumber;
    String DOB;

    public Account(String AccountHolderName, long AccountNumber,double Balance,String Address,String PIN,String PhoneNumber,String DOB){
        this.AccountHolderName = AccountHolderName;
        this.AccountNumber = AccountNumber;
        this.Balance = Balance;
        this.Address = Address;
        this.PIN = PIN;
        this.PhoneNumber = PhoneNumber;
        this.DOB = DOB;
    }
}
