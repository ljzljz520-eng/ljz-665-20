# 设备档案模块交付整理

## 后端（jeecg-system-biz / org.jeecg.modules.device）
- [x] entity/DeviceArchive.java（设备档案实体，字段中文注释）
- [x] enums/DeviceStatusEnum.java（设备状态枚举，中文注释）
- [x] mapper/DeviceArchiveMapper.java + xml
- [x] service/IDeviceArchiveService.java + impl
- [x] controller/DeviceArchiveController.java（/device/archive）

## 前端
- [x] views/device/archive/DeviceArchiveList.vue
- [x] views/device/archive/DeviceArchiveModal.vue
- [x] views/device/archive/deviceArchive.api.ts（/device/archive）
- [x] views/device/archive/deviceArchive.data.ts

## SQL（backend/db/device_archive.sql，走转换管道）
- [x] 建表 device_archive + 字典（设备状态/设备类型）
- [x] 菜单：设备管理 > 设备档案 + 按钮权限
- [x] 清理演示菜单（183 个：导航示例树+组件示例树+报表演示项 + 角色关联）
- [x] 转换器支持多行 DELETE；Dockerfile/entrypoint 接入

## 清理
- [x] 前端：routes/modules/demo、views/demo、api/demo、mock/demo、mock/sys/menu.ts、mainOut、locales demo、views/system/examples、error-log 内联测试请求
- [x] 后端：start pom 移除 jeecg-module-demo、父 pom modules、cloud pom、demo 模块目录、demo-cloud-start、演示测试、SysCommentController 注释权限标识

## 验证
- [x] SQL 转换本地跑通（增量+主 SQL 无回归）
- [x] Java 包路径一致性、引用类存在性、pom XML 校验
- [x] 前端引用路径存在性、TS 括号平衡
- [ ] 后端 mvn 编译 / 前端 vue-tsc（环境无 Java/依赖，无法执行）
