package escape.state;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StateEscape {

    // LISTING 3.6 and 5.6

    private List<String> states = new LinkedList<>(Arrays.asList("user1", "user2", "user3"));

    public synchronized List<String> getStates() {
        return states;
    }

    public static void main(String[] args) {
        StateEscape stateEscape = new StateEscape();
        List<String> states = stateEscape.getStates();
        System.out.println(states);
        states.set(2, "maliciousUser1");
        // hidden iterator for states, with multiple threads may cause ConcurrentModificationException
        System.out.println(states);
    }
}
