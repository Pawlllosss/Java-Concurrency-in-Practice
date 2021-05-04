package escape.reference;

import escape.reference.event.Event;
import escape.reference.event.EventListener;
import escape.reference.event.EventSource;

public class ThisEscape {

    // based on listing 3.7 and https://www.javaspecialists.eu/archive/Issue192-Implicit-Escape-of-this.html

    private final int value;

    public ThisEscape(EventSource eventSource) {
        eventSource.registerListener(new EventListener() {
            @Override
            public void onEvent(Event event) {
                checkSanity();
            }
        });
        value = 42;
    }

    private void checkSanity() {
        if (value != 42) {
            System.out.println("It's insane!");
        }
    }

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.start();
        for (int i = 0 ; i < 150000 ; i++) {
            new ThisEscape(eventSource);
        }
        System.out.println("Out of here");
    }
}
