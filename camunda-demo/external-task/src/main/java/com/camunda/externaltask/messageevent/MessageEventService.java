package com.camunda.externaltask.messageevent;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.ExternalTaskClientBuilder;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.client.topic.TopicSubscriptionBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author cuidi
 * @description
 * @date 2023/4/25 18:24
 */
@Slf4j
@Component
public class MessageEventService {

    @Bean
    @ExternalTaskSubscription(topicName = "success_pay_topic", lockDuration = 10000, processDefinitionKeyIn = {"Process_message_event"})
    public ExternalTaskHandler successPay(){
        return (externalTask, externalTaskService) -> {
            log.info("支付成功");
            externalTaskService.complete(externalTask);
        };
    }

    @Bean
    @ExternalTaskSubscription(topicName = "elm_topic", lockDuration = 10000, processDefinitionKeyIn = {"Process_message_event"})
    public ExternalTaskHandler elmPay() {
        return (externalTask, externalTaskService) -> {
            log.info("饿了么支付");
            externalTaskService.complete(externalTask);
        };
    }

    @Bean
    @ExternalTaskSubscription(topicName = "mt_topic", lockDuration = 10000, processDefinitionKeyIn = {"Process_message_event"})
    public ExternalTaskHandler mtPay() {
        return (externalTask, externalTaskService) -> {
            log.info("美团支付成功");
            externalTaskService.complete(externalTask);
        };
    }
}
