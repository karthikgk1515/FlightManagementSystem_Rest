package com.fms.exception;

public class FlightNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public FlightNotFoundException(String msg){
        super(msg);
    }

    public FlightNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}
