package publication;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NotSafelyPublished {

    private static int THREADS = 16;

    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        // TODO: try to do this just on threads.
        // TODO: could be used also as an example for the thread.creation package
        Executor executor = Executors.newFixedThreadPool(THREADS);
        executor.execute(initializer::initialize);
//        System.out.println("Initialized");

        Runnable validateTask = () -> initializer.intWrapper.validateSanity();
        for (int i = 0 ; i < 2500 ; i++) {
            executor.execute(validateTask);
//            System.out.println("Executed");
        }


        // TODO: execute vs submit
    }

    private static class Initializer {

        public IntWrapper intWrapper;

        public void initialize() {
            intWrapper = new IntWrapper(42);
        }
    }
}
