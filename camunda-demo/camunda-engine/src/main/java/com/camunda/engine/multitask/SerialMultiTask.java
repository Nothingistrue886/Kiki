package com.camunda.engine.multitask;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/20 9:16
 */
@Slf4j
@RestController
public class SerialMultiTask {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdentityService identityService;

    @GetMapping("/startSerialMultiTask/{processKey}")
    public void start(@PathVariable("processKey") String processKey){
        identityService.setAuthenticatedUserId("cuidi");
        VariableMap variableMap = Variables.createVariables();
        List<String> list = Arrays.asList("wangbing", "zhangsan", "lisi");
        variableMap.put("leaderList", list);
        runtimeService.startProcessInstanceByKey(processKey, variableMap);
    }
}