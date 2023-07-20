package com.czff.mydemo.hutool;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * @author cuidi
 * @description 基于hutool实现JSONObject首字母驼峰大小写转换方法
 * @date 2022/11/24 13:45
 */
public class JSONObjectTest {

    public static void main(String[] args) {
        String str = "{\"Header\":{\"Source\":\"PMS\",\"Type\":\"ORDER_CREATE\",\"RequestNo\":\"30146022\",\"OrderType\":\"ZOR\",\"SalesDistrict\":\"130\",\"SalesOrg\":\"0101\",\"DisChannel\":\"21\",\"Division\":\"00\",\"OrderReason\":\"\",\"CustomerPo\":\"100152720001\",\"BillingDate\":\"20221122\",\"PaymentTerms\":\"0301\",\"LenovoCompleteDelivery\":null,\"Currency\":\"RMB\",\"OriginalSystem\":\"PMS\",\"Name\":\"MSC20221117001\",\"ExternalOrderNo\":\"30146022\",\"FinancialDoc\":null,\"DepreciationPercentage\":null},\"Items\":[{\"ItemNumber\":\"000010\",\"ExternalItemId\":\"40045857\",\"Material\":\"MSINF06\",\"Plant\":\"0161\",\"OrderId\":\"SW9118170101\",\"ReferenceDocumentNumber\":null,\"ReferenceItemNumber\":\"\"}],\"ExtensionFields\":{\"Header\":{\"LenovoCompleteDelivery\":\"\",\"BG\":\"SSG\",\"SegmentLevel1\":\"\",\"SegmentLevel2\":\"\",\"SegmentLevel3\":\"\",\"Hebingkaipiao\":\"30146018\",\"SumQty\":\"1\",\"InvoiceType\":\"Z\",\"IsElectronicInvoice\":\"Z\",\"ReceiveInvoiceEmail\":null,\"InvoiceBusinessOwer\":null,\"InvoiceHeaderRemark\":\"\",\"ContractName\":\"20221117SAP系统切换\",\"BillBeginDate\":null,\"BillEndDate\":null,\"ConBeginDate\":\"20221201\",\"ConEndDate\":\"20241130\",\"ContractItem\":\"\",\"CreditNO\":null,\"CreditDec\":null,\"MergeCount\":\"1.00\",\"SendDate\":\"20221122\",\"SendTime\":\"153513\",\"UnbillItemuniqueID\":\"\",\"UnbilledARCode\":\"\",\"UnbilledAmount\":\"\",\"BalanceAmount\":\"\",\"BillingFrequency\":\"\"},\"Items\":[{\"ItemNumber\":\"000010\",\"ServiceGroup\":\"61\",\"ProductStrategy\":\"\",\"ItemInvoiceText\":\"运维费\",\"ConItemNo\":\"0003\",\"Unit\":\"其他\",\"Standard\":\"其他\",\"ChargeStartDate\":\"\",\"ChargeEndDate\":\"\",\"SLA\":\"\",\"Backdateflag\":\"\"}]},\"Partners\":[{\"ItemNumber\":\"0000\",\"PartnerFunction\":\"AG\",\"CustomerNumber\":\"0111270218\"},{\"ItemNumber\":\"0000\",\"PartnerFunction\":\"RE\",\"CustomerNumber\":\"0111270218\"}],\"SchedulesIns\":[{\"ItemNumber\":\"000010\",\"ReqQty\":\"1.00\"}],\"Conditions\":[{\"ItemNumber\":\"000010\",\"ConditionType\":\"ZPR1\",\"ConditionValue\":\"38380.00\",\"Currency\":\"RMB\"}]}";
        cn.hutool.json.JSONObject entries = JSONUtil.parseObj(str);
        JSONObject entries1 = formatKey(entries, false);
        System.out.println(JSONUtil.toJsonStr(entries1));
    }

    /**
     * 转换为驼峰格式/转换为下划线方式
     *
     * @param json  等待转换的方法
     * @param upper 首字母大写或者小写
     * @return 转换后的
     */
    public static JSONObject formatKey(final JSONObject json, boolean upper) {
        JSONObject real = new JSONObject();
        for (String it : json.keySet()) {
            Object objR = json.get(it);
            // 转换为驼峰格式/转换为下划线方式
//            String key = it.contains("_") ? StrUtil.toCamelCase(it) : StrUtil.toUnderlineCase(it);
            // 首字母大写或者小写
            String key = upper ? StrUtil.upperFirst(it) : StrUtil.lowerFirst(it);
            if (objR instanceof String) {
                real.set(key, objR);
            }
            if (objR instanceof JSONObject) {
                real.set(key, formatKey((JSONObject) objR, upper));
            }
            if (objR instanceof JSONArray) {
                JSONArray jsonA = new JSONArray();
                for (Object objA : (JSONArray) objR) {
                    jsonA.add(formatKey((JSONObject) objA, upper));
                }
                real.set(key, jsonA);
            }
        }
        return real;
    }
}
