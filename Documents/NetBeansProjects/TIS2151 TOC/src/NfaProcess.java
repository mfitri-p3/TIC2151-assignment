/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mfitr
 */
import java.util.*;
import java.lang.Integer;

public class NfaProcess {
    ArrayList<String> alphabetList = new ArrayList<>();
    private ArrayList<Nfa> stateList = new ArrayList();
    
    public NfaProcess(){}
    
    //set alphabet
    public void setAlphabet(String alphabet){
        alphabetList.add(alphabet);
    }
    //clear list of alphabets
    public void clearAlphabets(){
        alphabetList.clear();
    }
    //add nfa state/variable
    public void addState(Nfa state){
        stateList.add(state);
    }
    //clear list of states
    public void clearStates(){
        stateList.clear();
    }
    
    //set a state as start state
    public void setStart(String variable){
        //assume all states as non-start
        for (int i = 0; i < stateList.size(); i++) {
            stateList.get(i).start_state = false;
        }
        
        for (int j = 0; j < stateList.size(); j++) {
            if (stateList.get(j).state_name.equals(variable)) {
                stateList.get(j).start_state = true;
            }
        }
    }
    //set a state as final state
    public void setFinal(String variable){
        for (int i = 0; i < stateList.size(); i++){
            if (stateList.get(i).state_name.equals(variable)) {
                stateList.get(i).final_state = true;
            }
        } 
    }
    //reset all states as non-final state
    public void resetAllFinal(){
        for (int i = 0; i < stateList.size(); i++) {
            stateList.get(i).final_state = false;
        }
    }
    //set the transition of every state
    public void setTransition(int alpha, String nextState, String name){
        Nfa temp_state = new Nfa(); //set up temporary NFA object
        
        //find the name of the next state
        for (int i = 0; i < stateList.size(); i++) {
            if (stateList.get(i).state_name.equals(nextState)) {
                temp_state = stateList.get(i); //if matched, override the temp object
            }
        }
        
        //finalise the setTransition
        for (int i = 0; i < stateList.size(); i++) {
            if (stateList.get(i).state_name.equals(name)) {
                stateList.get(i).set_totransition(alpha, temp_state);
            }
        }
    }
    
    //return a specific state
    public Nfa getState(int pos){
        return stateList.get(pos);
    }
    public Nfa getState(String name){
        for (int i = 0; i < stateList.size(); i++) {
            if (stateList.get(i).state_name.equals(name)) {
                return stateList.get(i);
            }
        }
        return null;
    }
    //return a list of states/variables
    public ArrayList<Nfa> getStateList(){
        return stateList;
    }
    
    //check a string if it is correct or wrong
    public boolean checkString(String string){
        // set up the start state for this method
        Nfa start_state = new Nfa();
        try{
            for(int i = 0; i < stateList.size(); i++){
                if (stateList.get(i).get_start() == true) {
                    start_state = stateList.get(i);
                }
            }
            System.out.println("start state");
        }
        catch(Exception e){
            System.out.println("Exception found in NfaProcess - checkString: start state set up");
        }
        
        // create temporary state for find out the transition of the state 
        Nfa temp_state = new Nfa();
        int transition_value;
        // name the temporary state
        String temp_statename = "";
        
        boolean string_status = false;
        
        try{
            for (int x = 0; x < string.length(); x++) {
                //convert character to str
                transition_value = Character.getNumericValue(string.charAt(x));
                System.out.println("Count: " + x + ", Transition value got!");
                //use temp_state which acts a buffer for an initial state to transit
                temp_state = start_state.get_transition(transition_value);
                System.out.println("Count: " + x + ", start state get transition got!");
                
                System.out.println("Count: " + x + ", temp state get final= " + temp_state.final_state);
                
                if (temp_state.get_final() == true) {
                    string_status = true;
                    System.out.println("Count: " + x + ", string status true!");
                } else if (temp_state.get_final() != true) {
                    string_status = false;
                    System.out.println("Count: " + x + ", string status false!");
                }
                
                System.out.println("Count: " + x + ", NO string status!");

                //temp state becomes the initial state with its transition alphabet
                temp_statename = temp_state.get_statename(temp_state);
                System.out.println("Count: " + x + ", get statename for temp state got!");

                //the initial state become the next state
                start_state = temp_state;
                System.out.println("Count: " + x + ", start state becomes temp state!");
                
                System.out.println(temp_statename);
            }
        }
        catch(IllegalFormatException ife){
            System.out.println("IllegalFormatException found in NfaProcess - checkString: check per string");
        }
        catch(Exception e){
            System.out.println("Exception found in NfaProcess - checkString: check per string");
        }
        
        return string_status;
    }
}
