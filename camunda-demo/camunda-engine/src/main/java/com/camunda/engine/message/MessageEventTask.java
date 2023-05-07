package com.camunda.engine.message;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 请假
 * @author cuidi
 * @date 2023/4/18 9:38
 */
@Slf4j
@RestController
public class MessageEventTask {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/startMessageEventTask/{processKey}")
    public void start(@PathVariable("processKey") String processKey){
        runtimeService.startProcessInstanceByKey(processKey);
    }
}
