package com.method_one;

import com.method_one.FirstServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;


/**
 * 动态注册的第一种方式的第一步：
 * 自己写一个Servlet（继承 HttpServlet 即可）
 *
 * 第二步：注册登记这个 Servlet
 * 写一个类，实现 “Servlet容器初始化”接口，
 * 在方法里向上下文对象添加指定Servlet对象，
 * 并给这个Servlet一个访问地址
 *
 *第三步：
 * 在类路径（maven项目的类路径在 resources下）下，创建META-INF/services/javax.servlet.ServletContainerInitializer 文件
 *
 *第四步：
 * 在此文件中写入注册登记的Servlet的全称（我等注册登记的是：FirstServlet，全称是：com.method_one.FirstServlet ）
 *
 *
 * ServletContainerInitializer：servlet容器初始化
 */
public class RegisterServlet_Method1 implements ServletContainerInitializer {
    @Override //（实现此接口的所有类的set集合，上下文对象）
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        //Servlet登记.动态的，向上下文对象添加一个我们自己写的 Servlet。
        ServletRegistration.Dynamic servletRegistration=servletContext.addServlet("first",new FirstServlet());

        //为上面这个 Servlet 添加映射地址，当我访问此地址时就访问到上面这个 Servlet。
        servletRegistration.addMapping("/first");
    }
}
