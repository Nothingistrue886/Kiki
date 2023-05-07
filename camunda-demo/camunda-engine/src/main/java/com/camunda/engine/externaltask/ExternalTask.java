package com.camunda.engine.externaltask;

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
public class ExternalTask {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/startExternalTask/{processKey}")
    public void start(@PathVariable("processKey") String processKey){
        VariableMap variableMap = Variables.createVariables().putValue("isFree", true);
//        VariableMap variableMap = Variables.createVariables().putValue("isFree", false);
        runtimeService.startProcessInstanceByKey(processKey, variableMap);
    }
}
