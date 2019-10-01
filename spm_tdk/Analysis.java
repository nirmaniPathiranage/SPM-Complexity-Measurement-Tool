   
  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm_tdk;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mycode.DBConnect;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author TharakaDK
 */
public class Analysis extends javax.swing.JFrame {
    
    Connection conn=null;
    PreparedStatement pst =null;
    ResultSet rs=null;
    

     private Dimension dimension = null;
    public static String filePath = null;
    private static String copyText = null;

    public static ArrayList<ProgramStatement> resultSet = null;
    /**
     * Creates new form Analysis
     */
    public Analysis(String FilePath, String copyText) {
        initComponents();
        
        conn=DBConnect.connect();
        tableload();
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height / 2);
        
        if(FilePath == null && copyText != null){
            this.copyText = copyText;
            readFromText();
        }
        else if(FilePath != null && copyText == null){
            this.filePath = FilePath;
            readFromFile();
        }
        
  

        displayFile();
        
    }
    
    
    public void tableload(){
    try{
    String sql="select id AS Code_ID,cnc AS Cnc_Value from wordc";
    pst=conn.prepareStatement(sql);
    rs= pst.executeQuery();
    
    jTable2.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
        
    }}
    
    
    
    
    
    
    final public void readFromText(){
        System.out.println("Reading from text");
    }

    final public void readFromFile() {

        resultSet = new ArrayList<ProgramStatement>();

        try {

            final File file1 = new File(filePath);
            final FileReader fileReader = new FileReader(file1);
            final BufferedReader bufferReader = new BufferedReader(fileReader); //Creation of BufferedReader object
            String line;
            int count = 1;   //Intialize the word to zero

            while ((line = bufferReader.readLine()) != null) //Reading Content from the file
            {
                ProgramStatement ps = new ProgramStatement();
                ps.setLineNumber(count);
                ps.setLineContent(line);

                resultSet.add(ps);

                count++;

            }

            fileReader.close();

        } catch (IOException ex) {
            Logger.getLogger(Analysis.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    final public void displayFile() {
        
        update();
        
//        for (ProgramStatement ps : resultSet) {
//
//            currentCodeTextArea.append(String.valueOf(ps.getLineNumber()));
//            currentCodeTextArea.append("\t\t\t");
//            currentCodeTextArea.append(ps.getLineContent());
//            currentCodeTextArea.append("\t\t\t");
//            currentCodeTextArea.append(String.valueOf(ps.getCncValue()));
//            currentCodeTextArea.append("\n");
//
//    
//
//        }

for (ProgramStatement ps : resultSet) {
           Object[] row = {ps.getLineNumber(),ps.getLineContent(),ps.getCncValue(),ps.getCrValue()};

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                model.addRow(row);
        }

    }

    public void calculateCnCValues() {

        //Const init 
        Cnc_cal cncCalculation = new Cnc_cal();
        

        ArrayList<Integer> Cnc_units = cncCalculation.coreBracketMapper();

        for (int i = 0; i < Cnc_units.size(); i++) {
            System.out.println("\t" + (i + 1) + " Line has " + Cnc_units.get(i) + " Cnc");
        }

        System.out.println("Total CNC --->  " + cncCalculation.getTotalCncPoints());
        result.setText(""+cncCalculation.getTotalCncPoints());
        
        Count_cd count=new Count_cd();
        
        ifcount.setText(""+count.calcIf());
        forcount.setText(""+count.calcFor());
        whilecount.setText(""+count.calcWhile());
    }
    
    public void calculateCrValue(){
        cr_calculation cr = new cr_calculation();
        cr.calculateCr();
        
    }
    public void calculateCIValue() {
         try {
             ci_calc.calc_ci();
         } catch (IOException ex) {
             Logger.getLogger(Analysis.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    
    public void update(){
        calculateCnCValues();
        calculateCrValue();
        calculateCIValue();

    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        forcount = new javax.swing.JTextField();
        result = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ifcount = new javax.swing.JTextField();
        whilecount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        id = new javax.swing.JTextField();
        cnc = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 0), 1, true));
        jTable1.setForeground(new java.awt.Color(0, 255, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Line No", "Code", "Cnc", "Cr"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Complexity due to Cnc");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        forcount.setBackground(new java.awt.Color(51, 51, 51));
        forcount.setForeground(new java.awt.Color(0, 255, 0));
        forcount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forcountActionPerformed(evt);
            }
        });

        result.setBackground(new java.awt.Color(51, 51, 51));
        result.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        result.setForeground(new java.awt.Color(0, 255, 0));
        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 0));
        jLabel2.setText("For count");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 0));
        jLabel4.setText("Total Cnc");

        ifcount.setBackground(new java.awt.Color(51, 51, 51));
        ifcount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ifcount.setForeground(new java.awt.Color(51, 255, 0));
        ifcount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ifcountActionPerformed(evt);
            }
        });

        whilecount.setBackground(new java.awt.Color(51, 51, 51));
        whilecount.setForeground(new java.awt.Color(51, 255, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("If count");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 0));
        jLabel3.setText("While Count");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(0, 255, 0));
        jButton1.setText("Add DB");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(105, 105, 105)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ifcount, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(whilecount, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27)
                                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jButton1))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(93, 93, 93)
                        .addComponent(forcount, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ifcount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(whilecount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forcount, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTable2.setBackground(new java.awt.Color(0, 0, 0));
        jTable2.setForeground(new java.awt.Color(0, 255, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        id.setBackground(new java.awt.Color(0, 0, 0));
        id.setForeground(new java.awt.Color(0, 255, 0));

        cnc.setBackground(new java.awt.Color(0, 0, 0));
        cnc.setForeground(new java.awt.Color(0, 255, 0));
        cnc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cncActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 0));
        jLabel6.setText("ID");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 0));
        jLabel7.setText("Cnc");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("History");

        jButton3.setBackground(new java.awt.Color(0, 51, 255));
        jButton3.setText("Print Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(jLabel6)
                                .addGap(47, 47, 47)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel7)
                                .addGap(35, 35, 35)
                                .addComponent(cnc, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(375, 375, 375)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(57, 57, 57)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(cnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jButton2))))
                        .addGap(70, 70, 70)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ifcountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ifcountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ifcountActionPerformed

    private void forcountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forcountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forcountActionPerformed

    private void resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       try{
            String sql="Insert into wordc(cnc) values (?)";
            pst=conn.prepareStatement(sql);
            //pst.setBytes(1, person_image);
            pst.setString(1,result.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"data Saved");
            
            }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }tableload();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int row=jTable2.getSelectedRow();
        
        String Table_click=(jTable2.getModel().getValueAt(row, 0).toString());
        try{
        String sql="select * from wordc where id='"+Table_click+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        if(rs.next()){
        String add1=rs.getString("id");
        id.setText(add1);
        String add2=rs.getString("cnc");
        cnc.setText(add2);
        }
        }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void cncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cncActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(null, "want to delete");
        if(x==0){
        String id= cnc.getText();
        
        String sql="DELETE from wordc where cnc='"+id+"'";
        try{
        pst=conn.prepareStatement(sql);
        pst.execute();
        
        tableload();
        }catch(Exception e){
        
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         try{
        MessageFormat header = new MessageFormat("Cnc Report");
        MessageFormat footer = new MessageFormat("==========");
        
        
        jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cnc;
    private javax.swing.JTextField forcount;
    private javax.swing.JTextField id;
    private javax.swing.JTextField ifcount;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField result;
    private javax.swing.JTextField whilecount;
    // End of variables declaration//GEN-END:variables
}
