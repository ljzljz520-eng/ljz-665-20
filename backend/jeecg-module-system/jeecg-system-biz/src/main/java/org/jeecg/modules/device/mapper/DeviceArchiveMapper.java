package org.jeecg.modules.device.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.device.entity.DeviceArchive;

/**
 * @Description: 设备档案 Mapper
 * @Author: jeecg-boot
 * @Date: 2026-09-26
 * @Version: V1.0
 */
public interface DeviceArchiveMapper extends BaseMapper<DeviceArchive> {

    /**
     * 根据设备编号查询设备档案
     *
     * @param deviceCode 设备编号
     * @return 设备档案
     */
    DeviceArchive getByDeviceCode(@Param("deviceCode") String deviceCode);
}
