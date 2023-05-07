package com.camunda.engine.gateway.eventbased;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 基于事件
 * @author cuidi
 * @date 2023/4/24 10:53
 */
@Slf4j
@RestController
public class SendSingalController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/sendSingal")
    public boolean snedSingal(){
        runtimeService.createSignalEvent("Signal_direct_leader").send();
        return true;
    }
}
