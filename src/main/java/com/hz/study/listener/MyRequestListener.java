package com.hz.study.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * http请求监听：
 * 1 实现ServletRequestListener接口
 * 2 加@WebListener注解标记为监听类
 * 3 启动类添加@ServletComponentScan注解，实现监听扫描
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {
        System.out.println("监听到请求结束！");
    }

    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        ServletContext servletContext = arg0.getServletContext();
        System.out.println("监听到请求发生！");

    }



}
