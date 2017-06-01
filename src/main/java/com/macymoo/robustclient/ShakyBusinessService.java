package com.macymoo.robustclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * Created by Karl on 31/05/2017.
 */

@Service
class ShakyBusinessService {


    public int fallback(){
        return 2;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public int deriveNumber() throws InterruptedException {

        if (Math.random() > 0.5) {
            Thread.sleep(3 * 1000);
            throw new RuntimeException("Boom");
        }
        return 1;
    }
}
