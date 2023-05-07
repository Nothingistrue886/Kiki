package com.camunda.externaltask.checknegtive;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/21 9:38
 */
@Configuration
@Slf4j
public class CheckNegtiveService {
    @Bean
    @ExternalTaskSubscription(topicName = "check_negtive",processDefinitionKeyIn = {"Process_parallel_gateway"},lockDuration = 10000)
    public ExternalTaskHandler checkNegtive() {
        return (externalTask, externalTaskService) -> {
            log.info("Start 外部任务-视频是否有社会负面影响");
            String videoName = externalTask.getVariable("videoName");
            log.info("视频"+videoName+"没有社会负面影响");
            externalTaskService.complete(externalTask);
        };
    }
}
