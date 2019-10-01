/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm_tdk;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import static spm_tdk.Analysis.resultSet;

/**
 *
 * @author TharakaDK
 */
public class Count_cd {
    
    ArrayList<Integer> cncPoints;
    
    Integer ifCount = 0;
    Integer forCount = 0;
    Integer whileCount = 0;
    
    
    
    public Count_cd() {//ArrayList<ProgramStatement> lineOfCodeList
//        this.lineOfCodeList = lineOfCodeList;
        cncPoints = new ArrayList<Integer>(Analysis.resultSet.size());
    }
    
    public int calcIf(){
    
        int count=0;
        
        for (ProgramStatement ps : Analysis.resultSet) {
   
       
        String word =ps.getLineContent();
        
         if(word.contains("if")){
             count++;
         }
         
        }

    return count;  
        
    }
    
    public int calcFor(){
               
        int count=0;
        
        for (ProgramStatement ps : Analysis.resultSet) {
   
       
        String word =ps.getLineContent();
        
         if(word.contains("for")){
             count++;
         }
         
        }

    return count;      
    }
    public int calcWhile(){
        
        int count=0;
        
        for (ProgramStatement ps : Analysis.resultSet) {
   
       
        String word =ps.getLineContent();
        
         if(word.contains("while")){
             count++;
         }
         
        }

    return count;  
    
    }
    
    public static int checkIf(String words){
        
        int count=0;
        if (words == null || words.isEmpty()) {
            return 0;
        }

        String[] word = words.split("\\s+");
             int a= word.length;
             return a;
        }
    
       
    
        
    
    
    
    
    
}
