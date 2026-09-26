package org.jeecg.modules.device.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.device.entity.DeviceArchive;
import org.jeecg.modules.device.service.IDeviceArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * @Description: 设备档案
 * @Author: jeecg-boot
 * @Date: 2026-09-26
 * @Version: V1.0
 */
@Slf4j
@Tag(name = "设备档案")
@RestController
@RequestMapping("/device/archive")
public class DeviceArchiveController extends JeecgController<DeviceArchive, IDeviceArchiveService> {

    @Autowired
    private IDeviceArchiveService deviceArchiveService;

    /**
     * 分页列表查询
     *
     * @param deviceArchive 查询条件
     * @param pageNo        页码
     * @param pageSize      每页条数
     * @param req           请求
     * @return 设备档案分页数据
     */
    @Operation(summary = "设备档案-分页列表查询")
    @GetMapping(value = "/list")
    public Result<?> list(DeviceArchive deviceArchive,
                          @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                          @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                          HttpServletRequest req) {
        QueryWrapper<DeviceArchive> queryWrapper = QueryGenerator.initQueryWrapper(deviceArchive, req.getParameterMap());
        queryWrapper.orderByDesc("create_time");
        Page<DeviceArchive> page = new Page<>(pageNo, pageSize);
        IPage<DeviceArchive> pageList = deviceArchiveService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 新增设备档案
     *
     * @param deviceArchive 设备档案
     * @return 操作结果
     */
    @AutoLog(value = "设备档案-新增")
    @Operation(summary = "设备档案-新增")
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody DeviceArchive deviceArchive) {
        deviceArchiveService.save(deviceArchive);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑设备档案
     *
     * @param deviceArchive 设备档案
     * @return 操作结果
     */
    @AutoLog(value = "设备档案-编辑", operateType = CommonConstant.OPERATE_TYPE_3)
    @Operation(summary = "设备档案-编辑")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<?> edit(@RequestBody DeviceArchive deviceArchive) {
        deviceArchiveService.updateById(deviceArchive);
        return Result.OK("更新成功！");
    }

    /**
     * 通过id删除设备档案
     *
     * @param id 主键
     * @return 操作结果
     */
    @AutoLog(value = "设备档案-删除", operateType = CommonConstant.OPERATE_TYPE_4)
    @Operation(summary = "设备档案-删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id") String id) {
        deviceArchiveService.removeById(id);
        return Result.OK("删除成功！");
    }

    /**
     * 批量删除设备档案
     *
     * @param ids 主键集合，逗号分隔
     * @return 操作结果
     */
    @AutoLog(value = "设备档案-批量删除", operateType = CommonConstant.OPERATE_TYPE_4)
    @Operation(summary = "设备档案-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<?> deleteBatch(@RequestParam(name = "ids") String ids) {
        deviceArchiveService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功！");
    }

    /**
     * 通过id查询设备档案
     *
     * @param id 主键
     * @return 设备档案
     */
    @Operation(summary = "设备档案-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<?> queryById(@Parameter(name = "id", description = "设备档案id", required = true)
                               @RequestParam(name = "id") String id) {
        return Result.OK(deviceArchiveService.getById(id));
    }

    /**
     * 导出设备档案excel
     *
     * @param request       请求
     * @param deviceArchive 查询条件
     * @return 导出文件视图
     */
    @Operation(summary = "设备档案-导出excel")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, DeviceArchive deviceArchive) {
        return super.exportXls(request, deviceArchive, DeviceArchive.class, "设备档案");
    }

    /**
     * 通过excel导入设备档案
     *
     * @param request  请求
     * @param response 响应
     * @return 操作结果
     */
    @Operation(summary = "设备档案-导入excel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, DeviceArchive.class);
    }
}
