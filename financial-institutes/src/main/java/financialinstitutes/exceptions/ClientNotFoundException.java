package financialinstitutes.exceptions;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException() {
        super("That client is not register");
    }
}
