package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UserDevice;

/**
 * 用户设备Mapper接口
 * 
 * @author ruoyi
 * @date 2025-07-19
 */
public interface UserDeviceMapper 
{
    /**
     * 查询用户设备
     * 
     * @param userId 用户设备主键
     * @return 用户设备
     */
    public UserDevice selectUserDeviceByUserId(Long userId);

    /**
     * 查询用户设备列表
     * 
     * @param userDevice 用户设备
     * @return 用户设备集合
     */
    public List<UserDevice> selectUserDeviceList(UserDevice userDevice);

    /**
     * 新增用户设备
     * 
     * @param userDevice 用户设备
     * @return 结果
     */
    public int insertUserDevice(UserDevice userDevice);

    /**
     * 修改用户设备
     * 
     * @param userDevice 用户设备
     * @return 结果
     */
    public int updateUserDevice(UserDevice userDevice);

    /**
     * 删除用户设备
     * 
     * @param userId 用户设备主键
     * @return 结果
     */
    public int deleteUserDeviceByUserId(Long userId);

    /**
     * 批量删除用户设备
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserDeviceByUserIds(Long[] userIds);
}
