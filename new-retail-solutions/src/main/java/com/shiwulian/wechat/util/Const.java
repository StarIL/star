package com.shiwulian.wechat.util;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import javax.validation.Validation;
import javax.validation.Validator;

import com.shiwulian.wechat.bean.bs.User;

public class Const {

    public static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    /**
     * 重置密码,存储手机号
     */
    public static final Map<String, Object> ResetPasswordUserToken = new ConcurrentHashMap<String, Object>();
    /**
     * 校验器传值
     */
    public static final Map<String, String> validatorResultToken = new ConcurrentHashMap<String, String>();
    /**
     * 注册公司传值
     */
    public static final Map<String, User> RegCompanyUserToken = new ConcurrentHashMap<String, User>();
    
    
    public static Properties AppProperties = null;

    static {
        AppProperties = new Properties();
        try {
            AppProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
