package com.macymoo.robustclient.model;

/**
 * Created by Karl on 01/06/2017.
 */
public class RetryException extends RuntimeException {
    public RetryException(String message){
        super(message);
    }
}
