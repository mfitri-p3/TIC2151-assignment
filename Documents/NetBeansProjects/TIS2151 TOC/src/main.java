import java.util.*;

public class main {

    public static void main() {
        // assign each state with a name
        String state_name_1 = "S1";
        String state_name_2 = "S2";

        // name the temporary state
        String temp_statename;

        // Create state. Each object represent a state.  
        Nfa state_1 = new Nfa(state_name_1, true, false);
        Nfa state_2 = new Nfa(state_name_2, false, false);

        // Create temporary state for find out the transition of the state 
        Nfa temp_state = new Nfa();

        // Set the transition for the state 
        state_1.set_totransition(0, state_2);
        state_1.set_totransition(1, state_1);

        // use the temporary state to get the state that state 1(S1) point with transition 0
        temp_state = state_1.get_transition(0);
        // temporary state becomes the state that state 1 point with transition 0
        temp_statename = temp_state.get_statename(temp_state);

        // print out the state's name to know which state 
        System.out.println(temp_statename);
    }

}
