package com.bearcat2.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p> Description: 获取 spring IOC容器 </p>
 * <p> Title: ApplicationContextHelper </p>
 * <p> Create Time: 2018/12/4 10:30 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    /** 定义成员变量接收并存储ioc容器 */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    /**
     * 通过bean类型从IOC容器取出对应的bean
     *
     * @param clazz bean的类型
     * @return 返回ioc容器中管理的bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 通过bean名称从IOC容器取出对应的bean
     *
     * @param beanName bean名称
     * @return 返回ioc容器中管理的bean
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    /**
     * 通过bean名称从IOC容器取出对应的bean类型的bean
     *
     * @param beanName bean名称
     * @return 返回ioc容器中管理的bean
     */
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return applicationContext.getBean(beanName, clazz);
    }

    /**
     * 判断bean是否是单例的
     *
     * @param beanName bean名称
     * @return true - 单例 false - 不是单例
     */
    public static boolean isSingleton(String beanName) {
        return applicationContext.isSingleton(beanName);
    }

    /**
     * 判断bean是否是原型的
     *
     * @param beanName bean名称
     * @return true - 原型 false - 不是原型
     */
    public static boolean isPrototype(String beanName) {
        return applicationContext.isPrototype(beanName);
    }

    /**
     * 判断ioc容器中是否包含某个bean
     *
     * @param beanName bean名称
     * @return true - 包含 false - 不包含
     */
    public static boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }

    /**
     * 获取ioc容器
     *
     * @return 返回ioc容器 - ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
