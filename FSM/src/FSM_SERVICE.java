import java.util.List;
import java.util.logging.Logger;

/**
 * (abc)^n d(ef)^m , n >= 0, m >= 0
 * Язык распознает строки вида:
 * сколько угодно abc (0 или больше)
 * обязательный d
 * сколько угодно ef (0 или больше)
 */

public class FSM_SERVICE {

    FSM FiniteStateMachine;
    Logger logger =  Logger.getLogger(FSM.class.getName());

    public FSM_SERVICE() {}

    public FSM_SERVICE(FSM FiniteStateMachine) {
        this.FiniteStateMachine = FiniteStateMachine;
    }






}
