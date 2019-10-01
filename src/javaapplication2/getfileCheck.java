/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;


public class getfileCheck extends javax.swing.JFrame {

    /**
     * Creates new form getfileCheck
     */
    public getfileCheck() {
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

        calWeight = new javax.swing.JButton();
        fileName = new javax.swing.JTextField();
        selectFile = new javax.swing.JButton();
        showWeight = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inheritanceWeight = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));

        calWeight.setBackground(new java.awt.Color(0, 0, 204));
        calWeight.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        calWeight.setForeground(new java.awt.Color(255, 255, 255));
        calWeight.setText("Calculate Weight");
        calWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calWeightActionPerformed(evt);
            }
        });

        fileName.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        selectFile.setBackground(new java.awt.Color(0, 0, 204));
        selectFile.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        selectFile.setForeground(new java.awt.Color(255, 255, 255));
        selectFile.setText("Select File");
        selectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileActionPerformed(evt);
            }
        });

        showWeight.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setText("Due to Nested :");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("Due to Inheritance :");

        inheritanceWeight.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectFile, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(calWeight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showWeight)
                            .addComponent(inheritanceWeight))))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectFile)
                    .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(calWeight)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inheritanceWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int calweight_inheritance(int linecount, File file){
        int count=0;
        int inheritCount =0;
        String key = "@override";
        String key1 = "}";
        String key2 = "//";
        
        try(Scanner input = new Scanner(file)){
         
            
            while(input.hasNextLine()){
                String line = input.nextLine();
                count++;
           
                while(linecount==count){
                    
                    try{
                       line = input.nextLine();
                     
                       String[] words = line.split(" ");
                       
                       if(key.equals(words[0])){
                           
                           line = input.nextLine();
                           String[] words2 = line.split(" ");
                           
                           while(!key1.equals(words2[0])){
                             
                              if(!key2.equals(words2[0])){
                                inheritCount++;
                                line = input.nextLine();
                                words2 = line.split(" ");
                              }
                           }
                           
                           break;
                       }
                    
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
           
        }
        catch(Exception e){}
       
        return inheritCount;
    }
    public int secondRound(int linecount ,File file){
        int count=0;
        int wordcount =0;
        String key = "}";
        String key1 = "if";
        String key2 = "for";
        String key3 = "while";
        
        
        try(Scanner input = new Scanner(file)){
         
            
            while(input.hasNextLine()){
                String line = input.nextLine();
                count++;
           
                while(linecount==count){
                    
                    line = input.nextLine();
                   
                    try(Scanner text = new Scanner(line)){
                       String[] words = line.split(" ");
                       
                       while(!key.equals(words[1])){
                           if(key1.equals(words[2]) || key2.equals(words[2]) || key3.equals(words[2]))
                              wordcount = wordcount+2;
                           else
                              wordcount++;
                         
                           break;
                       }
                    
                    }
                }
            }
           
        }
        catch(Exception e){}
       
        return wordcount;
    }
    public void processData(File file){
        int wordCount = 0;
        int lineCount = 0;
        int weight=0;
        int count=0;
        int inherit=0;
       
        try(Scanner input = new Scanner(file)){
            while(input.hasNextLine()){
                String line = input.nextLine();
                
                lineCount++;
                
                try(Scanner text = new Scanner(line)){
                    while(text.hasNext()){
                        text.next();
                        wordCount++;
                    }
                    String[] test = line.split(" ");
                
                    for(int i=0;i<wordCount;i++){
                        String word = test[i];
                        
                        Pattern p1 = Pattern.compile("if");
                        Matcher m1 = p1.matcher(word);
                        boolean b1 = m1.matches();
                        
                        Pattern p2 = Pattern.compile("for");
                        Matcher m2 = p2.matcher(word);
                        boolean b2 = m2.matches();
                        
                        Pattern p3 = Pattern.compile("while");
                        Matcher m3 = p3.matcher(word);
                        boolean b3 = m3.matches();
                        
                        Pattern p4 = Pattern.compile("extends");
                        Matcher m4 = p4.matcher(word);
                        boolean b4 = m4.matches();
                        
                        Pattern p5 = Pattern.compile("implements");
                        Matcher m5 = p5.matcher(word);
                        boolean b5 = m5.matches();
                        
                        if(b1==true || b2==true || b3==true){
                            weight++;
                            count =secondRound(lineCount,file);
                            
                            weight = weight + count;
                
                        }
                        
                        if(b4==true || b5==true){
                            inherit++;
                            count = calweight_inheritance(lineCount,file);
                            
                            inherit = inherit + count;
                        }
                    }
                   
                    wordCount=0;
                }
            }
            
           String s = Integer.toString(weight);
           String s2 = Integer.toString(inherit);
           showWeight.setText(s);
           inheritanceWeight.setText(s2);
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    private void calWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calWeightActionPerformed
        File f = new File(fileName.getText());
        
        try{
             processData(f);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_calWeightActionPerformed

    private void selectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String file2 = file.getAbsolutePath();
        fileName.setText(file2);
    }//GEN-LAST:event_selectFileActionPerformed

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
            java.util.logging.Logger.getLogger(getfileCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(getfileCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(getfileCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(getfileCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new getfileCheck().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calWeight;
    private javax.swing.JTextField fileName;
    private javax.swing.JTextField inheritanceWeight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton selectFile;
    private javax.swing.JTextField showWeight;
    // End of variables declaration//GEN-END:variables
}
