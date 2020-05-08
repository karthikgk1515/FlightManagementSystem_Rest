package com.fms.exception;

public class IdNotFoundException extends RuntimeException{
   
	private static final long serialVersionUID = 1L;

	public IdNotFoundException(String msg){
        super(msg);
    }

    public IdNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}
