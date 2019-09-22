/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mfitr
 */
public class mainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
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

        mainTabbedPane = new javax.swing.JTabbedPane();
        homePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        introTextPane = new javax.swing.JTextPane();
        partOnePanel = new javax.swing.JPanel();
        partOneTitleLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        nfaDefineTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        nfaTransitTable = new javax.swing.JTable();
        nfaConvertButton = new javax.swing.JButton();
        partTwoTabbedPanel = new javax.swing.JTabbedPane();
        phaseOnePanel = new javax.swing.JPanel();
        phaseTwoPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TIS2151 Assignment");
        setMaximumSize(new java.awt.Dimension(900, 720));
        setMinimumSize(new java.awt.Dimension(750, 500));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 720));

        mainTabbedPane.setName(""); // NOI18N

        homePanel.setPreferredSize(new java.awt.Dimension(900, 720));
        homePanel.setLayout(new java.awt.GridLayout(2, 3));

        introTextPane.setEditable(false);
        introTextPane.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        introTextPane.setText("TIS2151 Theory of Computation\n\nAssignment (20%)\n\nTrimester 1 2019/2020\n\nLecturer: Dr. Nbhan D Salih\n\nTutorial Group: TT03\n\nGroup Members: -\n\n1- Muhammad Fitri Bin Amalludin - 1161300958\n2- Lim Zi Jie - 1161100143\n3- Ang Chong Wei - 1161304060\n4- Tebihi, Hicham - 1141326937");
        introTextPane.setOpaque(false);
        jScrollPane1.setViewportView(introTextPane);

        homePanel.add(jScrollPane1);

        mainTabbedPane.addTab("Home Tab", homePanel);

        partOneTitleLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        partOneTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        partOneTitleLabel.setText("Part 1 - NFA and Conversion of NFA to Regular Grammar");

        nfaDefineTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nfaDefineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Alphabets", "Variables", "Start", "Final"
            }
        ));
        jScrollPane2.setViewportView(nfaDefineTable);

        nfaTransitTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nfaTransitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "Alphabet 1", "Alphabet 2", "Alphabet 3", "Epsilon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(nfaTransitTable);

        nfaConvertButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nfaConvertButton.setText("Convert to RG");

        javax.swing.GroupLayout partOnePanelLayout = new javax.swing.GroupLayout(partOnePanel);
        partOnePanel.setLayout(partOnePanelLayout);
        partOnePanelLayout.setHorizontalGroup(
            partOnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partOnePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(partOnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(partOneTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(partOnePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(partOnePanelLayout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(nfaConvertButton)
                .addContainerGap(386, Short.MAX_VALUE))
        );
        partOnePanelLayout.setVerticalGroup(
            partOnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partOnePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(partOneTitleLabel)
                .addGap(18, 18, 18)
                .addGroup(partOnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(nfaConvertButton)
                .addContainerGap(405, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Part 1 (NFA to RG)", partOnePanel);

        partTwoTabbedPanel.setName(""); // NOI18N

        javax.swing.GroupLayout phaseOnePanelLayout = new javax.swing.GroupLayout(phaseOnePanel);
        phaseOnePanel.setLayout(phaseOnePanelLayout);
        phaseOnePanelLayout.setHorizontalGroup(
            phaseOnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        phaseOnePanelLayout.setVerticalGroup(
            phaseOnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        partTwoTabbedPanel.addTab("Phase One (CFG to CNF)", phaseOnePanel);

        javax.swing.GroupLayout phaseTwoPanelLayout = new javax.swing.GroupLayout(phaseTwoPanel);
        phaseTwoPanel.setLayout(phaseTwoPanelLayout);
        phaseTwoPanelLayout.setHorizontalGroup(
            phaseTwoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        phaseTwoPanelLayout.setVerticalGroup(
            phaseTwoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        partTwoTabbedPanel.addTab("Phase Two (CNF to CYK)", phaseTwoPanel);

        mainTabbedPane.addTab("Part 2 (CFG to CNF to CYK)", partTwoTabbedPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel homePanel;
    private javax.swing.JTextPane introTextPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JButton nfaConvertButton;
    private javax.swing.JTable nfaDefineTable;
    private javax.swing.JTable nfaTransitTable;
    private javax.swing.JPanel partOnePanel;
    private javax.swing.JLabel partOneTitleLabel;
    private javax.swing.JTabbedPane partTwoTabbedPanel;
    private javax.swing.JPanel phaseOnePanel;
    private javax.swing.JPanel phaseTwoPanel;
    // End of variables declaration//GEN-END:variables
}
