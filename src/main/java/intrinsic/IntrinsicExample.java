package intrinsic;

public class IntrinsicExample {
    public static void main(String[] args) {
        ServiceWithLogging serviceWithLogging = new ServiceWithLogging();
        Runnable runServiceWithLogging = () -> {
            try {
                serviceWithLogging.doAction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    new Thread(runServiceWithLogging).start();
    new Thread(runServiceWithLogging).start();
    }
}

class Service {
    public synchronized void doAction() throws InterruptedException {
        System.out.println("In Service");
        Thread.sleep(500);
        System.out.println("Out of Service");
    }
}

class ServiceWithLogging extends Service {
    @Override
    public synchronized void doAction() throws InterruptedException {
        System.out.println("Starting an action " + Thread.currentThread().getName());
        super.doAction();
        System.out.println("Action completed");
        System.out.println("==========================================");
    }
}
