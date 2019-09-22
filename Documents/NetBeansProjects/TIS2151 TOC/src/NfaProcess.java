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

public class NfaProcess {
    private String[] alphabetList = new String[4];
    private ArrayList<Nfa> stateList = new ArrayList();
    
    public NfaProcess(){}
    
    //set alphabet
    public void setAlphabet(String alphabet, int pos){
        alphabetList[pos] = alphabet;
    }
    //clear list of alphabets
    public void clearAlphabets(){
        for (int i = 0; i < alphabetList.length; i++) {
            alphabetList[i] = "";
        }
    }
    //set nfa state
    public void addState(Nfa state){
        stateList.add(state);
    }
    //clear list of states
    public void clearStates(){
        stateList.clear();
    }
    
    //set a state as start state
    public void setStart(String variable){
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
        for (Nfa state : stateList){
            if (state.state_name.equals(variable)){
                state.final_state = true;
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
    public void setTransition(Object alpha, String name){
        
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
    
    //check a string if it is correct or wrong
    public boolean checkString(String string){
        // Create temporary state for find out the transition of the state 
        Nfa temp_state = new Nfa();
        int transition_value;
        // name the temporary state
        String temp_statename;
        
        for (int x = 0; x < string.length(); x++) {
            //convert character to int
        }
        
        return true;
    }
}
