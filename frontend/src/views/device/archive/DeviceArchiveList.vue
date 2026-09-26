<template>
  <div>
    <!--引用表格-->
    <BasicTable @register="registerTable" :rowSelection="rowSelection">
      <!--插槽:table标题-->
      <template #tableTitle>
        <a-button preIcon="ant-design:plus-outlined" type="primary" @click="handleAdd">新增</a-button>
        <a-upload name="file" :showUploadList="false" :customRequest="(file) => handleImportXls(file, getImportUrl, reload)">
          <a-button preIcon="ant-design:import-outlined" type="primary">导入</a-button>
        </a-upload>
        <a-button preIcon="ant-design:export-outlined" type="primary" @click="handleExportXls('设备档案', getExportUrl, exportParams)">导出</a-button>
        <a-dropdown v-if="checkedKeys.length > 0">
          <template #overlay>
            <a-menu>
              <a-menu-item key="1" @click="batchHandleDelete">
                <Icon icon="ant-design:delete-outlined"></Icon>
                删除
              </a-menu-item>
            </a-menu>
          </template>
          <a-button>
            批量操作
            <Icon icon="ant-design:down-outlined"></Icon>
          </a-button>
        </a-dropdown>
      </template>
      <!--操作栏-->
      <template #action="{ record }">
        <TableAction :actions="getTableAction(record)" />
      </template>
    </BasicTable>
    <!--设备档案表单弹窗-->
    <DeviceArchiveModal @register="registerModal" @success="reload" />
  </div>
</template>

<script lang="ts" setup>
  import { ref, computed } from 'vue';
  import { BasicTable, useTable, TableAction } from '/@/components/Table';
  import { useModal } from '/@/components/Modal';
  import { useMethods } from '/@/hooks/system/useMethods';
  import { filterObj } from '/@/utils/common/compUtils';
  import DeviceArchiveModal from './DeviceArchiveModal.vue';
  import {
    getDeviceArchiveList,
    deleteDeviceArchive,
    batchDeleteDeviceArchive,
    getExportUrl,
    getImportUrl,
  } from './deviceArchive.api';
  import { columns, searchFormSchema } from './deviceArchive.data';

  const checkedKeys = ref<Array<string | number>>([]);
  const [registerModal, { openModal }] = useModal();
  const { handleExportXls, handleImportXls } = useMethods();

  const [registerTable, { reload }] = useTable({
    title: '设备档案',
    api: getDeviceArchiveList,
    columns,
    formConfig: {
      schemas: searchFormSchema,
      autoAdvancedCol: 4,
    },
    striped: true,
    useSearchForm: true,
    showTableSetting: true,
    clickToRowSelect: false,
    bordered: true,
    showIndexColumn: false,
    tableSetting: { fullScreen: true },
    canResize: false,
    rowKey: 'id',
    actionColumn: {
      width: 150,
      title: '操作',
      dataIndex: 'action',
      slots: { customRender: 'action' },
      fixed: undefined,
    },
  });

  /**
   * 选择列配置
   */
  const rowSelection = {
    type: 'checkbox',
    columnWidth: 40,
    selectedRowKeys: checkedKeys,
    onChange: onSelectChange,
  };

  /**
   * 导出参数（携带勾选记录）
   */
  const exportParams = computed(() => {
    const paramsForm = {};
    if (checkedKeys.value && checkedKeys.value.length > 0) {
      paramsForm['selections'] = checkedKeys.value.join(',');
    }
    return filterObj(paramsForm);
  });

  /**
   * 操作列定义
   */
  function getTableAction(record) {
    return [
      {
        label: '编辑',
        onClick: handleEdit.bind(null, record),
      },
      {
        label: '删除',
        popConfirm: {
          title: '是否确认删除',
          confirm: handleDelete.bind(null, record),
        },
      },
    ];
  }

  /**
   * 选择事件
   */
  function onSelectChange(selectedRowKeys: (string | number)[]) {
    checkedKeys.value = selectedRowKeys;
  }

  /**
   * 新增事件
   */
  function handleAdd() {
    openModal(true, {
      isUpdate: false,
    });
  }

  /**
   * 编辑事件
   */
  function handleEdit(record) {
    openModal(true, {
      record,
      isUpdate: true,
    });
  }

  /**
   * 删除事件
   */
  async function handleDelete(record) {
    await deleteDeviceArchive({ id: record.id }, reload);
  }

  /**
   * 批量删除事件
   */
  async function batchHandleDelete() {
    await batchDeleteDeviceArchive({ ids: checkedKeys.value }, reload);
  }
</script>
