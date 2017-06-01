package com.macymoo.robustclient.model;

/**
 * Created by Karl on 01/06/2017.
 */
public class Calculation {

    private final float randomFlakyness;
    private final int flakyDelay;

    public Calculation(float randomFlakyness, int flakyDelay ){

        this.randomFlakyness = randomFlakyness;
        this.flakyDelay = flakyDelay;
    }

    public int deriveNumber() throws Exception {

        if (Math.random() > this.randomFlakyness) {
            Thread.sleep(this.flakyDelay  * 1000);
            throw new RuntimeException("Boom");
        }
        return 1;

    }
}
