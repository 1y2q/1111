package com.ruoyi.erweima.devicebianhao.service;

import com.ruoyi.erweima.devicebianhao.entity.DeviceQr;

public interface IDeviceQrService {
    void generateAndSaveQrCode(String deviceNo);
    DeviceQr getDeviceQrByDeviceNo(String deviceNo);
}