package com.czff.mydemo.hutool.beancopy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class LogDTO {

    private List<Map> inputTerm = new ArrayList<>();

    private String sqlTerm = "";

    private List<Map> filterTerm = new ArrayList<>();

    private String logType = "";//日志类型

    private List<String> fields = new ArrayList<>();//字段

    private List<String> logIds = new ArrayList<>();//日志ID集合

    private String orderType = "desc";//排序方式

    private String taskId = "";//任务ID

    private Integer fileType;//1、excel 2、json

    private String alarmId = "";//告警id

    private String userId = "";//用户id
}
