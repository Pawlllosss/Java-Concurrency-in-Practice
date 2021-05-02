package escape.state;

public class StateEscape {

    // LISTING 3.6

    private String[] states = new String[] {"user1", "user2", "user3"};

    public String[] getStates() {
        return states;
    }

    public void printStates() {
        for (String state : states) {
            System.out.print(state + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StateEscape stateEscape = new StateEscape();
        String[] states = stateEscape.getStates();
        stateEscape.printStates();
        states[0] = "maliciousUser1";
        stateEscape.printStates();
    }
}
