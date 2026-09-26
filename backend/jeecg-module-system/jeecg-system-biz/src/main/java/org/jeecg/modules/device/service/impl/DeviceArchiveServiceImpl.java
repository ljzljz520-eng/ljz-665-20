package org.jeecg.modules.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.device.entity.DeviceArchive;
import org.jeecg.modules.device.mapper.DeviceArchiveMapper;
import org.jeecg.modules.device.service.IDeviceArchiveService;
import org.springframework.stereotype.Service;

/**
 * @Description: 设备档案 Service 实现
 * @Author: jeecg-boot
 * @Date: 2026-09-26
 * @Version: V1.0
 */
@Service
public class DeviceArchiveServiceImpl extends ServiceImpl<DeviceArchiveMapper, DeviceArchive> implements IDeviceArchiveService {

    @Override
    public DeviceArchive getByDeviceCode(String deviceCode) {
        return baseMapper.getByDeviceCode(deviceCode);
    }
}
