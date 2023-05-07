package com.camunda.externaltask.selfrepair;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/18 13:58
 */
@Configuration
@Slf4j
public class SelfRepairService {

    @Bean
    @ExternalTaskSubscription(topicName = "try_self_repair",processDefinitionKeyIn = {"Process_external_task"},lockDuration = 10000)
    public ExternalTaskHandler doSelfRepair() {
        return (externalTask, externalTaskService) -> {
            log.info("Start 外部任务-尝试自修流程");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean isFree = externalTask.getVariable("isFree");
            if (isFree) {
                log.info("免费维修");
//                externalTaskService.handleFailure(externalTask,"免费维修，不需要自修", "打印异常stacktrace", 1, 1000);
                externalTaskService.handleFailure(externalTask,"免费维修，不需要自修", "打印异常stacktrace", 0, 1000);
            } else {
                log.info("付费维修");
                externalTaskService.complete(externalTask);
            }
        };
    }
}
