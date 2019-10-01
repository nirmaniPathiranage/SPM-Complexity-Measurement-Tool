/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTestPackage1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spm.CountConditions;

/**
 *
 * @author Nano_Sc
 */
public class JUnitCountConditions {

    public JUnitCountConditions() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("AfterClass");
    }

    @Before
    public void setUp() {
        System.out.println("Before");
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCountConditions() {

        System.out.println("JUnit Testing for Calculating Complexity");

        System.out.println("JUnit Testing for Count Conditions");

        CountConditions countConditions = new CountConditions("codeFinal", "split", 0);

        int actual = countConditions.getCount();
        int expected = 0;

        //test for count conditions with using assertions
        assertEquals(expected, actual);
    }

    @Test
    public void testCountConditions1() {

        System.out.println("JUnit Testing for Calculating Complexity");

        System.out.println("JUnit Testing for Count Conditions");

        CountConditions countConditions = new CountConditions("codeFinal", "split", 0);

        int actual = countConditions.getCountForCatch();
        int expected = 0;

        //test for count conditions with using assertions
        assertEquals(expected, actual);
    }

}
