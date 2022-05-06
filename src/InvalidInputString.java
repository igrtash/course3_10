public class InvalidInputString extends RuntimeException{
    private String invalidSymbol;

    public String getInvalidSymbol() {
        return invalidSymbol;
    }

    public InvalidInputString(String invalidSymbol) {
        this.invalidSymbol = invalidSymbol;
    }

    public InvalidInputString(String message, String invalidSymbol) {
        super(message);
        this.invalidSymbol = invalidSymbol;
    }
}
