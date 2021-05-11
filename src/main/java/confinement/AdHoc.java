package confinement;

public class AdHoc {

    // only one thread can write to it
    // I rely only on the fact that other devs will consider this comment - that's why it's ad-hoc
    private volatile int value;

    public static void main(String[] args) {
        AdHoc adHoc = new AdHoc();
        new Thread(() -> {
            for (int i = 1 ; i < 50 ; i++) {
                adHoc.value = i * 23;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 0 ; i < 2 ; i++) {
            new Thread(() -> {
                while (true) {
                    System.out.println(adHoc.value + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }).start();
        }
    }
}
