package com.dingtai.customermager.utils;

import com.dingtai.customermager.constants.PermissionConstant;
import com.dingtai.customermager.entity.db.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;

/**
 * 权限工具类
 *
 * @author wangyanhui
 * @date 2018-03-20 19:43
 */
public class ShiroUtils {
    private static final Logger logger = LogUtil.get();

    /**
     * 获取Session
     *
     * @return Session
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }


    /**
     * 获取主题
     *
     * @return 主题
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }


    /**
     * 获取用户实体
     *
     * @return 用户实体
     */
    public static UserEntity getUserEntity() {
        try {
            return (UserEntity) SecurityUtils.getSubject().getPrincipal();
        } catch (UnknownSessionException e) {
            return null;
        }

    }

    /**
     * 获取用户id
     *
     * @return
     */
    public static Long getUserId() {
        if (getUserEntity() != null) {
            return getUserEntity().getId();
        } else {
            return PermissionConstant.UN_CERTIFIED;
        }
    }

    /**
     * 设置Session属性
     *
     * @param key   键
     * @param value 值
     */
    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 获取Session属性
     *
     * @param key 键
     * @return 对象
     */
    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    /**
     * 是否登录
     *
     * @return
     */
    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    /**
     * 用户注销
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 获取验证码
     *
     * @param key
     * @return
     */
    public static String getKaptcha(String key) {
        String kaptcha = StringUtil.EMPTY;
        if (getSessionAttribute(key) != null) {
            kaptcha = getSessionAttribute(key).toString();
            getSession().removeAttribute(key);
        }
        return kaptcha;
    }
}
