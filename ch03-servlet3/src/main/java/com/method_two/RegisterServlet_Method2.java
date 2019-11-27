package com.method_two;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * ServletContainerInitializer ：Servlet容器初始化
 *
 * 动态注册Servlet的第二种方法
 * 第一步：写一个类，实现“Servlet容器初始化”接口
 * 第二步：写一个接口，如：MyAppInitailzer
 * 第三步：在“Servlet容器初始化实现类”上，
 * 写@HandlerTypes(MyAppInitailzer.class)，指定你的接口类型，
 * 用来告诉“Servlet容器初始化实现类”的
 * onStartup方法的第一个参数的值（所有实现了此接口的类Set集合）
 *
 * 第四步：在“Servlet容器初始化实现类”的写法一般就是：
 * 直接调用第二步接口所有实现类的某个方法
 * 第五步：还是在META-INF/services文件夹下面建立一个文件,文件名
 * 叫做第二步接口的全称
 */
@HandlesTypes(MyAppInitailzer.class)
public class RegisterServlet_Method2 implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

    }
}
