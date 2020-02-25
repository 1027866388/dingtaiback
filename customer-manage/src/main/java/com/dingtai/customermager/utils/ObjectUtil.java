package com.dingtai.customermager.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-25 11:47
 *  
 */
public class ObjectUtil {
    /**
     * 复制源对象和目标对象的属性值
     *
     * @param source
     * @param target
     * @throws Exception
     */
    public static void copy(Object source, Object target) throws Exception {

        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();
        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        for (Field sourceField : sourceFields) {
            String name = sourceField.getName();
            Class type = sourceField.getType();
            String methodName = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method getMethod = sourceClass.getMethod("get" + methodName);
            Object value = getMethod.invoke(source);
            for (Field targetField : targetFields) {
                String targetName = targetField.getName();
                if (targetName.equals(name)) {
                    Method setMethod = targetClass.getMethod("set" + methodName, type);
                    setMethod.invoke(target, value);
                }
            }
        }
    }
}
