package com.dingtai.customermager.utils;

import org.slf4j.Logger;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Aes 加密解密
 *
 * @author zhangkj
 * @data 2018-10-18
 */
public class AesUtil {

    private static Logger logger = LogUtil.get();
    private final static String AES_ENCODING = "utf-8";
    private final static String AES = "AES";
    /**
     * "算法/模式/补码方式"
     */
    private final static String AES_CIPHER = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     *
     * @param sSrc 待加密的文本
     * @param sKey 密钥
     * @return
     * @throws Exception
     */
    public static String encrypt(String sSrc, String sKey, int type) {
        if (sKey == null) {
            return null;
        }
        // 判断Key是否为16位
        int size = 16;
        if (sKey.length() != size) {
            return null;
        }
        try {
            byte[] raw = sKey.getBytes(AES_ENCODING);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, AES);
            Cipher cipher = Cipher.getInstance(AES_CIPHER);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes(AES_ENCODING));
            if (type == 0) {
                return new Base64().encodeToString(encrypted);
            }
            String result = DataConvertUtil.parseByte2HexStr(encrypted);
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 解密
     *
     * @param sSrc 待解密的文本
     * @param sKey 密钥
     * @return
     * @throws Exception
     */
    public static String decrypt(String sSrc, String sKey, int type) {
        // 判断Key是否正确
        if (sKey == null) {
            return null;
        }
        // 判断Key是否为16位
        int size = 16;
        if (sKey.length() != size) {
            return null;
        }
        try {
            byte[] raw = sKey.getBytes(AES_ENCODING);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, AES);
            Cipher cipher = Cipher.getInstance(AES_CIPHER);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1;
            if (type == 0) {
                encrypted1 = new Base64().decode(sSrc);
            } else {
                encrypted1 = DataConvertUtil.parseHexStr2Byte(sSrc);
            }
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, AES_ENCODING);
            return originalString;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 获取通过Aes和Md5加密后的字符串
     *
     * @param orgin
     * @return
     */
    public static String getAesAndMd5Str(String orgin, String key) {
        // 加密
        String enString = AesUtil.encrypt(orgin, key, 0);
        String md5Code = Md5Util.encryptString(enString).toUpperCase();
        return md5Code;
    }

    public static void main(String[] args) throws Exception {
        // 此处使用AES-128-ECB加密模式，key需要为16位。
        String cKey = "cmcccmss12345678";
        // 需要加密的字串
        String cSrc = "PQgJcRik123#";
        System.out.println(cSrc);
        // 加密
        String enString = AesUtil.getAesAndMd5Str(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String deString = AesUtil.decrypt(enString, cKey, 1);
        System.out.println("解密后的字串是：" + deString);
    }
}