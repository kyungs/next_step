package com.kyungs;

public class InvalidValueException extends RuntimeException{

	private static final long serialVersionUID = 1224625434628553322L;
	
	public InvalidValueException() {
		super();
	}
	
	public InvalidValueException(String string){
		super(string);
	}
}
