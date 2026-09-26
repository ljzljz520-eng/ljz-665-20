import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { render } from '/@/utils/common/renderUtils';

/**
 * 设备档案列表列定义
 */
export const columns: BasicColumn[] = [
  {
    title: '设备编号',
    dataIndex: 'deviceCode',
    width: 140,
    align: 'left',
    resizable: true,
    sorter: {
      multiple: 1,
    },
  },
  {
    title: '设备名称',
    dataIndex: 'deviceName',
    width: 160,
    align: 'left',
    resizable: true,
  },
  {
    title: '设备类型',
    dataIndex: 'deviceType',
    width: 110,
    resizable: true,
    customRender: ({ record }) => {
      return render.renderDict(record.deviceType, 'device_type', true);
    },
  },
  {
    title: '规格型号',
    dataIndex: 'deviceModel',
    width: 130,
    resizable: true,
  },
  {
    title: '生产厂商',
    dataIndex: 'manufacturer',
    width: 150,
    resizable: true,
  },
  {
    title: '出厂编号',
    dataIndex: 'serialNumber',
    width: 130,
    resizable: true,
  },
  {
    title: '购置日期',
    dataIndex: 'purchaseDate',
    width: 110,
    resizable: true,
  },
  {
    title: '安装位置',
    dataIndex: 'installLocation',
    width: 140,
    resizable: true,
  },
  {
    title: '使用部门',
    dataIndex: 'useDept',
    width: 120,
    resizable: true,
  },
  {
    title: '责任人',
    dataIndex: 'keeper',
    width: 100,
    resizable: true,
  },
  {
    // 设备状态：1在用 2维修 3停用 4报废
    title: '设备状态',
    dataIndex: 'deviceStatus',
    width: 100,
    resizable: true,
    customRender: ({ record }) => {
      return render.renderDict(record.deviceStatus, 'device_status', true);
    },
  },
  {
    title: '备注',
    dataIndex: 'remark',
    width: 140,
    resizable: true,
  },
];

/**
 * 设备档案查询表单
 */
export const searchFormSchema: FormSchema[] = [
  {
    field: 'deviceCode',
    label: '设备编号',
    component: 'Input',
    componentProps: {
      trim: true,
      placeholder: '请输入设备编号',
    },
    colProps: { span: 6 },
  },
  {
    field: 'deviceName',
    label: '设备名称',
    component: 'Input',
    componentProps: {
      trim: true,
      placeholder: '请输入设备名称',
    },
    colProps: { span: 6 },
  },
  {
    field: 'deviceType',
    label: '设备类型',
    component: 'JDictSelectTag',
    componentProps: {
      dictCode: 'device_type',
      placeholder: '请选择设备类型',
    },
    colProps: { span: 6 },
  },
  {
    field: 'deviceStatus',
    label: '设备状态',
    component: 'JDictSelectTag',
    componentProps: {
      dictCode: 'device_status',
      placeholder: '请选择设备状态',
    },
    colProps: { span: 6 },
  },
];

/**
 * 设备档案编辑表单
 */
export const formSchema: FormSchema[] = [
  {
    field: 'id',
    label: 'id',
    component: 'Input',
    show: false,
  },
  {
    field: 'deviceCode',
    label: '设备编号',
    component: 'Input',
    required: true,
    componentProps: {
      placeholder: '请输入设备编号',
    },
  },
  {
    field: 'deviceName',
    label: '设备名称',
    component: 'Input',
    required: true,
    componentProps: {
      placeholder: '请输入设备名称',
    },
  },
  {
    field: 'deviceType',
    label: '设备类型',
    component: 'JDictSelectTag',
    required: true,
    componentProps: {
      dictCode: 'device_type',
      placeholder: '请选择设备类型',
    },
  },
  {
    field: 'deviceModel',
    label: '规格型号',
    component: 'Input',
    componentProps: {
      placeholder: '请输入规格型号',
    },
  },
  {
    field: 'manufacturer',
    label: '生产厂商',
    component: 'Input',
    componentProps: {
      placeholder: '请输入生产厂商',
    },
  },
  {
    field: 'serialNumber',
    label: '出厂编号',
    component: 'Input',
    componentProps: {
      placeholder: '请输入出厂编号',
    },
  },
  {
    field: 'purchaseDate',
    label: '购置日期',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD',
      placeholder: '请选择购置日期',
    },
  },
  {
    field: 'installLocation',
    label: '安装位置',
    component: 'Input',
    componentProps: {
      placeholder: '请输入安装位置',
    },
  },
  {
    field: 'useDept',
    label: '使用部门',
    component: 'Input',
    componentProps: {
      placeholder: '请输入使用部门',
    },
  },
  {
    field: 'keeper',
    label: '责任人',
    component: 'Input',
    componentProps: {
      placeholder: '请输入责任人',
    },
  },
  {
    // 设备状态：1在用 2维修 3停用 4报废，默认在用
    field: 'deviceStatus',
    label: '设备状态',
    component: 'JDictSelectTag',
    required: true,
    defaultValue: '1',
    componentProps: {
      dictCode: 'device_status',
      placeholder: '请选择设备状态',
    },
  },
  {
    field: 'remark',
    label: '备注',
    component: 'InputTextArea',
    componentProps: {
      placeholder: '请输入备注',
    },
  },
];
