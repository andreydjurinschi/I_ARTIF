/**
 * класс конечного автомата с текущим состоянием
 */

public class FSM {
    private State state;

    public FSM() {
    }

    public FSM(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
