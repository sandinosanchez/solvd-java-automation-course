package financialinstitutes.exceptions;

public class IncorrectPermissionsException extends Exception {
    public IncorrectPermissionsException() {
        super("That employee doesn't have permissions");
    }
}
