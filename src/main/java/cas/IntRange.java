package cas;

public class IntRange {

    // LISTING 15.3
    private final int lower;
    private final int upper;

    public IntRange(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }
}
