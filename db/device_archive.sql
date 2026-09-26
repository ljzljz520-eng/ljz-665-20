-- ============================================================================
-- 设备档案模块增量脚本（建表 + 字典 + 菜单）
-- 说明：与主初始化脚本同为 MySQL 语法，由 db-init 容器自动转换为 SQL Server 执行。
--       菜单部分仅包含"设备档案"相关菜单，不含任何演示/示例菜单。
-- ============================================================================

-- ----------------------------
-- 1. 设备档案表
-- ----------------------------
CREATE TABLE `device_archive` (
  `id` varchar(36) NOT NULL COMMENT '主键ID',
  `device_code` varchar(64) DEFAULT NULL COMMENT '设备编号（唯一标识，如 SB-2026-0001）',
  `device_name` varchar(100) DEFAULT NULL COMMENT '设备名称',
  `device_model` varchar(100) DEFAULT NULL COMMENT '规格型号',
  `device_category` varchar(50) DEFAULT NULL COMMENT '设备类别（如：生产设备/检测设备/办公设备）',
  `manufacturer` varchar(100) DEFAULT NULL COMMENT '生产厂商',
  `purchase_date` datetime DEFAULT NULL COMMENT '购置日期',
  `install_location` varchar(200) DEFAULT NULL COMMENT '安装位置（车间/产线/区域）',
  `device_status` varchar(2) DEFAULT '1' COMMENT '设备状态（字典 device_status：1在用 2维修 3停用 4报废）',
  `responsible_person` varchar(50) DEFAULT NULL COMMENT '负责人',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `sys_org_code` varchar(64) DEFAULT NULL COMMENT '所属部门编码',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_device_archive_code` (`device_code`),
  KEY `idx_device_archive_status` (`device_status`)
) COMMENT='设备档案';

-- ----------------------------
-- 2. 设备状态字典（device_status：1在用 2维修 3停用 4报废）
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('9f2a1b3c4d5e6f708192a3b4c5d6e7f8', '设备状态', 'device_status', '设备档案-设备状态：1在用 2维修 3停用 4报废', 0, 'admin', '2026-09-26 10:00:00', NULL, NULL, 0, 0, NULL);
INSERT INTO `sys_dict_item` VALUES ('1a2b3c4d5e6f708192a3b4c5d6e7f801', '9f2a1b3c4d5e6f708192a3b4c5d6e7f8', '在用', '1', NULL, '设备正常运行中', 1, 1, 'admin', '2026-09-26 10:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('1a2b3c4d5e6f708192a3b4c5d6e7f802', '9f2a1b3c4d5e6f708192a3b4c5d6e7f8', '维修', '2', NULL, '设备故障检修中', 2, 1, 'admin', '2026-09-26 10:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('1a2b3c4d5e6f708192a3b4c5d6e7f803', '9f2a1b3c4d5e6f708192a3b4c5d6e7f8', '停用', '3', NULL, '设备暂时闲置', 3, 1, 'admin', '2026-09-26 10:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` VALUES ('1a2b3c4d5e6f708192a3b4c5d6e7f804', '9f2a1b3c4d5e6f708192a3b4c5d6e7f8', '报废', '4', NULL, '设备已报废', 4, 1, 'admin', '2026-09-26 10:00:00', NULL, NULL);

-- ----------------------------
-- 3. 设备档案菜单（仅本模块菜单，不含示例菜单）
-- ----------------------------
-- 一级目录：设备管理
INSERT INTO `sys_permission` VALUES ('8a1b2c3d4e5f60718293a4b5c6d7e801', NULL, '设备管理', '/device', 'layouts/default/index', 1, NULL, '/device/archive/DeviceArchiveList', 0, NULL, '1', 10.00, 1, 'ant-design:database-outlined', 0, 0, 0, 0, '设备档案管理', 'admin', '2026-09-26 10:00:00', NULL, NULL, 0, 0, '1', 0);
-- 菜单：设备档案
INSERT INTO `sys_permission` VALUES ('8a1b2c3d4e5f60718293a4b5c6d7e802', '8a1b2c3d4e5f60718293a4b5c6d7e801', '设备档案', '/device/archive/DeviceArchiveList', 'device/archive/DeviceArchiveList', 1, NULL, NULL, 1, NULL, '1', 1.00, 0, NULL, 1, 0, 0, 0, '设备档案列表页', 'admin', '2026-09-26 10:00:00', NULL, NULL, 0, 0, '1', 0);
-- 按钮权限：新增/编辑/删除/导入/导出
INSERT INTO `sys_permission` VALUES ('8a1b2c3d4e5f60718293a4b5c6d7e803', '8a1b2c3d4e5f60718293a4b5c6d7e802', '新增设备', '', '', 0, NULL, NULL, 2, 'device:archive:add', '1', 1.00, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-26 10:00:00', NULL, NULL, 0, 0, '1', 0);
INSERT INTO `sys_permission` VALUES ('8a1b2c3d4e5f60718293a4b5c6d7e804', '8a1b2c3d4e5f60718293a4b5c6d7e802', '编辑设备', '', '', 0, NULL, NULL, 2, 'device:archive:edit', '1', 2.00, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-26 10:00:00', NULL, NULL, 0, 0, '1', 0);
INSERT INTO `sys_permission` VALUES ('8a1b2c3d4e5f60718293a4b5c6d7e805', '8a1b2c3d4e5f60718293a4b5c6d7e802', '删除设备', '', '', 0, NULL, NULL, 2, 'device:archive:delete', '1', 3.00, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-26 10:00:00', NULL, NULL, 0, 0, '1', 0);
INSERT INTO `sys_permission` VALUES ('8a1b2c3d4e5f60718293a4b5c6d7e806', '8a1b2c3d4e5f60718293a4b5c6d7e802', '导入设备', '', '', 0, NULL, NULL, 2, 'device:archive:import', '1', 4.00, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-26 10:00:00', NULL, NULL, 0, 0, '1', 0);
INSERT INTO `sys_permission` VALUES ('8a1b2c3d4e5f60718293a4b5c6d7e807', '8a1b2c3d4e5f60718293a4b5c6d7e802', '导出设备', '', '', 0, NULL, NULL, 2, 'device:archive:export', '1', 5.00, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-26 10:00:00', NULL, NULL, 0, 0, '1', 0);

-- ----------------------------
-- 4. 为 admin 角色（f6817f48af4fb3af11b9e8bf182f618b）授权设备档案菜单
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('7b2c3d4e5f60718293a4b5c6d7e8a901', 'f6817f48af4fb3af11b9e8bf182f618b', '8a1b2c3d4e5f60718293a4b5c6d7e801', NULL, '2026-09-26 10:00:00', NULL);
INSERT INTO `sys_role_permission` VALUES ('7b2c3d4e5f60718293a4b5c6d7e8a902', 'f6817f48af4fb3af11b9e8bf182f618b', '8a1b2c3d4e5f60718293a4b5c6d7e802', NULL, '2026-09-26 10:00:00', NULL);
INSERT INTO `sys_role_permission` VALUES ('7b2c3d4e5f60718293a4b5c6d7e8a903', 'f6817f48af4fb3af11b9e8bf182f618b', '8a1b2c3d4e5f60718293a4b5c6d7e803', NULL, '2026-09-26 10:00:00', NULL);
INSERT INTO `sys_role_permission` VALUES ('7b2c3d4e5f60718293a4b5c6d7e8a904', 'f6817f48af4fb3af11b9e8bf182f618b', '8a1b2c3d4e5f60718293a4b5c6d7e804', NULL, '2026-09-26 10:00:00', NULL);
INSERT INTO `sys_role_permission` VALUES ('7b2c3d4e5f60718293a4b5c6d7e8a905', 'f6817f48af4fb3af11b9e8bf182f618b', '8a1b2c3d4e5f60718293a4b5c6d7e805', NULL, '2026-09-26 10:00:00', NULL);
INSERT INTO `sys_role_permission` VALUES ('7b2c3d4e5f60718293a4b5c6d7e8a906', 'f6817f48af4fb3af11b9e8bf182f618b', '8a1b2c3d4e5f60718293a4b5c6d7e806', NULL, '2026-09-26 10:00:00', NULL);
INSERT INTO `sys_role_permission` VALUES ('7b2c3d4e5f60718293a4b5c6d7e8a907', 'f6817f48af4fb3af11b9e8bf182f618b', '8a1b2c3d4e5f60718293a4b5c6d7e807', NULL, '2026-09-26 10:00:00', NULL);
