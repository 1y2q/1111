package com.ruoyi.erweima.devicebianhao.service.impl;

import com.ruoyi.erweima.commm.utils.HttpUtils;
import com.ruoyi.erweima.commm.utils.JsonUtils;
import com.ruoyi.erweima.devicebianhao.config.CaoliaoApiConfig;
import com.ruoyi.erweima.devicebianhao.entity.DeviceQr;
import com.ruoyi.erweima.devicebianhao.mapper.DeviceQrMapper;
import com.ruoyi.erweima.devicebianhao.service.IDeviceQrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeviceQrServiceImpl implements IDeviceQrService {

    @Autowired
    private DeviceQrMapper deviceQrMapper;

    @Autowired
    private CaoliaoApiConfig caoLiaoApiConfig;

    @Override
    public void generateAndSaveQrCode(String deviceNo) {
        String qrCodeUrl = generateQrCodeUrl(deviceNo);

        DeviceQr deviceQr = new DeviceQr();
        deviceQr.setDeviceNo(deviceNo);
        deviceQr.setQrCodeUrl(qrCodeUrl);

        deviceQrMapper.insert(deviceQr);
    }

    @Override
    public DeviceQr getDeviceQrByDeviceNo(String deviceNo) {
        return deviceQrMapper.selectByDeviceNo(deviceNo);
    }

    private String generateQrCodeUrl(String deviceNo) {
        String apiUrl = caoLiaoApiConfig.getUrl();
        String token = caoLiaoApiConfig.getToken();

        Map<String, Object> params = new HashMap<>();
        params.put("content", deviceNo);
        params.put("token", token);

        String response = HttpUtils.post(apiUrl, JsonUtils.toJson(params));
        Map<String, Object> resultMap = JsonUtils.toMap(response);

        if ("success".equals(resultMap.get("status"))) {
            return (String) resultMap.get("qr_code_url");
        } else {
            throw new RuntimeException("生成二维码失败: " + resultMap.get("message"));
        }
    }
}