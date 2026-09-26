import { defHttp } from '/@/utils/http/axios';
import { Modal } from 'ant-design-vue';

/**
 * 设备档案接口路径
 */
enum Api {
  list = '/device/archive/list',
  save = '/device/archive/add',
  edit = '/device/archive/edit',
  get = '/device/archive/queryById',
  delete = '/device/archive/delete',
  deleteBatch = '/device/archive/deleteBatch',
  exportXls = '/device/archive/exportXls',
  importExcel = '/device/archive/importExcel',
}

/**
 * 导出地址
 */
export const getExportUrl = Api.exportXls;
/**
 * 导入地址
 */
export const getImportUrl = Api.importExcel;

/**
 * 查询设备档案列表
 * @param params 查询参数
 */
export const getDeviceArchiveList = (params) => {
  return defHttp.get({ url: Api.list, params });
};

/**
 * 保存或者更新设备档案
 * @param params 设备档案数据
 * @param isUpdate 是否更新
 */
export const saveOrUpdateDeviceArchive = (params, isUpdate) => {
  const url = isUpdate ? Api.edit : Api.save;
  return defHttp.post({ url: url, params });
};

/**
 * 查询设备档案详情
 * @param params 主键
 */
export const getDeviceArchiveById = (params) => {
  return defHttp.get({ url: Api.get, params });
};

/**
 * 删除设备档案
 * @param params 主键
 * @param handleSuccess 成功回调
 */
export const deleteDeviceArchive = (params, handleSuccess) => {
  return defHttp.delete({ url: Api.delete, data: params }, { joinParamsToUrl: true }).then(() => {
    handleSuccess();
  });
};

/**
 * 批量删除设备档案
 * @param params 主键集合
 * @param handleSuccess 成功回调
 */
export const batchDeleteDeviceArchive = (params, handleSuccess) => {
  Modal.confirm({
    title: '确认删除',
    content: '是否删除选中数据',
    okText: '确认',
    cancelText: '取消',
    onOk: () => {
      return defHttp.delete({ url: Api.deleteBatch, data: params }, { joinParamsToUrl: true }).then(() => {
        handleSuccess();
      });
    },
  });
};
