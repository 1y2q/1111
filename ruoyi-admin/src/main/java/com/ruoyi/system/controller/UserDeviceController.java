package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.UserDevice;
import com.ruoyi.system.service.IUserDeviceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户设备Controller
 * 
 * @author ruoyi
 * @date 2025-07-19
 */
@RestController
@RequestMapping("/system/device")
public class UserDeviceController extends BaseController
{
    @Autowired
    private IUserDeviceService userDeviceService;

    /**
     * 查询用户设备列表
     */
    @PreAuthorize("@ss.hasPermi('system:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserDevice userDevice)
    {
        startPage();
        List<UserDevice> list = userDeviceService.selectUserDeviceList(userDevice);
        return getDataTable(list);
    }

    /**
     * 导出用户设备列表
     */
    @PreAuthorize("@ss.hasPermi('system:device:export')")
    @Log(title = "用户设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserDevice userDevice)
    {
        List<UserDevice> list = userDeviceService.selectUserDeviceList(userDevice);
        ExcelUtil<UserDevice> util = new ExcelUtil<UserDevice>(UserDevice.class);
        util.exportExcel(response, list, "用户设备数据");
    }

    /**
     * 获取用户设备详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:device:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(userDeviceService.selectUserDeviceByUserId(userId));
    }

    /**
     * 新增用户设备
     */
    @PreAuthorize("@ss.hasPermi('system:device:add')")
    @Log(title = "用户设备", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserDevice userDevice)
    {
        return toAjax(userDeviceService.insertUserDevice(userDevice));
    }

    /**
     * 修改用户设备
     */
    @PreAuthorize("@ss.hasPermi('system:device:edit')")
    @Log(title = "用户设备", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserDevice userDevice)
    {
        return toAjax(userDeviceService.updateUserDevice(userDevice));
    }

    /**
     * 删除用户设备
     */
    @PreAuthorize("@ss.hasPermi('system:device:remove')")
    @Log(title = "用户设备", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(userDeviceService.deleteUserDeviceByUserIds(userIds));
    }
}
