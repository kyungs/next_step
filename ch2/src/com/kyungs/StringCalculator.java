package com.kyungs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	// 구분자로 분리 후 각 숫자의 합을 구한다. 
    // + 입력값이 없는 경우 : " ", null
    // + 구분자가 없는 경우 : "1", "123"
    public int add(String text) {
        int sum = 0;
        if(text == null || text == " ") return sum;
        
        
        // 커스텀 구분자가 있으면, 
        String[] tokens = customDelimeter(text);
        // 없으면 기본 구분자(, & :)
        if(tokens == null) tokens = text.split(",|:");
        
        System.out.printf("tokens length : %s\n", tokens.length);
        
        // 더하기 연산 
        for(String s : tokens){
//            sum += Integer.parseInt(s);
        	int value = Integer.parseInt(s);
            // 음수 에러 처리 
        	if(value < 0) throw new InvalidValueException("음수는 입력할 수 없습니다.");
        	sum += value;
        }
        return sum;
    }  
    
    private String[] customDelimeter(String text){
    	Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    	if(m.find()) {
        	String customDelimeter = m.group(1);
        	String[] tokens = m.group(2).split(customDelimeter);
        	return tokens;
        }
    	return null;
    }
    
    // 잘못된 입력 에러 처리 
}