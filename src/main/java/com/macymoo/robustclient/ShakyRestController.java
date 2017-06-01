package com.macymoo.robustclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Karl on 31/05/2017.
 */
@RestController
public class ShakyRestController {

    private final ShakyBusinessService shakyBusinessService;

    @Autowired
    public ShakyRestController(ShakyBusinessService shakyBusinessService) {
        this.shakyBusinessService = shakyBusinessService;
    }


    @GetMapping("/boom")
    public int boom() throws InterruptedException {
        return shakyBusinessService.boom();
    }

    @GetMapping("/retry")
    public int retry() throws InterruptedException {
        return shakyBusinessService.retry();
    }

}
