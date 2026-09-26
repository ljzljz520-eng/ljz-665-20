import { defHttp } from '/@/utils/http/axios';
import { Modal } from 'ant-design-vue';

/**
 * 设备档案接口路径（与后端 DeviceArchiveController 对应）
 */
enum Api {
  list = '/device/archive/list',
  save = '/device/archive/add',
  edit = '/device/archive/edit',
  deleteOne = '/device/archive/delete',
  deleteBatch = '/device/archive/deleteBatch',
  importExcel = '/device/archive/importExcel',
  exportXls = '/device/archive/exportXls',
}

/**
 * 设备档案-分页列表
 */
export const list = (params) => defHttp.get({ url: Api.list, params });

/**
 * 设备档案-删除
 */
export const deleteOne = (params, handleSuccess) => {
  return defHttp.delete({ url: Api.deleteOne, params }, { joinParamsToUrl: true }).then(() => {
    handleSuccess();
  });
};

/**
 * 设备档案-批量删除
 */
export const batchDelete = (params, handleSuccess) => {
  Modal.confirm({
    title: '确认删除',
    content: '是否删除选中设备档案',
    okText: '确认',
    cancelText: '取消',
    onOk: () => {
      return defHttp.delete({ url: Api.deleteBatch, data: params }, { joinParamsToUrl: true }).then(() => {
        handleSuccess();
      });
    },
  });
};

/**
 * 设备档案-保存或更新
 */
export const saveOrUpdate = (params, isUpdate) => {
  const url = isUpdate ? Api.edit : Api.save;
  return defHttp.post({ url: url, params });
};

/**
 * 设备档案-导入地址
 */
export const getImportUrl = Api.importExcel;

/**
 * 设备档案-导出地址
 */
export const getExportUrl = Api.exportXls;
