public class Bank {
    Account[] accounts = new Account[10];
    int accountCount = 0;
    public void CreateAccount(Account U1){
        if(accountCount >= 10){
            System.out.println("Bank limit need to be increased");
            return;
        }
        accounts[accountCount] = U1;
        accountCount++;
        System.out.println("Account Created Successfully!");
    }
    public void ViewAccount(long AccountNumber) throws AccountNotFoundException {
        for(int i=0; i<accountCount; i++){
            if(accounts[i].AccountNumber == AccountNumber){
                System.out.println("Account Holer Name: "+ accounts[i].AccountHolderName);
                System.out.println("Account Number: "+ accounts[i].AccountNumber);
                System.out.println("Balance: "+ accounts[i].Balance);
                System.out.println("Address: "+ accounts[i].Address);
                System.out.println("Phone Number: "+ accounts[i].PhoneNumber);
                System.out.println("DOB: "+ accounts[i].DOB);
                return;
            }
        }
        throw new AccountNotFoundException();
    }
    public void SearchAccount(long AccountNumber) throws AccountNotFoundException {
        ViewAccount(AccountNumber);
    }
    public void Deposit(double Amount, long AccountNumber) throws InvalidAmountException, AccountNotFoundException {
        if(Amount <=0 ){
            throw new InvalidAmountException();
        }
        for(int i=0; i<accountCount; i++){
            if(accounts[i].AccountNumber == AccountNumber){
                accounts[i].Balance += Amount;
                System.out.println("The amount has been Deposited");
                return;
            }
        }
        throw new AccountNotFoundException();
    }
    public void Withdraw(long AccountNumber, double Amount, String PIN) throws InvalidAmountException, InsufficientBalanceException, InvalidPinException, AccountNotFoundException {
        if(Amount <=0 ){
            throw new InvalidAmountException();
        }
        for(int i=0; i<accountCount; i++){
            if (accounts[i].AccountNumber == AccountNumber) {
                if(accounts[i].PIN.equals(PIN)){
                    if(accounts[i].Balance >= Amount){
                        accounts[i].Balance -= Amount;
                        System.out.println("The Amount "+ Amount + "is withdrawn Remaining balance is: "+ accounts[i].Balance);
                        return;
                    }
                    throw new InsufficientBalanceException();
                }
                throw new InvalidPinException();
            }
        }
        throw new AccountNotFoundException();
    }
    public void Transfer(long senderAccountNumber,long recieverAccountNumber,double amount) throws InsufficientBalanceException, AccountNotFoundException, InvalidAmountException {

            Account sender = null;
            Account receiver = null;

            if(amount <= 0){
                throw new InvalidAmountException();
            }

            // Find sender and receiver
            for(int i = 0; i < accountCount; i++){

                if(accounts[i].AccountNumber == senderAccountNumber){
                    sender = accounts[i];
                }

                if(accounts[i].AccountNumber == recieverAccountNumber){
                    receiver = accounts[i];
                }
            }

            // Check if accounts exist
            if(sender == null || receiver == null){
                throw new AccountNotFoundException();
            }

            // Check balance
            if(sender.Balance < amount){
                throw new InsufficientBalanceException();
            }

            // Transfer money
            sender.Balance -= amount;
            receiver.Balance += amount;

            System.out.println("Transfer Successful!");
            System.out.println("Sender Balance: " + sender.Balance);
            System.out.println("Receiver Balance: " + receiver.Balance);
        }

    public void DeleteAccount(long AccountNumber) throws AccountNotFoundException {
        for(int i=0; i<accountCount; i++){
            if(accounts[i].AccountNumber == AccountNumber){
                for(int j=i; j<accountCount-1; j++){
                    accounts[j] = accounts[j+1];
                }
                accounts[accountCount-1] = null;
                accountCount--;
                System.out.println("Account deleted successfully!");
                return;
            }
        }
        throw new AccountNotFoundException();
    }
}
