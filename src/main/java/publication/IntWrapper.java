package publication;

public class IntWrapper {

    private int value;

    public IntWrapper(int value) {
        this.value = value;
    }

    public void validateSanity() {
        if (value != value) {
            throw new IllegalStateException("value != value occurred");
        }
    }
}
