/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author machok
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        field = new javax.swing.JTextField[10][10];
        orbtn = new javax.swing.JButton[10];
        addline = new javax.swing.JButton();
        transform = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(214, 214, 214));
        jPanel1.setLayout(new java.awt.GridBagLayout());
         gbc = new GridBagConstraints();
          //gbc.fill = GridBagConstraints.HORIZONTAL;
          gbc.anchor = GridBagConstraints.NORTHWEST;
          gbc.weightx=1;
          gbc.weighty=1;

         newline(0);


        addline.setText("new line");

        transform.setText("transform");



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(transform)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addline)
                    )
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addline))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transform)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


   public void newline(int n){
     field[n][0]=new javax.swing.JTextField(3);

     gbc.gridx = 0;   gbc.gridy = n;
     jPanel1.add(field[n][0],gbc);

     gbc.gridx = 1;   gbc.gridy = n;
     jPanel1.add(new javax.swing.JButton("-->"),gbc);

     field[n][1]=new javax.swing.JTextField(3);
     gbc.gridx = 2;   gbc.gridy = n;
     jPanel1.add(field[n][1],gbc);

     gbc.gridx = 3;   gbc.gridy = n;
     orbtn[n] = new javax.swing.JButton("+");

     jPanel1.add(orbtn[n],gbc);

     validate(); repaint();


   }

   public void createor(int n,int i){
       field[n][i]=new javax.swing.JTextField(3);
       gbc.gridx = i+2;   gbc.gridy = n;
       jPanel1.add(field[n][i],gbc);

       gbc.gridx = i+3;   gbc.gridy = n;
       jPanel1.add(orbtn[n],gbc);
       validate(); repaint();
   }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addline;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JTextField[][] field;
    public javax.swing.JButton[] orbtn;
    public javax.swing.JButton transform;
    public GridBagConstraints gbc;
    // End of variables declaration//GEN-END:variables
}
