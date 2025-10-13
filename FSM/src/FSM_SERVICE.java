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
    SwitchRules rules;
    Logger logger =  Logger.getLogger(FSM.class.getName());

    public FSM_SERVICE() {}

    public FSM_SERVICE(FSM FiniteStateMachine) {
        this.FiniteStateMachine = FiniteStateMachine;
        rules = new SwitchRules(FiniteStateMachine);
    }

    public boolean check(String input){
        FiniteStateMachine.setState(State.state0);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(!processChar(ch)){
                logger.warning("Rejected at '" + ch + "' ");
                return false;
            }
        }

        State finalState = FiniteStateMachine.getState();
        return (finalState == State.stateD || finalState == State.stateFinal);
    }

    private boolean processChar(char ch){
        switch (FiniteStateMachine.getState()){
            case state0 -> {
                return rules.switchRuleForState0(ch);
            }
            case stateA -> {
                return rules.switchRuleForStateA(ch);
            }
            case stateB -> {
                return rules.switchRuleForStateB(ch);
            }
            case stateD -> {
                return rules.switchRuleForStateD(ch);
            }
            case stateE -> {
                return rules.switchRuleFOrStateE(ch);
            }
            default -> {
                logger.warning("Err at '" + ch + "' and state: '" + FiniteStateMachine.getState() + "' ");
                return false;
            }
        }
    }




}
