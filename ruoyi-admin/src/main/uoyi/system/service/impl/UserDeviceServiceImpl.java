package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserDeviceMapper;
import com.ruoyi.system.domain.UserDevice;
import com.ruoyi.system.service.IUserDeviceService;

/**
 * 用户设备Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-19
 */
@Service
public class UserDeviceServiceImpl implements IUserDeviceService 
{
    @Autowired
    private UserDeviceMapper userDeviceMapper;

    /**
     * 查询用户设备
     * 
     * @param userId 用户设备主键
     * @return 用户设备
     */
    @Override
    public UserDevice selectUserDeviceByUserId(Long userId)
    {
        return userDeviceMapper.selectUserDeviceByUserId(userId);
    }

    /**
     * 查询用户设备列表
     * 
     * @param userDevice 用户设备
     * @return 用户设备
     */
    @Override
    public List<UserDevice> selectUserDeviceList(UserDevice userDevice)
    {
        return userDeviceMapper.selectUserDeviceList(userDevice);
    }

    /**
     * 新增用户设备
     * 
     * @param userDevice 用户设备
     * @return 结果
     */
    @Override
    public int insertUserDevice(UserDevice userDevice)
    {
        return userDeviceMapper.insertUserDevice(userDevice);
    }

    /**
     * 修改用户设备
     * 
     * @param userDevice 用户设备
     * @return 结果
     */
    @Override
    public int updateUserDevice(UserDevice userDevice)
    {
        return userDeviceMapper.updateUserDevice(userDevice);
    }

    /**
     * 批量删除用户设备
     * 
     * @param userIds 需要删除的用户设备主键
     * @return 结果
     */
    @Override
    public int deleteUserDeviceByUserIds(Long[] userIds)
    {
        return userDeviceMapper.deleteUserDeviceByUserIds(userIds);
    }

    /**
     * 删除用户设备信息
     * 
     * @param userId 用户设备主键
     * @return 结果
     */
    @Override
    public int deleteUserDeviceByUserId(Long userId)
    {
        return userDeviceMapper.deleteUserDeviceByUserId(userId);
    }
}
