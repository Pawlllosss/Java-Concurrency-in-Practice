package intrinsic;

public class CounterIntrinsic {

    // LISTING 4.1
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalStateException("Maximum value of long");
        }
        this.value = value + 1;
        return this.value;
    }
}
