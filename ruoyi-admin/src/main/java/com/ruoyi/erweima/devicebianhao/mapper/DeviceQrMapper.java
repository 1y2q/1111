package com.ruoyi.erweima.devicebianhao.mapper;
// DeviceQrMapper.java


import com.ruoyi.erweima.devicebianhao.entity.DeviceQr;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceQrMapper {
    int insert(DeviceQr deviceQr);
    DeviceQr selectByDeviceNo(String deviceNo);
}