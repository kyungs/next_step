package com.kyungs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	// 구분자로 분리 후 각 숫자의 합을 구한다. 
    // + 구분자가 없는 경우 : "1", "123"
	// + 잘못된 입력 에러 처리
    public int add(String text) {
        if(isBlank(text)) return 0; 
        
        // 더하기 연산 
        return sum(toInts(split(text)));
    }  
    
    private boolean isBlank(String text) {
    	// 입력값이 없는 경우 : "", null
    	if(text == null || text.isEmpty() || text == " ") return true;
    	return false;
    }
    
    private String[] split(String text){
    	Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    	// 커스텀 구분자가 있으면, 
    	if(m.find()) {
        	String customDelimeter = m.group(1);
        	String[] tokens = m.group(2).split(customDelimeter);
        	return tokens;
        }
        // 없으면 기본 구분자(, & :)
    	return text.split(",|:");
    }

    private int sum(int[] tokens){
    	int sum = 0;
    	for(int i : tokens) {
        	sum += i;
    	}
    	return sum;
    }
    
    private int[] toInts(String[] tokens){
    	int[] numbers = new int[tokens.length];
    	for(int i=0; i < tokens.length; i++){
    		numbers[i] = isPositive(tokens[i]);
    	}
    	return numbers;
    }
    
    private int isPositive(String text){
    	int value = Integer.parseInt(text);
    	if (value < 0) throw new InvalidValueException("음수는 입력할 수 없습니다.");
    	return value;
    }
}

