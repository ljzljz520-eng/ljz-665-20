package org.jeecg.modules.device.entity;

import java.io.Serializable;

import org.jeecg.common.system.base.entity.JeecgEntity;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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

    /** 设备编号（唯一，业务主键） */
    @Excel(name = "设备编号", width = 20)
    @Schema(description = "设备编号")
    private java.lang.String deviceCode;
    /** 设备名称 */
    @Excel(name = "设备名称", width = 25)
    @Schema(description = "设备名称")
    private java.lang.String deviceName;
    /** 设备类型（字典 device_type：1生产设备 2检测设备 3运输设备 4办公设备） */
    @Excel(name = "设备类型", width = 15, dicCode = "device_type")
    @Schema(description = "设备类型")
    private java.lang.String deviceType;
    /** 规格型号 */
    @Excel(name = "规格型号", width = 20)
    @Schema(description = "规格型号")
    private java.lang.String deviceModel;
    /** 生产厂商 */
    @Excel(name = "生产厂商", width = 25)
    @Schema(description = "生产厂商")
    private java.lang.String manufacturer;
    /** 出厂编号 */
    @Excel(name = "出厂编号", width = 20)
    @Schema(description = "出厂编号")
    private java.lang.String serialNumber;
    /** 购置日期 */
    @Excel(name = "购置日期", width = 15, format = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "购置日期")
    private java.util.Date purchaseDate;
    /** 安装位置 */
    @Excel(name = "安装位置", width = 25)
    @Schema(description = "安装位置")
    private java.lang.String installLocation;
    /** 使用部门 */
    @Excel(name = "使用部门", width = 20)
    @Schema(description = "使用部门")
    private java.lang.String useDept;
    /** 责任人 */
    @Excel(name = "责任人", width = 15)
    @Schema(description = "责任人")
    private java.lang.String keeper;
    /** 设备状态（字典 device_status：1在用 2维修 3停用 4报废，见 DeviceStatusEnum） */
    @Excel(name = "设备状态", width = 12, dicCode = "device_status")
    @Schema(description = "设备状态")
    private java.lang.String deviceStatus;
    /** 备注 */
    @Schema(description = "备注")
    private java.lang.String remark;
    /** 所属部门编码（数据权限用） */
    @Schema(description = "所属部门编码")
    private java.lang.String sysOrgCode;
}
