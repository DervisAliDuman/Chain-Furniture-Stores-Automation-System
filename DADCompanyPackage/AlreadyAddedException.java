package DADCompanyPackage;

/**
 * Exception class that throwing when something already added
 */
public class AlreadyAddedException extends Exception{
    public AlreadyAddedException(String Message) {
        super(Message);
    }
}
