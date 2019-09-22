

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 *
 * @author LIM
 */
public class Project_UI extends javax.swing.JFrame{

    String string_1;
    String string_2;
    String string_3;
    String string_4;
    private static Nfa starting_state;
    private static ArrayList<Nfa> state_list;
    private boolean string_status;
    /**
     * Creates new form Project_UI
     */
    public Project_UI() {
        initComponents();
    }
    
    public static void Create_Nfa()
    {
        // assign each state with a name
        String state_name_1 = "S1";
        String state_name_2 = "S2";
        String state_name_3 = "S3";
        
        // Create state. Each object represent a state.  
        Nfa state_1 = new Nfa(state_name_1,true,false);
        Nfa state_2 = new Nfa(state_name_2,false,false);
        Nfa state_3 = new Nfa(state_name_3,false,true);
        
        // Create a list to store all state
        state_list = new ArrayList();
        state_list.add(state_1);
        state_list.add(state_2);
        state_list.add(state_3);
        
       /* // Set the transition for the state 
        state_1.set_totransition(0, state_2);
        state_1.set_totransition(1, state_1);
        state_2.set_totransition(1, state_2);
        state_2.set_totransition(0, state_3);
        state_3.set_totransition(0, state_3);
        state_3.set_totransition(1, state_3);
        */
        
        // Set the transition for the state 
        state_1.set_char_totransition('b', state_2);
        state_1.set_char_totransition('a',state_1);
        state_2.set_char_totransition('b', state_2);
        state_2.set_char_totransition('a', state_3);
        state_3.set_char_totransition('a', state_3);
        state_3.set_char_totransition('b', state_3);
        
        
        // find which state is starting state
        for(int x = 0; x < state_list.size(); x++)
        {
            if(state_list.get(x).get_start() == true)
            {
                starting_state = state_list.get(x);
            }
        }    
    }
    
    public void Get_string(Nfa state,String string1, String string2, String string3, String string4)
    { 
        if(string1.isEmpty())
        {
            jLabel1.setText("Rejected");
        }
        else
        {
            System.out.println(string1);
            Check_String(state,string1);
        }
        if(string2.isEmpty())
        {
            jLabel2.setText("Rejected");
        }
        else
        {
            System.out.println(string2);
            Check_String(state,string2);
        }
        if(string3.isEmpty())
        {
            jLabel3.setText("Rejected");
        }
        else
        {
            System.out.println(string3);
            Check_String(state,string3);
        }
        if(string4.isEmpty())
        {
            jLabel4.setText("Rejected");
        }
        else
        {
            System.out.println(string4);
            Check_String(state,string4);
        }
    }
     
    public void Check_String(Nfa start_state,String string)
    {
         // Create temporary state for find out the transition of the state 
        Nfa temp_state = new Nfa();
        int transition_intvalue;
        char transition_charvalue;
        // name the temporary state
        String temp_statename;
        
        // add the another if statement to determine the string is integer or string.
        // example, if the first alphabet of the string is 0 or 1 then is interger or else the string is contained alphabet
        if(string.charAt(0) == '0' || string.charAt(0) == '1')
        {    
            for(int x = 0; x < string.length(); x++)
            {
                //convert character to int 
                transition_intvalue = Character.getNumericValue(string.charAt(x));

                // use the temporary state to get the state that state 1(S1) point with transition 0 or 1
                temp_state = start_state.get_transition(transition_intvalue);

                if(temp_state.get_final())
                {
                    string_status = true;
                }
                else if(temp_state.get_final()!= true)
                {
                    string_status = false;
                }
                // temporary state becomes the state that state 1 point with transition 0
                temp_statename = temp_state.get_statename(temp_state);

                // transist to the state then continue to transist to other state
                // Example, S1 to S2. Then, from S2 to another state.
                // If the state transist to itself, the temp_state remains at that state
                start_state = temp_state;

                // print out the state's name to know which state 
                System.out.println(temp_statename);
            }
        }
        else
        {
            for(int x = 0; x < string.length(); x++)
            {    
                //convert character to int 
                transition_charvalue = string.charAt(x);

                // use the temporary state to get the state that state 1(S1) point with transition 0 or 1
                temp_state = start_state.get_char_transition(transition_charvalue);

                if(temp_state.get_final())
                {
                    string_status = true;
                }
                else if(temp_state.get_final()!= true)
                {
                    string_status = false;
                }
                // temporary state becomes the state that state 1 point with transition 0
                temp_statename = temp_state.get_statename(temp_state);

                // transist to the state then continue to transist to other state
                // Example, S1 to S2. Then, from S2 to another state.
                // If the state transist to itself, the temp_state remains at that state
                start_state = temp_state;

                // print out the state's name to know which state 
                System.out.println(temp_statename);
            }
        }
        
        if(string_status == true)
        {
            change_status(string_status,string);
        }
        else if(string_status == false)
        {
            change_status(string_status,string);
        }
    }
    
    public void change_status(boolean status, String string)
    {
        if(status == true && string == string_1)
        {
            jLabel1.setText("Accepted");
        }
        else if(status == false && string == string_1)
        {
            jLabel1.setText("Rejected");
        }
        else if(status == true && string == string_2)
        {
            jLabel2.setText("Accepted");
        }
        else if(status == false && string == string_2)
        {
            jLabel2.setText("Rejected");
        }
        else if(status == true && string == string_3)
        {
            jLabel3.setText("Accepted");
        }
        else if(status == false && string == string_3)
        {
            jLabel3.setText("Rejected");
        }
        else if(status == true && string == string_4)
        {
            jLabel4.setText("Accepted");
        }
        else if(status == false && string == string_4)
        {
            jLabel4.setText("Rejected");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Clear_Button = new javax.swing.JButton();
        TextField1 = new javax.swing.JTextField();
        TextField2 = new javax.swing.JTextField();
        TextField3 = new javax.swing.JTextField();
        TextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Check String");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Clear_Button.setBackground(new java.awt.Color(0, 102, 204));
        Clear_Button.setForeground(new java.awt.Color(255, 255, 255));
        Clear_Button.setText("Clear");
        Clear_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_ButtonActionPerformed(evt);
            }
        });

        TextField1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Clear_Button))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Clear_Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Clear_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_ButtonActionPerformed
        // TODO add your handling code here:
        TextField1.setText("");
        TextField2.setText("");
        TextField3.setText("");
        TextField4.setText("");
        
        jLabel1.setText("");
        jLabel2.setText("");
        jLabel3.setText("");
        jLabel4.setText("");
    }//GEN-LAST:event_Clear_ButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {    
           string_1 = TextField1.getText();
           string_2 = TextField2.getText();
           string_3 = TextField3.getText();
           string_4 = TextField4.getText();
           Get_string(starting_state,string_1,string_2,string_3,string_4);
           
        }
        catch(Exception e)
        {
            System.out.println("Invalid input");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Project_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Project_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Project_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Project_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project_UI().setVisible(true);
            }
        });
        
        Create_Nfa();
    }
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear_Button;
    private javax.swing.JTextField TextField1;
    private javax.swing.JTextField TextField2;
    private javax.swing.JTextField TextField3;
    private javax.swing.JTextField TextField4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
