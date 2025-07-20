package com.ruoyi.erweima.devicebianhao.entity;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DeviceQr extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String deviceNo; // 设备号
    private String qrCodeUrl; // 二维码URL
}