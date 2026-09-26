package org.jeecg.modules.device.enums;

/**
 * @Description: 设备状态枚举（设备档案）
 * @Author: jeecg-boot
 * @Date: 2026-09-26
 * @Version: V1.0
 */
public enum DeviceStatusEnum {

    /** 在用：设备正常投入使用 */
    IN_USE("1", "在用"),
    /** 维修：设备故障送修，暂停使用 */
    REPAIR("2", "维修"),
    /** 停用：设备暂时闲置，可重新启用 */
    IDLE("3", "停用"),
    /** 报废：设备已报废，不可再使用 */
    SCRAPPED("4", "报废");

    /** 状态值（对应字典 device_status 的 itemValue） */
    private final String code;
    /** 状态名称 */
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
     * @param code 状态值
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
