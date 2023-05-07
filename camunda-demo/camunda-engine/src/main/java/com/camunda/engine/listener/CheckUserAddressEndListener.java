package com.camunda.engine.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/18 19:09
 */
@Slf4j
@Component("checkUserAddress")
public class CheckUserAddressEndListener implements ExecutionListener {

    private static final String ADDREN_ADDRESS_ENDPOINT = "北京中关村";

    @Override
    public void notify(DelegateExecution exception) throws Exception {
        log.info("开始检查用户地址");
        String userAddress = (String) exception.getVariable("userAddress");
        if (userAddress == null) {
            log.info("用户地址未填写，使用默认地址");
            exception.setVariable("userAddress", ADDREN_ADDRESS_ENDPOINT);
        }
    }
}
