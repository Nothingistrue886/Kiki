package com.camunda.engine.execution;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.DeploymentBuilder;
import org.camunda.bpm.engine.runtime.ActivityInstance;
import org.camunda.bpm.engine.runtime.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/27 14:54
 */
@Slf4j
@RestController
public class ActivityExecution {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @GetMapping("/execution/{processInstanceId}")
    public List<Execution> getAllExecution(@PathVariable("processInstanceId") String processInstanceId) {

        List<Execution> executionList = runtimeService.createExecutionQuery().processInstanceId(processInstanceId).list();

        ActivityInstance activityInstance = runtimeService.getActivityInstance(processInstanceId);

        return executionList;
    }
}
