package publication;

import java.util.concurrent.atomic.AtomicReference;

public class StaticInitializer {

    private static int THREADS = 4;

    public static IntWrapper wrapperStatic = new IntWrapper(13);
    // TODO: do I have to do it here, or can I later in code? I think yes (if only one is updating)
    private volatile IntWrapper wrapperVolatile = new IntWrapper(31);
    private AtomicReference<IntWrapper> wrapperAtomic = new AtomicReference<>(new IntWrapper(7));
    private IntWrapper guardedByLock;

    public synchronized void initialise() {
        guardedByLock = new IntWrapper(47);
    }

    public synchronized int getValue() {
        return guardedByLock.getValue();
    }

    public static void main(String[] args) {
        StaticInitializer staticInitializer = new StaticInitializer();
        Runnable readWrapperStatic = () -> System.out.println(wrapperStatic.getValue());
        Runnable readWrapperVolatile = () -> System.out.println(staticInitializer.wrapperVolatile.getValue());
        Runnable readWrapperAtomicReference = () -> System.out.println(staticInitializer.wrapperAtomic.get().getValue());
        Runnable readWrapperGuarded = () -> System.out.println(staticInitializer.getValue());

        for (int i = 0 ; i < THREADS ; i++) {
            new Thread(readWrapperStatic).start();
        }

        for (int i = 0 ; i < THREADS ; i++) {
            new Thread(readWrapperVolatile).start();
        }

        for (int i = 0 ; i < THREADS ; i++) {
            new Thread(readWrapperAtomicReference).start();
        }

        staticInitializer.initialise();
        for (int i = 0 ; i < THREADS ; i++) {
            new Thread(readWrapperGuarded).start();
        }
    }
}
