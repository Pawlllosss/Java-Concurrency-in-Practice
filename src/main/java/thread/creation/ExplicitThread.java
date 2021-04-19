package thread.creation;

import cas.CasCounter;

import java.util.concurrent.CountDownLatch;

public class ExplicitThread {

    private static int THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        final CasCounter counter = new CasCounter();
        final CountDownLatch endGate = new CountDownLatch(THREADS);

        for (int i = 0 ; i < THREADS ; i++) {
            new Thread(() -> {
                try {
                    counter.increment();
                } finally {
//                    System.out.println("Counting down");
                    // remove to see how it works without a synchronization
                    endGate.countDown();
                }
            }).start();
        }

        endGate.await();
        System.out.println(counter.getValue());
    }
}
