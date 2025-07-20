package com.ruoyi.erweima.commm.utils.constant;

public class DeviceConstants {

    // ========== MQTT 相关 ==========
    /** MQTT 主题：设备出厂消息 */
    public static final String MQTT_TOPIC_DEVICE_FACTORY = "device/factory";
    /** MQTT 客户端 ID 前缀 */
    public static final String MQTT_CLIENT_ID_PREFIX = "ruoyi-device-";

    // ========== 数据库相关 ==========
    /** 设备二维码表名 */
    public static final String TABLE_DEVICE_QR = "device_qr";
    /** 设备二维码表字段：设备号 */
    public static final String COLUMN_DEVICE_QR_DEVICE_NO = "device_no";
    /** 设备二维码表字段：二维码 URL */
    public static final String COLUMN_DEVICE_QR_QRCODE_URL = "qr_code_url";

    // ========== 草料 API 相关 ==========
    /** 草料 API 生成二维码接口 URL */
    public static final String CAOLIAO_API_URL = "https://api.cli.im/qrcode/url";
    /** 草料 API 请求头：Authorization */
    public static final String CAOLIAO_API_HEADER_AUTH = "Authorization";

    // ========== WebSocket 相关 ==========
    /** WebSocket 消息类型：二维码生成通知 */
    public static final String WS_MESSAGE_TYPE_QRCODE = "qrcode";
    /** WebSocket 消息类型：错误通知 */
    public static final String WS_MESSAGE_TYPE_ERROR = "error";

    // ========== 其他常量 ==========
    /** 二维码默认有效期（小时） */
    public static final int QRCODE_DEFAULT_EXPIRE_HOURS = 24000;
}