package cas;

public class CasCounter {

    private CasVariable variable;

    public CasCounter() {
        this.variable = new CasVariable();
    }

    public int getValue() {
        return variable.getValue();
    }

    public int increment() {
        int oldValue;
        do {
            oldValue = getValue();
        } while (oldValue != variable.compareAndSwap(oldValue, oldValue + 1));

        return oldValue + 1;
    }
}
