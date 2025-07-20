package com.ruoyi.erweima.devicebianhao.service.impl;

import com.ruoyi.erweima.devicebianhao.service.IDeviceQrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@MessageEndpoint
public class MqttMessageHandler {

    @Autowired
    private IDeviceQrService deviceQrService;

    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void handleMessage(Message<?> message) {
        String payload = (String) message.getPayload();
        String topic = message.getHeaders().get("mqtt_receivedTopic").toString();

        if (topic.equals("device/factory")) {
            String deviceNo = payload.trim();
            deviceQrService.generateAndSaveQrCode(deviceNo);
        }
    }
}