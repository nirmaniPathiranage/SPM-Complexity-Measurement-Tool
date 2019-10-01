/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm_tdk;

/**
 *
 * @author pasindu
 */
public class ProgramStatement {
    
    private int lineNumber;
    private String lineContent;
    private int cncValue; 
    private int crValue;
    private int ciValue;
   

    public int getLineNumber() {
        return lineNumber;
    }

    public String getLineContent() {
        return lineContent;
    }

//    public int getCsValue() {
//        return csValue;
//    }
//
//    public int getCtcValue() {
//        return ctcValue;
//    }

    public int getCncValue() {
        return cncValue;
    }
    
    public int getCrValue() {
        return crValue;
    }
    public int getCiValue() {
        return ciValue;
    }



    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setLineContent(String lineContent) {
        this.lineContent = lineContent;
    }

    public void setCncValue(int cncValue) {
        this.cncValue = cncValue;
    }
    public void setCrValue(int crValue) {
        this.crValue = crValue;
    }
    public void setCiValue(int ciValue) {
        this.ciValue = ciValue;
    }

    
    
    
    
}
