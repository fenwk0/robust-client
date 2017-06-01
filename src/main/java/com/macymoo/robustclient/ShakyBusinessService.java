package com.macymoo.robustclient;

import com.macymoo.robustclient.model.BoomException;
import com.macymoo.robustclient.model.Calculation;
import com.macymoo.robustclient.model.RetryException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * Created by Karl on 31/05/2017.
 */

@Service
class ShakyBusinessService {

    Calculation boomCalc = new Calculation(0.5f,3);
    Calculation retryCalc = new Calculation(0.5f,3);



    public int boomFallback(){
        System.out.println("ShakyBusinessService.boomFallback");
        return 2;
    }

    @HystrixCommand(fallbackMethod = "boomFallback")
    public int boom()  {
        int retVal = 0;
        try {
            retVal = boomCalc.deriveNumber();
        } catch (Exception e) {
            throw new BoomException("bang!");
        }
        return retVal;

    }



    @Recover
    public int recoveryRetry(RetryException ex){
        System.out.println("ShakyBusinessService.recoveryRetry");
        return 4;
    }

    @Retryable(include = RetryException.class)
    public int retry() throws RetryException {
        System.out.println("Calling derive number");
        int retVal = 0;
        try {

            retVal = retryCalc.deriveNumber();
        } catch (Exception e) {
            throw new RetryException("Retrying!");
        }
        return retVal;

    }


}
