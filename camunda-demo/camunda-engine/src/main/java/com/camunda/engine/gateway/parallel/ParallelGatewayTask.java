package com.camunda.engine.gateway.parallel;

import lombok.extern.slf4j.Slf4j;
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
public class ParallelGatewayTask {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/startParallelGateway/{processKey}")
    public void start(@PathVariable("processKey") String processKey){
        runtimeService.startProcessInstanceByKey(processKey);
    }
}