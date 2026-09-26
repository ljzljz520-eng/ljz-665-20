package org.jeecg.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.device.entity.DeviceArchive;

/**
 * @Description: 设备档案 Service
 * @Author: jeecg-boot
 * @Date: 2026-09-26
 * @Version: V1.0
 */
public interface IDeviceArchiveService extends IService<DeviceArchive> {

    /**
     * 根据设备编号查询设备档案
     *
     * @param deviceCode 设备编号
     * @return 设备档案
     */
    DeviceArchive getByDeviceCode(String deviceCode);
}
