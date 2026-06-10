public class InvalidAmountException extends Exception{
    public InvalidAmountException(){
        super("Amount must be Positive!");
    }
}
