import java.util.*; 

public class Nfa {
    
    String state_name;
    boolean start_state;
    boolean final_state;
    private Map<Integer,Nfa> from_transition = new HashMap<Integer,Nfa>();
    private Map<Integer,Nfa> to_transition = new HashMap<Integer,Nfa>();
    
    // set the state name when create a state and set if the state is starting state or final state
    // if the state is starting state, then start_state is true, final_state is false
    // if the state is final state, then final_state is true, start_state is false
    // if the state is neither starting state or final state, then start_state and final_state are false
    Nfa()
    {
        
    }
    
    Nfa(String name, boolean start_state,boolean final_state)
    {
        state_name = name;
        this.start_state = start_state;
        this.final_state = final_state;
    }
    
    // every state has its own transition to other state through 0 or 1.
    // set the transition to the state. Example, 0 is to state 1 and 1 is to itself
    public void set_totransition(int to_int, Nfa to_state)
    {
        to_transition.put(to_int, to_state);
    }
    
    // get and retrieve the state 
    public Nfa get_transition(int to_int)
    {
        return (to_transition.get(to_int));
    }
    
    public String get_statename(Nfa object)
    {
        return (object.state_name);
    }
}