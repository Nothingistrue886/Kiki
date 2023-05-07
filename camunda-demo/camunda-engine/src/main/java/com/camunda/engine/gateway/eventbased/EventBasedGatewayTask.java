package com.camunda.engine.gateway.eventbased;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/18 11:10
 */

@Slf4j
@RestController
public class EventBasedGatewayTask {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/startEventBasedGatewayTask/{processKey}")
    public void start(@PathVariable("processKey") String processKey){
        runtimeService.startProcessInstanceByKey(processKey);
    }
}
