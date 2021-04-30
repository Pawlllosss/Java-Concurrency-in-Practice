package publication;

public class NotSafelyPublished {

    private static int THREADS = 16;

    private IntWrapper intWrapper;

    public static void main(String[] args) {
        new NotSafelyPublished().run();
    }

    private void run() {
        new Thread(() -> intWrapper = new IntWrapper(42)).start();
        Runnable validateTask = () -> intWrapper.validateSanity();

        for (int i = 0 ; i < THREADS ; i++) {
            new Thread(validateTask).start();
        }
    }
}
