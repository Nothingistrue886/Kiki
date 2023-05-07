package com.camunda.engine.gateway.parallel;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/21 9:34
 */
@Slf4j
@Component("checkVideoFormat")
public class CheckVideoFormat implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) {
        log.info("校验视频格式");
        String videoName = (String) execution.getVariable("videoName");
        log.info("视频名称：" + videoName);
    }
}
