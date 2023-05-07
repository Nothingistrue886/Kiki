package com.camunda.engine.gateway.exclusive;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/20 19:00
 */

@Slf4j
@RestController
public class ExclusiveTask {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/startExclusiveTask/{processKey}")
    public void start(@PathVariable("processKey") String processKey){
        identityService.setAuthenticatedUserId("cuidi");
        runtimeService.startProcessInstanceByKey(processKey);
    }
}
