package publication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NotSafelyPublished {

    private static int THREADS = 16;

    private IntWrapper intWrapper;

    public static void main(String[] args) {
        new NotSafelyPublished().run();
//        Initializer initializer = new Initializer();
//        Thread initializeThread = new Thread(() -> {
//            try {
//                Thread.sleep(4);
//                initializer.initialize();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        List<Thread> sanityThreads = new ArrayList<>(THREADS);
//        Runnable validateTask = () -> initializer.intWrapper.validateSanity();
//        for (int i = 0 ; i < THREADS ; i++) {
//            sanityThreads.add(new Thread(validateTask));
//        }
//
//        initializeThread.start();
//        sanityThreads.forEach(Thread::start);
    }

    private void run() {
        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            intWrapper = new IntWrapper(42);
        }).start();
        Runnable validateTask = () -> {
            if (intWrapper != null){
                intWrapper.validateSanity();
            }
        };

        for (int i = 0 ; i < 500 ; i++) {
            new Thread(validateTask).start();
        }
    }

    private static class Initializer {

        public IntWrapper intWrapper;

        public void initialize() {
            intWrapper = new IntWrapper(42);
        }
    }
}
