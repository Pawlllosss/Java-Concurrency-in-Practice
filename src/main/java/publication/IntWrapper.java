package publication;

public class IntWrapper {

    private int value;

    public IntWrapper(int value) {
        this.value = value;
    }

    public void validateSanity() {
        if (value == 0) {
            throw new IllegalStateException("value != value occurred");
        }
    }
}
