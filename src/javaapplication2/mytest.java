/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class mytest extends javax.swing.JFrame {

    private int count_star_and_keys;
    private String star;
    private String classs;
    private int count_variable;
    private String first;
    private String second;
    private int countstar;
    int total;
    public mytest() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/h.png"))); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jButton1, org.jdesktop.beansbinding.ObjectProperty.create(), jLabel6, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jLabel6);
        jLabel6.setBounds(520, 40, 30, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/delete.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(680, 40, 40, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(500, 30, 140, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Load Data in Table View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(20, 330, 770, 30);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(85, 28, 409, 40);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 80, 770, 190);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/window-back-button (3).png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(22, 28, 57, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(650, 30, 140, 40);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Remove Comments ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(20, 290, 370, 30);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Remove println Statements");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(400, 290, 390, 30);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Line#", "Code", "Ci"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Total Ci");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Print");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 370, 770, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.showOpenDialog(null);
        int aa = chooser.showOpenDialog(null);
        File[] files = chooser.getSelectedFiles();

        int filearr = files.length;
        System.out.println(filearr);

        String fileNames = files[0].getAbsolutePath();

        System.out.println("length of files[] is:" + files.length);

        jTextField1.setText(fileNames);

        for (File f : files) {
            FileReader reader = null;
            try {
                reader = new FileReader(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(mytest.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader br = new BufferedReader(reader);
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    jTextArea1.append(line + "\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(mytest.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(mytest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
           String text = jTextArea1.getText();

        if (text.isEmpty()) {

            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "You should import a Text File for the text area !");
        } else {

            String[] lines = text.split("\n");
            int lineCount = lines.length;
           

            for (int i = 0; i < lineCount; i++) {

                String words[] = lines[i].split("\\s");
               
                int countstar = 0;               
                int count_star_and_keys = 0;
                                                                                                
                for (int x = 0; x < words.length; x++) {
                    String star = "extends";
                    String classs = "class";
                   
                     
                    if (words[x].equals(star)) {
                        //System.out.println("found: extends");
                        countstar = countstar + 1;                     
                        second = words[++x]; 
//                        if(words[x].equals(first)){
//                        countstar = countstar + 1;
//                        }
                        System.out.println("extends "+second);
                        
                    }
                    
                    if (words[x].equals(classs)) {
                       // System.out.println(words[++x]);
                        countstar = countstar + 1;                         
                        first = words[++x];
//                        if(words[x].equals(second)){                            
//                                    countstar = countstar + 1;
//                             
//                        }
                        System.out.print("class "+first+" ");
                          
                    }
                   
                                                                            
                    count_star_and_keys = countstar ;
                                    
                }

                Object[] row = {i, lines[i], count_star_and_keys, 0};

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                model.addRow(row);
                

            }
           

        }
        
       
    }//GEN-LAST:event_jButton2ActionPerformed


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        FileChoose mv = new FileChoose();
        mv.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       String text = jTextArea1.getText();

        if (text.isEmpty()) {

            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "You should import a Text File for the text area !");
        } else {

            jTextArea1.setText(text.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", ""));
            System.out.println(text.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", ""));
    }//GEN-LAST:event_jButton5ActionPerformed
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        count_star_and_keys = 0;
        count_variable=0;

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Line #", "Code", "Inheritance"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        jTextArea1.setText("");
        jTextField1.setText("");
       

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         String text = jTextArea1.getText();
        jTextArea1.setText(text.replaceAll("(\"([^\"]|\"\")*\")", ""));

        System.out.println(text.replaceAll("(\"([^\"]|\"\")*\")", ""));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
//        int z = 0;
//        for (int y=0; y<=jTable1.getRowCount();y++){
//            if(){
//            }else{
//        z+=Integer.parseInt(jTable1.getValueAt(y, 2).toString());
//            }
//        }
        
//        jTextField2.setText(z+".00");
        
    String[] words= jTextArea1.getText().toLowerCase().trim().split(" "); //Consider words separated by space
    String StringToFind="extends".toLowerCase();
    String StringToFind2="class".toLowerCase();
    int count=0;
    for(String word : words)
    {
        if(word.contains(StringToFind)){
            count++;
           
        }else if(word.contains(StringToFind2)){
            count++;
        }
         
    }
    jTextField2.setText(" Total: "+ count);
    jTextField2.setForeground(Color.blue);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
       try{
        MessageFormat header = new MessageFormat("Code Complexity due to Ci - Report");
        MessageFormat footer = new MessageFormat("===================================");
        
        
        jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(mytest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mytest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mytest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mytest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mytest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
