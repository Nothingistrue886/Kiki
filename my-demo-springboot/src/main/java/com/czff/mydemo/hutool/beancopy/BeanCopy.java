package com.czff.mydemo.hutool.beancopy;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.BeanUtils;

public class BeanCopy {


    public static void main(String[] args) {



        YCLogDTO ycLogDTO = new YCLogDTO();
        ycLogDTO.setAlarmId("1111");
        ycLogDTO.setUserId("111111111111111");
        ycLogDTO.setSqlTerm("this is a JSONObjectTest code");

        LogDTO logDTO = new LogDTO();
        logDTO.setAlarmId("222");
        logDTO.setUserId("222");
//        BeanUtil.copyProperties(ycLogDTO, logDTO);
        BeanUtils.copyProperties(logDTO, ycLogDTO);
        System.out.println("ycLogDTO" + JSONUtil.toJsonStr(ycLogDTO));
        System.out.println("logDTO" + JSONUtil.toJsonStr(logDTO));

//        ycLogDTO{"orderType":"desc","sqlTerm":"this is a JSONObjectTest code","logIds":[],"inputTerm":[],"filterTerm":[],"userId":"111111111111111","alarmId":"1111","fields":[]}
//        logDTO{"logType":"","orderType":"desc","sqlTerm":"this is a JSONObjectTest code","logIds":[],"inputTerm":[],"filterTerm":[],"userId":"111111111111111","alarmId":"1111","fields":[],"taskId":""}
//
//        ycLogDTO{"orderType":"desc","sqlTerm":"this is a JSONObjectTest code","logIds":[],"inputTerm":[],"filterTerm":[],"userId":"111111111111111","alarmId":"1111","fields":[]}
//        logDTO{"logType":"","orderType":"desc","sqlTerm":"this is a JSONObjectTest code","logIds":[],"inputTerm":[],"filterTerm":[],"userId":"111111111111111","alarmId":"1111","fields":[],"taskId":""}

    }

}
