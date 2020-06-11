package com.peihan.spring.web.servlet;

import com.peihan.spring.web.handler.HandlerManager;
import com.peihan.spring.web.handler.MappingHandler;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author:peihan.Z
 * @date:2019/7/6 15:30
 * @description: ����ַ��������е����󶼻������ﴦ��
 */
public class DispatcherServlet implements Servlet {

    @Override
    public void init(ServletConfig config) {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        for (MappingHandler mappingHandler : HandlerManager.mappingHandlerList) {
            // �����е� MappingHandler ����һ���Դ�������
            // ���ĳ�� handler ���Դ���(����true)���򷵻ؼ���
            try {
                if (mappingHandler.handle(req, res)) {
                    return;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        res.getWriter().println("failed!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
