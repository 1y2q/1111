package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户设备对象 user_device
 * 
 * @author ruoyi
 * @date 2025-07-19
 */
public class UserDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID（自增主键） */
    private Long userId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 可控制设备（单一） */
    @Excel(name = "可控制设备", readConverterExp = "单=一")
    private String controllableDevice;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setControllableDevice(String controllableDevice) 
    {
        this.controllableDevice = controllableDevice;
    }

    public String getControllableDevice() 
    {
        return controllableDevice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("username", getUsername())
            .append("phone", getPhone())
            .append("controllableDevice", getControllableDevice())
            .toString();
    }
}
