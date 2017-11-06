/*
 * 文 件 名:  SpringUtil.java
 * 版    权:  AndyGong (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  Andy/Gongzhuang
 * 修改时间:  2017年7月20日 下午11:35:41
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  Andy/Gongzhuang
 * @version  [IACCN V100R001C01,2017年7月20日 下午11:34:56]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SpringUtil implements BeanFactoryPostProcessor {

    private static ConfigurableListableBeanFactory beanFactory; // Spring应用上下文环境

    /**
     * 
     * <获取对象>
     * <功能详细描述>
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     * @see [类、类#方法、类#成员]
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name)
            throws BeansException {
        return (T) beanFactory.getBean(name);
    }
    /**
     * 
     * <获取类型为requiredType的对象>
     * <功能详细描述>
     * @param clz
     * @return
     * @throws BeansException
     * @see [类、类#方法、类#成员]
     */
    public static <T> T getBean(Class<T> clz)
            throws BeansException {
        T result = (T) beanFactory.getBean(clz);
        return result;
    }

    /**
     * 
     * <如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true>
     * <功能详细描述>
     * @param name
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }

    /**
     * 
     * <判断以给定名字注册的bean定义是一个singleton还是一个prototype。>
     * <如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）>
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     * @see [类、类#方法、类#成员]
     */
    public static boolean isSingleton(String name)
            throws NoSuchBeanDefinitionException {
        return beanFactory.isSingleton(name);
    }

    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param name
     * @return Class 注册对象的类型
     * @throws NoSuchBeanDefinitionException
     * @see [类、类#方法、类#成员]
     */
    public static Class<?> getType(String name)
            throws NoSuchBeanDefinitionException {
        return beanFactory.getType(name);
    }

    /**
     * 
     * <如果给定的bean名字在bean定义中有别名，则返回这些别名>
     * <功能详细描述>
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     * @see [类、类#方法、类#成员]
     */
    public static String[] getAliases(String name)
            throws NoSuchBeanDefinitionException {
        return beanFactory.getAliases(name);
    }

    /**
     * 
     * <获取上下文请求>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static HttpServletRequest getRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 
     * <获取当前会话>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 
     * <请求转换为文件请求>
     * <功能详细描述>
     * @param request
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static MultipartHttpServletRequest convertMultipartRequest(HttpServletRequest request) {
        CommonsMultipartResolver commonsMultipartResolver =
                new CommonsMultipartResolver(request.getSession().getServletContext());
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        MultipartHttpServletRequest multiPartRequest = commonsMultipartResolver.resolveMultipart(request);

        return multiPartRequest;
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        SpringUtil.beanFactory = beanFactory;
    }
}
