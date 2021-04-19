package cas;

public class CasVariable {

    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = this.value;
        if (oldValue == expectedValue) {
            this.value = newValue;
        }
        return oldValue;
    }
}
