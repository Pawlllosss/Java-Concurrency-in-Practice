package publication;

class Data {

    private Object ob1 = new Object();

    private Object ob2 = new Object();

    private Object ob3 = new Object();

    private Object ob4 = new Object();

    private Object ob5 = new Object();

    private Object ob6 = new Object();

    public void check() {
        if (ob1 == null ||
                ob2 == null ||
                ob3 == null ||
                ob4 == null ||
                ob5 == null ||
                ob6 == null) {
            System.out.println("fail");
        }
    }
}

public class Program {

    private Data sharedData;

    public static void main(String[] args) {
        new Program().run();
    }

    private void run() {
        new Thread(new Runnable() {
            public void run() {
//                System.out.println("rr()");
                while (true) {
                    sharedData = new Data();
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                public void run() {
//                    System.out.println("run()");
                    while (true) {
                        Data local = sharedData;

                        if (local != null) {
                            local.check();
                        }
                    }
                }
            }).start();
        }
    }

}