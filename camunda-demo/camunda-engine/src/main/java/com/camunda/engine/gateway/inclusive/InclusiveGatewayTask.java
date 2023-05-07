package com.camunda.engine.gateway.inclusive;

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
 * @date 2023/4/21 9:33
 */
@Slf4j
@RestController
public class InclusiveGatewayTask {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/startInclusiveGatewayTask/{processKey}")
    public void start(@PathVariable("processKey") String processKey){
        identityService.setAuthenticatedUserId("cuidi");
        runtimeService.startProcessInstanceByKey(processKey);
    }
}