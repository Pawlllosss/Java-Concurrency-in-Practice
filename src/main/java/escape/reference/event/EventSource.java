package escape.reference.event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventSource extends Thread {

    private BlockingQueue<EventListener> listeners = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (true) {
            try {
                listeners.take().onEvent(new Event());
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }
}
