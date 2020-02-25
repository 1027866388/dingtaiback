package com.dingtai.customermager.utils;

import org.slf4j.Logger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * MD5加密
 *
 * @author wangyanhui
 */
public class Md5Util {
    private static Logger logger = LogUtil.get();

    /**
     * 生成MD5
     *
     * @param plaintext 明文
     * @return 密文
     */
    public static String encryptString(final String plaintext) {

        String ciphertext = "";
        try {
            // 创建一个md5算法对象
            final MessageDigest md = MessageDigest.getInstance("MD5");
            // 获得MD5字节数组,16*8=128位
            final byte[] messageByte = plaintext.getBytes(StandardCharsets.UTF_8);
            final byte[] md5Byte = md.digest(messageByte);
            // 转换为16进制字符串
            ciphertext = bytesToHex(md5Byte);
        } catch (final Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ciphertext;
    }

    /**
     * 二进制转十六进制
     *
     * @param bytes
     * @return
     */
    private static String bytesToHex(final byte[] bytes) {

        final StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
            if (num < 0) {
                num += 256;
            }
            if (num < 16) {
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }
}
