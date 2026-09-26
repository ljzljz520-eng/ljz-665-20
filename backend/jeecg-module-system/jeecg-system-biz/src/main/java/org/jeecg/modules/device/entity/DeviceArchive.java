package org.jeecg.modules.device.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecg.common.system.base.entity.JeecgEntity;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description: 设备档案
 * @Author: jeecg-boot
 * @Date: 2026-09-26
 * @Version: V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Schema(description = "设备档案")
@TableName("device_archive")
public class DeviceArchive extends JeecgEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 设备编号（唯一标识，如 SB-2026-0001） */
    @Excel(name = "设备编号", width = 20)
    @Schema(description = "设备编号")
    private java.lang.String deviceCode;

    /** 设备名称 */
    @Excel(name = "设备名称", width = 20)
    @Schema(description = "设备名称")
    private java.lang.String deviceName;

    /** 规格型号 */
    @Excel(name = "规格型号", width = 20)
    @Schema(description = "规格型号")
    private java.lang.String deviceModel;

    /** 设备类别（如：生产设备/检测设备/办公设备） */
    @Excel(name = "设备类别", width = 15)
    @Schema(description = "设备类别")
    private java.lang.String deviceCategory;

    /** 生产厂商 */
    @Excel(name = "生产厂商", width = 20)
    @Schema(description = "生产厂商")
    private java.lang.String manufacturer;

    /** 购置日期 */
    @Excel(name = "购置日期", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "购置日期")
    private java.util.Date purchaseDate;

    /** 安装位置（车间/产线/区域） */
    @Excel(name = "安装位置", width = 20)
    @Schema(description = "安装位置")
    private java.lang.String installLocation;

    /** 设备状态（字典 device_status：1在用 2维修 3停用 4报废） */
    @Excel(name = "设备状态", width = 15, dicCode = "device_status")
    @Dict(dicCode = "device_status")
    @Schema(description = "设备状态（1在用 2维修 3停用 4报废）")
    private java.lang.String deviceStatus;

    /** 负责人 */
    @Excel(name = "负责人", width = 15)
    @Schema(description = "负责人")
    private java.lang.String responsiblePerson;

    /** 备注 */
    @Excel(name = "备注", width = 30)
    @Schema(description = "备注")
    private java.lang.String remark;

    /** 所属部门编码 */
    @Excel(name = "所属部门", width = 20)
    @Schema(description = "所属部门编码")
    private java.lang.String sysOrgCode;
}
