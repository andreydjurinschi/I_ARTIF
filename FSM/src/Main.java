public class Main {
    public static void main(String[] args){
        FSM fsm = new FSM();
        FSM_SERVICE service = new FSM_SERVICE(fsm);

        System.out.println(service.check("abcdefefefefef"));
    }
}
