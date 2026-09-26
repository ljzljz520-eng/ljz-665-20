package org.jeecg.modules.device.enums;

/**
 * @Description: 设备状态枚举（与字典 device_status 保持一致）
 * @Author: jeecg-boot
 * @Date: 2026-09-26
 * @Version: V1.0
 */
public enum DeviceStatusEnum {

    /** 在用：设备正常运行中 */
    IN_USE("1", "在用"),

    /** 维修：设备故障检修中，暂停使用 */
    REPAIRING("2", "维修"),

    /** 停用：设备暂时闲置，未报废 */
    STOPPED("3", "停用"),

    /** 报废：设备已报废，不可再使用 */
    SCRAPPED("4", "报废");

    /** 状态值（对应字典 item_value） */
    private final String code;

    /** 状态名称（对应字典 item_text） */
    private final String text;

    DeviceStatusEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    /**
     * 根据状态值获取状态名称
     *
     * @param code 状态值（1/2/3/4）
     * @return 状态名称，未匹配时返回空串
     */
    public static String getTextByCode(String code) {
        for (DeviceStatusEnum item : values()) {
            if (item.code.equals(code)) {
                return item.text;
            }
        }
        return "";
    }
}
