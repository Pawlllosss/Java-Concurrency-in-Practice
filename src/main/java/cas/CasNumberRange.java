package cas;

import java.util.concurrent.atomic.AtomicReference;

public class CasNumberRange {

    // LISTING 15.3
    private AtomicReference<IntRange> intRange = new AtomicReference<>(new IntRange(0, 0));

    public int getLower() {
        return intRange.get().getLower();
    }

    public void setLower(int lower) {
        while (true) {
            IntRange oldRange = intRange.get();

            int upper = oldRange.getUpper();
            if (lower > upper) {
                throw new IllegalArgumentException("Lower value is greater than upper");
            }

            IntRange newRange = new IntRange(lower, upper);

            if (intRange.compareAndSet(oldRange, newRange)) {
                //successfully changed
                return;
            }
        }
    }

    public int getUpper() {
        return intRange.get().getUpper();
    }

    public void setUpper(int upper) {
        while (true) {
            IntRange oldRange = intRange.get();

            int lower = oldRange.getLower();
            if (lower < upper) {
                throw new IllegalArgumentException("Upper value is smaller than lower");
            }

            IntRange newRange = new IntRange(lower, upper);

            if (intRange.compareAndSet(oldRange, newRange)) {
                //successfully changed
                return;
            }
        }

    }
}
