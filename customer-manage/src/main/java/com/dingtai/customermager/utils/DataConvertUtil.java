package com.dingtai.customermager.utils;

import org.slf4j.Logger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2019-03-20 11:22
 *  
 */
public class DataConvertUtil {

    /**
     * 日志
     */
    private static final Logger log = LogUtil.get();

    /**
     * 将ResultSet转成list
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static List resultSetToList(ResultSet rs) throws SQLException {

        if (rs == null) {
            return Collections.EMPTY_LIST;
        }
        //得到结果集(rs)的结构信息，比如字段数、字段名等
        ResultSetMetaData md = rs.getMetaData();
        //返回此 ResultSet 对象中的列数
        int columnCount = md.getColumnCount();
        List list = new ArrayList();
        Map rowData;
        while (rs.next()) {
            rowData = new ConcurrentHashMap(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                if (md.getColumnName(i) != null && rs.getObject(i) != null) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }

            }
            list.add(rowData);
        }
        return list;
    }

    /**
     * 将16进制转换为二进制 解密
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {

        if (hexStr.length() < 1) {
            return null;
        }
        int two = 2;
        byte[] result = new byte[hexStr.length() / two];
        for (int i = 0; i < hexStr.length() / two; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 将二进制转换成16进制 加密
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}
