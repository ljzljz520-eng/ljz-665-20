import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { render } from '/@/utils/common/renderUtils';

/**
 * 设备档案-列表列定义
 */
export const columns: BasicColumn[] = [
  {
    title: '设备编号',
    dataIndex: 'deviceCode',
    width: 140,
  },
  {
    title: '设备名称',
    dataIndex: 'deviceName',
    width: 160,
  },
  {
    title: '规格型号',
    dataIndex: 'deviceModel',
    width: 120,
  },
  {
    title: '设备类别',
    dataIndex: 'deviceCategory',
    width: 100,
  },
  {
    title: '生产厂商',
    dataIndex: 'manufacturer',
    width: 140,
  },
  {
    title: '购置日期',
    dataIndex: 'purchaseDate',
    width: 110,
  },
  {
    title: '安装位置',
    dataIndex: 'installLocation',
    width: 140,
  },
  {
    title: '设备状态',
    dataIndex: 'deviceStatus',
    width: 90,
    // 设备状态字典翻译：1在用 2维修 3停用 4报废
    customRender: ({ text }) => {
      return render.renderDict(text, 'device_status');
    },
  },
  {
    title: '负责人',
    dataIndex: 'responsiblePerson',
    width: 90,
  },
  {
    title: '备注',
    dataIndex: 'remark',
    width: 120,
  },
];

/**
 * 设备档案-查询表单
 */
export const searchFormSchema: FormSchema[] = [
  {
    label: '设备编号',
    field: 'deviceCode',
    component: 'Input',
    colProps: { span: 6 },
  },
  {
    label: '设备名称',
    field: 'deviceName',
    component: 'Input',
    colProps: { span: 6 },
  },
  {
    label: '设备状态',
    field: 'deviceStatus',
    component: 'JDictSelectTag',
    componentProps: {
      // 设备状态字典：1在用 2维修 3停用 4报废
      dictCode: 'device_status',
      placeholder: '请选择设备状态',
    },
    colProps: { span: 6 },
  },
];

/**
 * 设备档案-新增/编辑表单
 */
export const formSchema: FormSchema[] = [
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
  {
    label: '设备编号',
    field: 'deviceCode',
    component: 'Input',
    required: true,
    componentProps: {
      placeholder: '请输入设备编号，如 SB-2026-0001',
    },
  },
  {
    label: '设备名称',
    field: 'deviceName',
    component: 'Input',
    required: true,
  },
  {
    label: '规格型号',
    field: 'deviceModel',
    component: 'Input',
  },
  {
    label: '设备类别',
    field: 'deviceCategory',
    component: 'Input',
    componentProps: {
      placeholder: '如：生产设备/检测设备/办公设备',
    },
  },
  {
    label: '生产厂商',
    field: 'manufacturer',
    component: 'Input',
  },
  {
    label: '购置日期',
    field: 'purchaseDate',
    component: 'DatePicker',
    componentProps: {
      valueFormat: 'YYYY-MM-DD',
      placeholder: '请选择购置日期',
    },
  },
  {
    label: '安装位置',
    field: 'installLocation',
    component: 'Input',
  },
  {
    label: '设备状态',
    field: 'deviceStatus',
    component: 'JDictSelectTag',
    required: true,
    defaultValue: '1',
    componentProps: {
      // 设备状态字典：1在用 2维修 3停用 4报废
      dictCode: 'device_status',
      placeholder: '请选择设备状态',
    },
  },
  {
    label: '负责人',
    field: 'responsiblePerson',
    component: 'Input',
  },
  {
    label: '备注',
    field: 'remark',
    component: 'InputTextArea',
    componentProps: {
      rows: 3,
    },
  },
];
