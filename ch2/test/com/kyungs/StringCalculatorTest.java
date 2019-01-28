package com.kyungs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    private StringCalculator cal;

    @Before
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    public void add_Test() {
        assertEquals(9, cal.add("6:3"));
        
    }
    
    @Test(expected=InvalidValueException.class)
    public void add_음수입력Test() {
    	assertEquals(-1, cal.add("-1"));
    	assertEquals(-6, cal.add("-6:-3"));
    }
    
//    @Test
//    public void add_잘못된구분자입력_Test() {
//    	assertEquals(9, cal.add("6;3"));
//    }
    
    @Test
    public void add_null또는빈문자(){
    	assertEquals(0, cal.add(""));
    	assertEquals(0, cal.add(null));
    }
    
    @Test
    public void add_숫자하나입력(){
    	assertEquals(1, cal.add("1"));
    	assertEquals(123, cal.add("123"));
    }
    
    @Test
    public void add_쉼표구분자(){
    	assertEquals(3, cal.add("1,2"));
    }
    
    @Test
    public void add_custom구분자() {
    	assertEquals(9, cal.add("//;\n6;3"));
    }
}
