package com.translator.Exception;

public class TransaltorException  extends RuntimeException{

    public TransaltorException(String message){
        super(message);
    }

    public TransaltorException(String message, Throwable cause) {
        super(message, cause);
    }
}
